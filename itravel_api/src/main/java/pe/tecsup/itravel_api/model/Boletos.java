package pe.tecsup.itravel_api.model;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "boletos")
public class Boletos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private int pasajeid;
    private int busid;
    private int usuariouid;
    private float precio;
    private String fechacompra;
    private int estado;
    private int asiento;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBusid() {
        return busid;
    }

    public void setBusid(int busid) {
        this.busid = busid;
    }

    public int getUsuariouid() {
        return usuariouid;
    }

    public void setUsuariouid(int usuariouid) {
        this.usuariouid = usuariouid;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getFechacompra() {
        return fechacompra;
    }

    public void setFechacompra(String fechacompra) {
        this.fechacompra = fechacompra;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public int getPasajeid() {
        return pasajeid;
    }

    public void setPasajeid(int pasajeid) {
        this.pasajeid = pasajeid;
    }
}
