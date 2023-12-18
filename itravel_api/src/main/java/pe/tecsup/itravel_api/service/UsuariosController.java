package pe.tecsup.itravel_api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.tecsup.itravel_api.repository.UsuariosRepository;
import pe.tecsup.itravel_api.model.Usuarios;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itravel/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosRepository usuariosRepository;


    @GetMapping("/getAll")
    public List<Usuarios> getAll() {return usuariosRepository.findAll();}


    @GetMapping("/getByUid/{uid}")
    public Optional<Usuarios> getByUid(@PathVariable ("uid") String uid)
    {
        return usuariosRepository.findByUid(uid);
    }

    @PostMapping("/crearUsuario")
    public Usuarios crearUsuario(@RequestBody Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    @PutMapping("/editarUsuario/{uid}")
    public Usuarios editarUsuario(@PathVariable("uid") String uid, @RequestBody Usuarios usuarioActualizado) {
        Optional<Usuarios> usuarioExistente = usuariosRepository.findByUid(uid);

        if (usuarioExistente.isPresent()) {
            Usuarios usuario = usuarioExistente.get();

            // Actualizar solo los campos que se enviaron en el cuerpo de la solicitud
            if (usuarioActualizado.getRol() != null) {
                usuario.setRol(usuarioActualizado.getRol());
            }
            if (usuarioActualizado.getFoto() != null) {
                usuario.setFoto(usuarioActualizado.getFoto());
            }
            if (usuarioActualizado.getNombrecompleto() != null) {
                usuario.setNombrecompleto(usuarioActualizado.getNombrecompleto());
            }
            if (usuarioActualizado.getTelefono() != null) {
                usuario.setTelefono(usuarioActualizado.getTelefono());
            }
            if (usuarioActualizado.getEstado() != null) {
                usuario.setEstado(usuarioActualizado.getEstado());
            }

            return usuariosRepository.save(usuario);
        } else {
            // Manejar el caso en que el usuario no exista
            return null;
        }
    }


    // Nueva ruta para la autenticación por nombre y teléfono
    @PostMapping("/autenticarUsuario")
    public ResponseEntity<?> autenticarUsuario(@RequestBody Usuarios datosAutenticacion) {
        // Obtener el nombre y el teléfono del cuerpo de la solicitud
        String nombre = datosAutenticacion.getNombrecompleto();
        String dni = datosAutenticacion.getDni();

        // Consultar la base de datos para verificar las credenciales
        Optional<Usuarios> usuarioExistente = usuariosRepository.findByNombrecompletoAndDni(nombre, dni);

        // Verificar si las credenciales son válidas
        if (usuarioExistente.isPresent()) {
            // Usuario autenticado correctamente
            Usuarios usuarioAutenticado = usuarioExistente.get();
            return new ResponseEntity<>(usuarioAutenticado, HttpStatus.OK);
        } else {
            // Usuario no autenticado
            return new ResponseEntity<>("Nombre dni incorrecto", HttpStatus.UNAUTHORIZED);
        }
    }


}