package pe.tecsup.itravel_api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.tecsup.itravel_api.repository.BusesRepository;
import pe.tecsup.itravel_api.model.Buses;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itravel/buses")
public class BusesController {
    @Autowired
    private BusesRepository busesRepository;

    @GetMapping("/getAll")
    public List<Buses> getAll(){
        return busesRepository.findAll();
    }

    @GetMapping("/getByPlaca/{placa}")
    public Optional<Buses> getByPlaca(@PathVariable ("placa") String placa){
        return busesRepository.findByPlaca(placa);
    }


    @PostMapping("/crearBus")
    public Buses crearBus(@RequestBody Buses buses){
        return busesRepository.save(buses);
    }

    @PutMapping("/editarBus/{placa}")
    public Buses editarBus(@PathVariable("placa") String placa, @RequestBody Buses busActualizado) {
        // Buscar el bus existente por su placa
        Optional<Buses> busExistente = busesRepository.findByPlaca(placa);

        if (busExistente.isPresent()) {
            Buses bus = busExistente.get();

            // Actualizar los campos del bus con los valores proporcionados en la solicitud
            bus.setNumeroasientos(busActualizado.getNumeroasientos());
            bus.setEmpresaid(busActualizado.getEmpresaid());


            // Guardar el bus actualizado
            return busesRepository.save(bus);
        } else {
            // Si el bus no se encuentra, retornar un mensaje de error
            return null;
        }
    }






}
