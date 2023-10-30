package pe.tecsup.itravel_api.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "empresastransporte")
public class EmpresasTransporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private int rutas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getRutas() {
        return rutas;
    }

    public void setRutas(int rutas) {
        this.rutas = rutas;
    }
}
