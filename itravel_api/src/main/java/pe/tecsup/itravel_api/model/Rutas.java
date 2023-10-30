package pe.tecsup.itravel_api.model;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "rutas")
public class Rutas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String origenciudad;
    private String destinociudad;
    private String duracionviaje;
    private float distancia;
    private float precio;
    private int empresaid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigenciudad() {
        return origenciudad;
    }

    public void setOrigenciudad(String origenciudad) {
        this.origenciudad = origenciudad;
    }

    public String getDestinociudad() {
        return destinociudad;
    }

    public void setDestinociudad(String destinociudad) {
        this.destinociudad = destinociudad;
    }

    public String getDuracionviaje() {
        return duracionviaje;
    }

    public void setDuracionviaje(String duracionviaje) {
        this.duracionviaje = duracionviaje;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(int empresaid) {
        this.empresaid = empresaid;
    }
}
