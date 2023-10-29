package pe.tecsup.itravel_api.service;

import org.springframework.beans.factory.annotation.Autowired;
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

}
