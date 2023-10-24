package pe.tecsup.itravel_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.tecsup.itravel_api.model.User;
import pe.tecsup.itravel_api.repository.UserRepository;

import java.util.Optional;
// Controlador REST que maneja las operaciones relacionadas con la autenticación de usuarios
@RestController
@RequestMapping("/itravel/login")
public class UserController {
    // Inyección de dependencia del repositorio de usuarios
    @Autowired
    private UserRepository userRepository;


    // Método que maneja la autenticación de usuarios mediante una solicitud POST
    @PostMapping("/auth")
    public ResponseEntity<String> login(@RequestBody User user) {
        String username = user.getEmail();
        String password = user.getPassword();

        // Lógica de validación de credenciales
        LoginResult loginResult = validateCredentials(username, password);

        // Devuelve una respuesta HTTP apropiada según el resultado de la validación
        switch (loginResult) {
            case LOGIN_SUCCESSFUL:
                return ResponseEntity.ok("Logeado successful");
            case INVALID_CREDENTIALS:
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales Erroneas");
            case USER_NOT_FOUND:
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado :(");
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR DEL SERVIDOR");
        }
    }

    // Enumeración que representa los posibles resultados de la validación de credenciales
    public enum LoginResult {
        LOGIN_SUCCESSFUL,
        INVALID_CREDENTIALS,
        USER_NOT_FOUND
    }

    // Método que valida las credenciales del usuario
    public LoginResult validateCredentials(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (password.equals(user.getPassword())) {
                return LoginResult.LOGIN_SUCCESSFUL;
            } else {
                return LoginResult.INVALID_CREDENTIALS;
            }
        }
        return LoginResult.USER_NOT_FOUND;
    }

}
