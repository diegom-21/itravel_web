package pe.tecsup.itravel_api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.tecsup.itravel_api.repository.RutasRepository;
import pe.tecsup.itravel_api.model.Rutas;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itravel/rutas")
public class RutasController {
    @Autowired
    private RutasRepository rutasRepository;

    @GetMapping("/getAll")
    public List<Rutas> getAllRutas() {
        return rutasRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<Rutas> getRutasById(@PathVariable("id") int id) {
        return rutasRepository.findById(id);
    }

    @PostMapping("/crearRuta")
    public Rutas crearRuta(@RequestBody Rutas ruta) {
        return rutasRepository.save(ruta);
    }

    @PutMapping("/editarRuta/{id}")
    public Rutas editarRuta(@PathVariable("id") int id, @RequestBody Rutas rutaActualizada) {
        Optional<Rutas> rutaExistente = rutasRepository.findById(id);

        if (rutaExistente.isPresent()) {
            Rutas ruta = rutaExistente.get();

            ruta.setOrigenciudad(rutaActualizada.getOrigenciudad());
            ruta.setDestinociudad(rutaActualizada.getDestinociudad());
            ruta.setDuracionviaje(rutaActualizada.getDuracionviaje());
            ruta.setDistancia(rutaActualizada.getDistancia());
            ruta.setPrecio(rutaActualizada.getPrecio());
            ruta.setEmpresaid(rutaActualizada.getEmpresaid());

            return rutasRepository.save(ruta);
        } else {
            return null;
        }
    }

    @PutMapping("/eliminarRuta/{id}")
    public Rutas eliminarRuta(@PathVariable("id") int id, @RequestBody(required = false) Rutas rutaActualizada) {
        Optional<Rutas> rutaExistente = rutasRepository.findById(id);

        if (rutaExistente.isPresent()) {
            Rutas ruta = rutaExistente.get();

            if (rutaActualizada != null) {
                rutasRepository.delete(ruta);
            } else {
                return null;
            }
        }
        return null;
    }
}
