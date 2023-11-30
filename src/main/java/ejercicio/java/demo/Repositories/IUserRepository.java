package ejercicio.java.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ejercicio.java.demo.Entities.User;

public interface IUserRepository extends JpaRepository<User, String>{

    User findByUuid(String uuid);
    User findByEmail(String email);
}
