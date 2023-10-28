package pe.tecsup.itravel_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import pe.tecsup.itravel_api.service.UsuarioService;
import java.util.Map;

@RestController
@RequestMapping("/itravel/login")
public class UserController {
    private final UsuarioService usuarioService;

    @Autowired
    public UserController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    public List<Map<String, Object>> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping("/nuevo")
    public void insertarUsuario(@RequestBody Map<String, String> usuarioData) {
        usuarioService.insertarUsuario(
                usuarioData.get("usuario_uid_fb"),
                usuarioData.get("usuario_rol"),
                usuarioData.get("usuario_foto")
        );
    }

    @PutMapping("/actualizar/{id}")
    public void actualizarUsuario(@PathVariable Long id, @RequestBody Map<String, String> usuarioData) {
        usuarioService.actualizarUsuario(
                id,
                usuarioData.get("usuario_uid_fb"),
                usuarioData.get("usuario_rol"),
                usuarioData.get("usuario_foto")
        );
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
    }
}

