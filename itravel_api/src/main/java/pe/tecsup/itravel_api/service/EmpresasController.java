package pe.tecsup.itravel_api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.tecsup.itravel_api.model.EmpresasTransporte;
import pe.tecsup.itravel_api.repository.EmpresasRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itravel/empresas")
public class EmpresasController {

    @Autowired
    private EmpresasRepository empresasRepository;

    @GetMapping("/getAll")
    public List<EmpresasTransporte> getAll() {
        return empresasRepository.findAll();
    }


    @GetMapping("/getById/{id}")
    public Optional<EmpresasTransporte> getEmpresasById(@PathVariable ("id") int id)
    {
        return empresasRepository.findById(id);
    }

    @PostMapping("/crearEmpresa")
    public EmpresasTransporte crearEmpresa(@RequestBody EmpresasTransporte empresasTransporte) {
        return empresasRepository.save(empresasTransporte);
    }

    @PutMapping("/editarEmpresa/{id}")
    public EmpresasTransporte editarEmpresa(@PathVariable("id") int id, @RequestBody EmpresasTransporte empresaActualizada) {
        // Buscar la empresa existente por su ID
        Optional<EmpresasTransporte> empresaExistente = empresasRepository.findById(id);

        if (empresaExistente.isPresent()) {
            EmpresasTransporte empresa = empresaExistente.get();

            // Actualizar los campos de la empresa con los valores proporcionados en la solicitud
            empresa.setNombre(empresaActualizada.getNombre());
            empresa.setDireccion(empresaActualizada.getDireccion());
            empresa.setTelefono(empresaActualizada.getTelefono());
            empresa.setRutas(empresaActualizada.getRutas());

            // Guardar la empresa actualizada en la base de datos
            return empresasRepository.save(empresa);
        } else {
            // null en caso de que la empresa no exista.
            return null;
        }
    }

}
