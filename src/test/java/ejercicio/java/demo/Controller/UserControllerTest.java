package ejercicio.java.demo.Controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import ejercicio.java.demo.DTO.UserDTO;
import ejercicio.java.demo.Entities.User;
import ejercicio.java.demo.Services.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UserControllerTest {

    @Mock
    private IUserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindUsers() throws Exception {
        User user1 = new User();
        User user2 = new User();
        List<User> userList = Arrays.asList(user1, user2);

        when(userService.getUsers()).thenReturn(userList);

        Collection<User> result = userController.findUsers();
        assertEquals(2, result.size());
        assertTrue(result.containsAll(userList));
    }

    @Test
    public void testGetUser() {
        String userId = "111111111111";
        UserDTO userDTO = new UserDTO();

        when(userService.getUser(userId)).thenReturn(userDTO);

        UserDTO result = userController.getUser(userId);
        assertEquals(userDTO, result);
    }

    @Test
    public void testDeactivateUser() {
        String userId = "111111111111";
        UserDTO userDTO = new UserDTO();

        when(userService.changeUserState(userId, false)).thenReturn(userDTO);

        UserDTO result = userController.deactivateUser(userId);
        assertEquals(userDTO, result);
    }

    @Test
    public void testActivateUser() {
        String userId = "111111111111";
        UserDTO userDTO = new UserDTO();

        when(userService.changeUserState(userId, true)).thenReturn(userDTO);

        UserDTO result = userController.activateUser(userId);
        assertEquals(userDTO, result);
    }
}
