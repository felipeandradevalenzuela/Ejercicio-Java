package ejercicio.java.demo.Services;

import ejercicio.java.demo.DTO.AuthResponse;
import ejercicio.java.demo.DTO.UserDTO;
import ejercicio.java.demo.Entities.User;
import java.util.Collection;

public interface IUserService {

    User create(UserDTO userDTO) throws Exception;

    Collection<User> getUsers();

    UserDTO getUser(String userId);

    UserDTO changeUserState(String userId, boolean state);

}
