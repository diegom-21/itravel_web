package pe.tecsup.itravel_api.model;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "buses")
public class Buses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String placa;

    private int numeroasientos;

    private int empresaid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumeroasientos() {
        return numeroasientos;
    }

    public void setNumeroasientos(int numeroasientos) {
        this.numeroasientos = numeroasientos;
    }

    public int getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(int empresaid) {
        this.empresaid = empresaid;
    }
}
