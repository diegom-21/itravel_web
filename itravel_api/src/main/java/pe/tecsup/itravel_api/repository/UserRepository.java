// Importaciones necesarias
package pe.tecsup.itravel_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.tecsup.itravel_api.model.User;

import java.util.Optional;

// Interfaz que extiende JpaRepository para realizar operaciones CRUD en la entidad User
public interface UserRepository extends JpaRepository<User, Integer> {

    // Método personalizado para buscar un usuario por su dirección de correo electrónico
    Optional<User> findByEmail(String email);
}
