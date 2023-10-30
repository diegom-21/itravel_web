package pe.tecsup.itravel_api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.tecsup.itravel_api.repository.BoletosRepository;
import pe.tecsup.itravel_api.model.Boletos;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itravel/boletos")
public class BoletosController {
    @Autowired
    private BoletosRepository boletosRepository;

    @GetMapping("/getAll")
    public List<Boletos> getAll() {
        return boletosRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<Boletos> getById(@PathVariable("id") int id) {
        return boletosRepository.findById(id);
    }

    @PostMapping("/crearBoleto")
    public Boletos crearBoleto(@RequestBody Boletos boleto) {
        return boletosRepository.save(boleto);
    }

    @PutMapping("/editarBoleto/{id}")
    public Boletos editarBoleto(@PathVariable("id") int id, @RequestBody Boletos boletoActualizado) {
        Optional<Boletos> boletoExistente = boletosRepository.findById(id);

        if (boletoExistente.isPresent()) {
            Boletos boleto = boletoExistente.get();

            boleto.setBusid(boletoActualizado.getBusid());
            boleto.setUsuariouid(boletoActualizado.getUsuariouid());
            boleto.setPrecio(boletoActualizado.getPrecio());
            boleto.setFechacompra(boletoActualizado.getFechacompra());
            boleto.setEstado(boletoActualizado.getEstado());

            return boletosRepository.save(boleto);
        } else {
            return null;
        }
    }

    @PutMapping("/eliminarBoleto/{id}")
    public Boletos eliminarBoleto(@PathVariable("id") int id, @RequestBody(required = false) Boletos boletoActualizado) {
        Optional<Boletos> boletoExistente = boletosRepository.findById(id);

        if (boletoExistente.isPresent()) {
            Boletos boleto = boletoExistente.get();

            if (boletoActualizado != null && boletoActualizado.getEstado() != 0) {
                boleto.setEstado(boletoActualizado.getEstado());
            } else {
                boleto.setEstado(0);
            }

            return boletosRepository.save(boleto);
        } else {
            return null;
        }
    }
}
