package ejercicio.java.demo.Repositories;

import ejercicio.java.demo.Entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhoneRepository extends JpaRepository<Phone, Long> {
}
