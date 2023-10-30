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
        Optional<Usuarios> usuarioExistente = usuariosRepository.findByUid(uid);

        if (usuarioExistente.isPresent()) {
            Usuarios usuario = usuarioExistente.get();

            usuario.setRol(usuarioActualizado.getRol());
            usuario.setFoto(usuarioActualizado.getFoto());
            usuario.setNombrecompleto(usuarioActualizado.getNombrecompleto());
            usuario.setTelefono(usuarioActualizado.getTelefono());
            usuario.setEstado(usuarioActualizado.getEstado());
            return usuariosRepository.save(usuario);
        } else {
            return null;
        }
    }

    @PutMapping("/eliminarUsuario/{uid}")
    public Usuarios eliminarUsuario(@PathVariable("uid") String uid, @RequestBody(required = false) Usuarios usuarioActualizado) {
        Optional<Usuarios> usuarioExistente = usuariosRepository.findByUid(uid);

        if (usuarioExistente.isPresent()) {
            Usuarios usuario = usuarioExistente.get();

            if (usuarioActualizado != null && usuarioActualizado.getEstado() != null) {
                usuario.setEstado(usuarioActualizado.getEstado());
            } else {
                usuario.setEstado(0);
            }

            return usuariosRepository.save(usuario);
        } else {
            return null;
        }
    }

}