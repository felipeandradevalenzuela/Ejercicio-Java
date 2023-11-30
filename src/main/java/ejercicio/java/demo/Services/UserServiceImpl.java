package ejercicio.java.demo.Services;

import ejercicio.java.demo.Entities.Phone;
import ejercicio.java.demo.Repositories.IPhoneRepository;
import ejercicio.java.demo.Utils.ErrorMessages;
import ejercicio.java.demo.Utils.UuidGenerator;
import ejercicio.java.demo.Utils.Validation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ejercicio.java.demo.Adapter.UserAdapter;
import ejercicio.java.demo.DTO.UserDTO;
import ejercicio.java.demo.Entities.User;
import ejercicio.java.demo.Repositories.IUserRepository;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final IPhoneRepository phoneRepository;
    private final UserAdapter userAdapter;
    private final Validation validation;

    @Override
    public UserDTO create(UserDTO userDTO) throws Exception {
        User user = userAdapter.dtoToEntity(userDTO);
        user = setDefaultValues(user);

        if (doesEmailExist(user.getEmail())) {
            throw new Exception(ErrorMessages.REGISTERED_EMAIL.getMessage());
        }
        if (!validation.isValidEmail(user.getEmail())) {
            throw new Exception(ErrorMessages.INVALID_EMAIL.getMessage());
        }
        if (!validation.isValidPasswordRegex(user.getPassword())) {
            throw new Exception(ErrorMessages.INVALID_PASSWORD.getMessage());
        }


        user.setUuid(new UuidGenerator().generateUuid());
        User savedUser = userRepository.save(user);
        List<Phone> userPhones = user.getPhones();

        if (!userPhones.isEmpty()) {
            for (Phone userPhone : userPhones) {
                userPhone.setUser(savedUser);
            }
        }
        phoneRepository.saveAll(userPhones);
        savedUser.setPhones(userPhones);

        return userAdapter.entityToDTO(savedUser);

    }

    @Override
    public Collection<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDTO getUser(String userId) {
        User user = userRepository.findByUuid(userId);
        if (user == null || !user.isActive()) {
            throw new RuntimeException(ErrorMessages.USER_NOT_FOUND.getMessage());
        }
        return userAdapter.entityToDTO(user);
    }

    @Override
    public UserDTO changeUserState(String userId, boolean state) {
        Date date = new Date();
        User user = userRepository.findByUuid(userId);
        if (user == null) {
            throw new RuntimeException(ErrorMessages.USER_NOT_FOUND.getMessage());
        }
        user.setActive(state);
        user.setModified(date);
        user.setLastLogin(date);
        userRepository.save(user);
        return userAdapter.entityToDTO(user);
    }

    public boolean doesEmailExist(String email) {
        User user = userRepository.findByEmail(email);
        return user != null;
    }

    public User setDefaultValues(User user) {
        Date date = new Date();
        user.setCreated(date);
        user.setLastLogin(date);
        user.setModified(date);
        user.setActive(true);
        return user;
    }

}
