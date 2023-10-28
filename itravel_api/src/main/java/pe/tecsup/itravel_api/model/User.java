/*
package pe.tecsup.itravel_api.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Usuarios")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "usuario_uid_fb", nullable = false, length = 255)
    private String uidFb;

    @Column(name = "usuario_rol", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private RolUsuario rol;

    @Column(name = "usuario_foto", nullable = true, length = 45)
    private String foto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUidFb() {
        return uidFb;
    }

    public void setUidFb(String uidFb) {
        this.uidFb = uidFb;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public enum RolUsuario {
        CLIENTE,
        EMPRESA_DE_TRANSPORTE
    }



}

 */


