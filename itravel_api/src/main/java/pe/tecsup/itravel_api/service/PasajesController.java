package pe.tecsup.itravel_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pe.tecsup.itravel_api.model.*;
import pe.tecsup.itravel_api.repository.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itravel/pasajes")
public class PasajesController {
    @Autowired
    private PasajesRepository pasajesRepository;
    @Autowired
    private BusesRepository busesRepository;

    @Autowired
    private EmpresasRepository empresasRepository;

    @Autowired
    private ChoferesRepository choferesRepository;

    @Autowired
    private RutasRepository rutasRepository;

    @GetMapping("/getById/{id}")
    public Optional<Pasajes> getById(@PathVariable("id") int id) {
        Optional<Pasajes> pasaje = pasajesRepository.findById(id);

        pasaje.ifPresent(p -> {
            Optional<Buses> bus = busesRepository.findById(p.getBusid());
            bus.ifPresent(p::setBus);
        });

        pasaje.ifPresent(p -> {
            Optional<Choferes> chofer = choferesRepository.findById(p.getChoferid());
            chofer.ifPresent(p::setChofer);
        });

        pasaje.ifPresent(p -> {
            Optional<EmpresasTransporte> empresa = empresasRepository.findById(p.getEmpresaid());
            empresa.ifPresent(p::setEmpresa);
        });

        pasaje.ifPresent(p -> {
            Optional<Rutas> ruta = rutasRepository.findById(p.getRutasid());
            ruta.ifPresent(p::setRuta);
        });

        return pasaje;
    }

    @GetMapping("/getAll")
    public List<Pasajes> getAll() {
        List<Pasajes> pasajes = pasajesRepository.findAll();

        for (Pasajes p : pasajes) {
            Optional<Buses> bus = busesRepository.findById(p.getBusid());
            bus.ifPresent(p::setBus);

            Optional<Choferes> chofer = choferesRepository.findById(p.getChoferid());
            chofer.ifPresent(p::setChofer);

            Optional<EmpresasTransporte> empresa = empresasRepository.findById(p.getEmpresaid());
            empresa.ifPresent(p::setEmpresa);

            Optional<Rutas> ruta = rutasRepository.findById(p.getRutasid());
            ruta.ifPresent(p::setRuta);
        }

        return pasajes;
    }

    @PostMapping("/crearPasaje")
    public Pasajes crearPasaje(@RequestBody Pasajes pasaje) {
        return pasajesRepository.save(pasaje);
    }


    @PutMapping("/editarPasaje/{id}")
    public Pasajes editarPasaje(@PathVariable("id") int id, @RequestBody Pasajes pasajeActualizado) {
        Optional<Pasajes> pasajeExistente = pasajesRepository.findById(id);

        if (pasajeExistente.isPresent()) {
            Pasajes pasaje = pasajeExistente.get();

            pasaje.setBusid(pasajeActualizado.getBusid());
            pasaje.setEmpresaid(pasajeActualizado.getEmpresaid());
            pasaje.setFechahorasalida(pasajeActualizado.getFechahorasalida());
            pasaje.setChoferid(pasajeActualizado.getChoferid());
            pasaje.setRutasid(pasajeActualizado.getRutasid());
            pasaje.setEstado(pasajeActualizado.getEstado());

            return pasajesRepository.save(pasaje);
        } else {
            return null;
        }
    }

    @GetMapping("/buscar")
    public List<Pasajes> buscarPasajes(@RequestParam("fechahorasalida") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechahorasalida, @RequestParam("origenciudad") String origenciudad, @RequestParam("destinociudad") String destinociudad) {
        List<Pasajes> pasajes = pasajesRepository.findByFechaHoraSalidaAndOrigenCiudadAndDestinoCiudad(fechahorasalida, origenciudad, destinociudad);

        for (Pasajes p : pasajes) {
            Optional<Buses> bus = busesRepository.findById(p.getBusid());
            bus.ifPresent(p::setBus);

            Optional<Choferes> chofer = choferesRepository.findById(p.getChoferid());
            chofer.ifPresent(p::setChofer);

            Optional<EmpresasTransporte> empresa = empresasRepository.findById(p.getEmpresaid());
            empresa.ifPresent(p::setEmpresa);

            Optional<Rutas> ruta = rutasRepository.findById(p.getRutasid());
            ruta.ifPresent(p::setRuta);
        }

        return pasajes;
    }


//    @GetMapping("/buscar")
//    public List<Pasajes> buscarPasajes(@RequestParam("fechahorasalida") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechahorasalida, @RequestParam("origenciudad") String origenciudad, @RequestParam("destinociudad") String destinociudad) {
//        return pasajesRepository.findByFechaHoraSalidaAndOrigenCiudadAndDestinoCiudad(fechahorasalida, origenciudad, destinociudad);
//    }

    @PutMapping("/eliminarPasaje/{id}")
    public Pasajes eliminarPasaje(@PathVariable("id") int id, @RequestBody(required = false) Pasajes pasajeActualizado) {
        Optional<Pasajes> pasajeExistente = pasajesRepository.findById(id);

        if (pasajeExistente.isPresent()) {
            Pasajes pasaje = pasajeExistente.get();

            if (pasajeActualizado != null && pasajeActualizado.getEstado() != 0) {
                pasaje.setEstado(pasajeActualizado.getEstado());
            } else {
                pasaje.setEstado(0);
            }

            return pasajesRepository.save(pasaje);
        } else {
            return null;
        }
    }
}
