/*

ESTO YA NO SIRVE


package pe.tecsup.itravel_api.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuario_id;

    private String usuario_uid_fb;
    private UserRole usuario_rol;
    private String usuario_foto;

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario_uid_fb() {
        return usuario_uid_fb;
    }

    public void setUsuario_uid_fb(String usuario_uid_fb) {
        this.usuario_uid_fb = usuario_uid_fb;
    }

    public UserRole getUsuario_rol() {
        return usuario_rol;
    }

    public void setUsuario_rol(UserRole usuario_rol) {
        this.usuario_rol = usuario_rol;
    }

    public String getUsuario_foto() {
        return usuario_foto;
    }

    public void setUsuario_foto(String usuario_foto) {
        this.usuario_foto = usuario_foto;
    }

    public enum UserRole {
        CLIENTE,
        EMPRESA_DE_TRANSPORTE
    }
}

 */
