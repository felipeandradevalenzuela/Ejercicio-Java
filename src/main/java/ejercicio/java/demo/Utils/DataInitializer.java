package ejercicio.java.demo.Utils;

import ejercicio.java.demo.Entities.Phone;
import ejercicio.java.demo.Entities.User;
import ejercicio.java.demo.Repositories.IPhoneRepository;
import ejercicio.java.demo.Repositories.IUserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class DataInitializer {

    private final IUserRepository userRepository;
    private final IPhoneRepository phoneRepository;

    @Autowired
    public DataInitializer(IUserRepository userRepository, IPhoneRepository phoneRepository) {
        this.userRepository = userRepository;
        this.phoneRepository = phoneRepository;
    }

    @PostConstruct
    public void init() {
        Date date = new Date();

        // Carga datos iniciales
        List<Phone> initialPhones = Arrays.asList(
                new Phone(66677669,9,569),
                new Phone(86606669,2,569)
        );

        List<User> initialUsers = Arrays.asList(
                new User(new UuidGenerator().generateUuid(),"Felipe Andrade", "f.andradevalenzuela@gmail.com","Testing193!",date,true,date,date,"tok",initialPhones),
                new User(new UuidGenerator().generateUuid(),"Matias Andrade", "m.andradevalenzuela@gmail.com","Testin!g193!",date,true,date,date,"toktok",initialPhones)
        );

        List<User> savedUsers = userRepository.saveAll(initialUsers);

        for (int i = 0; i < initialPhones.size(); i++) {
            initialPhones.get(i).setUser(savedUsers.get(i));
        }

        phoneRepository.saveAll(initialPhones);
    }
}
