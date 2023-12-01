package ejercicio.java.demo.Utils;

import ejercicio.java.demo.Entities.Phone;
import ejercicio.java.demo.Entities.Role;
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

        List<Phone> initialPhones = Arrays.asList(
                new Phone(66677669,9,569),
                new Phone(86606669,2,569)
        );

        List<User> initialUsers = Arrays.asList(
                User.builder()
                        .created(date)
                        .username("f.andradevalenzuela@gmail.com")
                        .role(Role.USER)
                        .email("f.andradevalenzuela@gmail.com")
                        .token("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmLmFuZHJhZGV2YWxlbnp1ZWxhQGdtYWlsLmNvbSIsImlhdCI6MTcwMTQxMjM0MiwiZXhwIjoxNzAxNDk4NzQyfQ.E2Z0a-XN-yUxi9Gqn_YVshBLZYE52pGzqEHnFW9kWek")
                        .isActive(true)
                        .lastLogin(date)
                        .modified(date)
                        .name("Felipe Andrade")
                        .uuid(new UuidGenerator().generateUuid())
                        .phones(initialPhones)
                        .password("$2a$10$tLZiy5PtI.TkAik4Oo4xG.XbR0GA8amzmPvpPpNdabygkNNRoAAFa")
                        .token("")
                        .build(),
                User.builder()
                        .created(date)
                        .role(Role.USER)
                        .email("m.andradevalenzuela@gmail.com")
                        .username("m.andradevalenzuela@gmail.com")
                        .token("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtLmFuZHJhZGV2YWxlbnp1ZWxhQGdtYWlsLmNvbSIsImlhdCI6MTcwMTQxMjM0MiwiZXhwIjoxNzAxNDk4NzQyfQ.tkeKMxFUiM4WM7is5QVlhjQIlTkfzwv9UbBs5A7K9dU")
                        .isActive(true)
                        .lastLogin(date)
                        .modified(date)
                        .name("Matias Andrade")
                        .uuid(new UuidGenerator().generateUuid())
                        .phones(initialPhones)
                        .password("$2a$10$tLZiy5PtI.TkAik4Oo4xG.XbR0GA8amzmPvpPpNdabygkNNRoAAFa")
                        .token("")
                        .build());

        List<User> savedUsers = userRepository.saveAll(initialUsers);

        for (int i = 0; i < initialPhones.size(); i++) {
            initialPhones.get(i).setUser(savedUsers.get(i));
        }

        phoneRepository.saveAll(initialPhones);
    }
}
