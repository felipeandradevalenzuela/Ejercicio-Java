package ejercicio.java.demo.Services;

import ejercicio.java.demo.DTO.UserDTO;
import ejercicio.java.demo.Entities.User;

import java.util.Collection;

public interface IUserService {

    UserDTO create(UserDTO userDTO) throws Exception;
    Collection<User> getUsers();
    UserDTO getUser(String userId);
}
