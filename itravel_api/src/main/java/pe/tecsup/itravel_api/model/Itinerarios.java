package pe.tecsup.itravel_api.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "itinerarios")
public class Itinerarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private int boletoid;
    private String horasalida;
    private String horallegada;
    private int estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBoletoid() {
        return boletoid;
    }

    public void setBoletoid(int boletoid) {
        this.boletoid = boletoid;
    }

    public String getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(String horasalida) {
        this.horasalida = horasalida;
    }

    public String getHorallegada() {
        return horallegada;
    }

    public void setHorallegada(String horallegada) {
        this.horallegada = horallegada;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
