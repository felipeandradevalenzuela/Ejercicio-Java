package ejercicio.java.demo.Adapter;

import ejercicio.java.demo.DTO.UserDTO;
import ejercicio.java.demo.Entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter {

    public User dtoToEntity(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhones(userDTO.getPhones());

        return user;
    }

    public UserDTO entityToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUuid(user.getUuid());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setCreated(user.getCreated());
        userDTO.setModified(user.getModified());
        userDTO.setLastLogin(user.getLastLogin());
        userDTO.setToken(user.getToken());
        userDTO.setPhones(user.getPhones());
        userDTO.setActive(user.isActive());

        return userDTO;
    }
    
}
