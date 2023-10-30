package pe.tecsup.itravel_api.service;
import org.springframework.beans.factory.annotation.Autowired;
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
        // Buscar el usuario existente por su UID
        Optional<Usuarios> usuarioExistente = usuariosRepository.findByUid(uid);

        if (usuarioExistente.isPresent()) {
            Usuarios usuario = usuarioExistente.get();

            // Actualizar los campos del usuario con los valores proporcionados en la solicitud
            usuario.setRol(usuarioActualizado.getRol());
            usuario.setFoto(usuarioActualizado.getFoto());

            // Guardar el usuario actualizado en la base de datos
            return usuariosRepository.save(usuario);

        } else {
            // null en caso de que la empresa no exista.
            return null;
        }
    }


}