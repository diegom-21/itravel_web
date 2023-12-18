package pe.tecsup.itravel_api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "pasajes")
public class Pasajes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private int busid;
    private int empresaid;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Lima")
    private Date fechahorasalida;
    private int choferid;
    private int rutasid;
    private int estado;
    @Transient
    private Buses bus;
    @Transient
    private EmpresasTransporte empresa;
    @Transient
    private Choferes chofer;
    @Transient
    private Rutas ruta;

    public Choferes getChofer() {
        return chofer;
    }

    public void setChofer(Choferes chofer) {
        this.chofer = chofer;
    }

    public EmpresasTransporte getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresasTransporte empresa) {
        this.empresa = empresa;
    }

    public Rutas getRuta() {
        return ruta;
    }

    public void setRuta(Rutas ruta) {
        this.ruta = ruta;
    }

    public Buses getBus() {
        return bus;
    }

    public void setBus(Buses bus) {
        this.bus = bus;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getBusid() {
        return busid;
    }

    public void setBusid(int busid) {
        this.busid = busid;
    }

    public int getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(int empresaid) {
        this.empresaid = empresaid;
    }

    public Date getFechahorasalida() {
        return fechahorasalida;
    }

    public void setFechahorasalida(Date fechahorasalida) {
        this.fechahorasalida = fechahorasalida;
    }

    public int getChoferid() {
        return choferid;
    }

    public void setChoferid(int choferid) {
        this.choferid = choferid;
    }

    public int getRutasid() {
        return rutasid;
    }

    public void setRutasid(int rutasid) {
        this.rutasid = rutasid;
    }


}
