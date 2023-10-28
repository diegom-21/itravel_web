package pe.tecsup.itravel_api.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsuarioService{
    private final JdbcTemplate jdbcTemplate;

    public UsuarioService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> listarUsuarios() {
        String sql = "SELECT * FROM Usuarios";
        return jdbcTemplate.queryForList(sql);
    }

    public void insertarUsuario(String uidFb, String rol, String foto) {
        String sql = "INSERT INTO Usuarios (usuario_uid_fb, usuario_rol, usuario_foto) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, uidFb, rol, foto);
    }

    public void actualizarUsuario(Long id, String uidFb, String rol, String foto) {
        String sql = "UPDATE Usuarios SET usuario_uid_fb = ?, usuario_rol = ?, usuario_foto = ? WHERE usuario_id = ?";
        jdbcTemplate.update(sql, uidFb, rol, foto, id);
    }

    public void eliminarUsuario(Long id) {
        String sql = "DELETE FROM Usuarios WHERE usuario_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
