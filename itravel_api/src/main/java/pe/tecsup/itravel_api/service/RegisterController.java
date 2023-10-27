/*

LO COMENTO PORQUE SALE ERROR

package pe.tecsup.itravel_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.tecsup.itravel_api.model.User;
import pe.tecsup.itravel_api.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;


// Controlador REST que maneja las operaciones relacionadas con el registro de nuevos usuarios
@RestController
@RequestMapping("/itravel/registrar")
public class RegisterController {

    // Inyección de dependencia del repositorio de usuarios
    @Autowired
    private UserRepository userRepository;


    // Método que maneja la creación de un nuevo usuario mediante una solicitud POST
    @PostMapping("/nuevoUsuario")
    public User registrarNuevoUsuario(@RequestBody User nuevoUsuario) {
        // Establece el ID del nuevo usuario como 0 (puede variar según tu lógica)
        nuevoUsuario.setId(0);

        // Guarda el nuevo usuario en la base de datos utilizando el repositorio UserRepository.
        return userRepository.save(nuevoUsuario);
    }

}

*/