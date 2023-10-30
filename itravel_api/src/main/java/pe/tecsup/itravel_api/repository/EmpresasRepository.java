package pe.tecsup.itravel_api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.tecsup.itravel_api.model.EmpresasTransporte;

import java.util.Optional;

@Repository
public interface EmpresasRepository extends JpaRepository<EmpresasTransporte, Integer>{

    Optional<EmpresasTransporte> findById(Integer integer);
}
