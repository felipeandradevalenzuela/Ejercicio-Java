package ejercicio.java.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ejercicio.java.demo.Entities.User;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, String>{
    Optional<User> findByUsername(String name);
    User findByUuid(String uuid);
    User findByEmail(String email);
}
