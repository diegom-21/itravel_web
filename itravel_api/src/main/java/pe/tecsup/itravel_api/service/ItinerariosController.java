package pe.tecsup.itravel_api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.tecsup.itravel_api.repository.ItinerariosRepository;
import pe.tecsup.itravel_api.model.Itinerarios;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itravel/itinerarios")
public class ItinerariosController {
    @Autowired
    private ItinerariosRepository itinerariosRepository;

    @GetMapping("/getAll")
    public List<Itinerarios> getAll() {
        return itinerariosRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<Itinerarios> getById(@PathVariable("id") int id) {
        return itinerariosRepository.findById(id);
    }

    @PostMapping("/crearItinerario")
    public Itinerarios crearItinerario(@RequestBody Itinerarios itinerario) {
        return itinerariosRepository.save(itinerario);
    }

    @PutMapping("/editarItinerario/{id}")
    public Itinerarios editarItinerario(@PathVariable("id") int id, @RequestBody Itinerarios itinerarioActualizado) {
        Optional<Itinerarios> itinerarioExistente = itinerariosRepository.findById(id);

        if (itinerarioExistente.isPresent()) {
            Itinerarios itinerario = itinerarioExistente.get();

            itinerario.setBoletoid(itinerarioActualizado.getBoletoid());
            itinerario.setHorasalida(itinerarioActualizado.getHorasalida());
            itinerario.setHorallegada(itinerarioActualizado.getHorallegada());
            itinerario.setEstado(itinerarioActualizado.getEstado());

            return itinerariosRepository.save(itinerario);
        } else {
            return null;
        }
    }

    @PutMapping("/eliminarItinerario/{id}")
    public Itinerarios eliminarItinerario(@PathVariable("id") int id, @RequestBody(required = false) Itinerarios itinerarioActualizado) {
        Optional<Itinerarios> itinerarioExistente = itinerariosRepository.findById(id);

        if (itinerarioExistente.isPresent()) {
            Itinerarios itinerario = itinerarioExistente.get();

            if (itinerarioActualizado != null && itinerarioActualizado.getEstado() != 0) {
                itinerario.setEstado(itinerarioActualizado.getEstado());
            } else {
                itinerario.setEstado(0);
            }

            return itinerariosRepository.save(itinerario);
        } else {
            return null;
        }
    }
}
