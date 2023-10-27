package pe.tecsup.itravel_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RestController
@RequestMapping("/itravel/login")
public class UserController {

    @Autowired
    private EntityManager entityManager;


    // CREE ESTE METODO PARA QUE SE COMPRUEBE QUE ESTA CONECTADO A LA BD DE AWS
    @GetMapping("/obtenertodo")
    public ResponseEntity<List<Object[]>> getAll() {
        // Consulta nativa para obtener todos los registros de la tabla "Usuarios"
        String sql = "SELECT * FROM Usuarios";
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> results = query.getResultList();
        return ResponseEntity.ok(results);
    }


    //ESTE METODO Y LO DE ABAJO AUN FALTA CONFIGURAR, EN POSTAM SALE ERROR SERVIDOR
    @PostMapping("/auth")
    public ResponseEntity<String> login(@RequestBody String usuario_uid_fb) {
        // Lógica de validación de credenciales
        LoginResult loginResult = validateCredentials(usuario_uid_fb);

        // Devuelve una respuesta HTTP apropiada según el resultado de la validación
        switch (loginResult) {
            case LOGIN_SUCCESSFUL:
                return ResponseEntity.ok("Logeado exitosamente");
            case INVALID_CREDENTIALS:
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
            case USER_NOT_FOUND:
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado :(");
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR DEL SERVIDOR");
        }
    }

    public enum LoginResult {
        LOGIN_SUCCESSFUL,
        INVALID_CREDENTIALS,
        USER_NOT_FOUND
    }

    //PARECE QUE ACA ES EL PROBLEMA
    public LoginResult validateCredentials(String usuario_uid_fb) {
        // Realiza una consulta nativa para validar las credenciales en la tabla "Usuarios"
        String sql = "SELECT usuario_rol FROM Usuarios WHERE usuario_uid_fb = :usuario_uid_fb";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("usuario_uid_fb", usuario_uid_fb);

        List<Object> results = query.getResultList();
        if (results.size() > 0) {
            return LoginResult.LOGIN_SUCCESSFUL;
        } else {
            return LoginResult.USER_NOT_FOUND;
        }
    }
}
