package pe.tecsup.itravel_api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.tecsup.itravel_api.repository.ChoferesRepository;
import pe.tecsup.itravel_api.model.Choferes;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itravel/choferes")
public class ChoferesController {

    @Autowired
    private ChoferesRepository choferesRepository;

    @GetMapping("/getAll")
    public List<Choferes> getAll() {
        return choferesRepository.findAll();
    }


    @GetMapping("/getById/{id}")
    public Optional<Choferes> getChoferesById(@PathVariable ("id") int id)
    {
        return choferesRepository.findById(id);
    }

    @PostMapping("/crearChofer")
    public Choferes crearChofer(@RequestBody Choferes choferes) {
        return choferesRepository.save(choferes);
    }

    @PutMapping("/editarChofer/{id}")
    public Choferes editarChofer(@PathVariable("id") int id, @RequestBody Choferes choferActualizado) {
        // Buscar el chofer existente por su ID
        Optional<Choferes> choferExistente = choferesRepository.findById(id);

        if (choferExistente.isPresent()) {
            Choferes chofer = choferExistente.get();

            // Actualizar los campos del chofer con los valores proporcionados en la solicitud
            chofer.setNombre(choferActualizado.getNombre());
            chofer.setDni(choferActualizado.getDni());

            // Guardar el chofer actualizado en la base de datos
            return choferesRepository.save(chofer);
        } else {
            return null;
        }
    }



}
