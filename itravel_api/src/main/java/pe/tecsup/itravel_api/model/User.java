package pe.tecsup.itravel_api.model;
import lombok.Data;
import javax.persistence.*;

// Anotación para indicar que esta clase es una entidad JPA
@Data
@Entity

// Definición de la tabla en la base de datos

@Table(name = "user")
public class User {

    // Indicar que este campo es la clave primaria y es autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    // Campos para almacenar el email y contraseña del usuario
    private String email;
    private String password;


    // Métodos de acceso para el campo 'id'
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Métodos de acceso para el campo 'email'
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Métodos de acceso para el campo 'password'
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}

