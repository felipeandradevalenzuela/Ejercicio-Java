package ejercicio.java.demo.Services;

import ejercicio.java.demo.DTO.UserDTO;
import ejercicio.java.demo.Entities.User;
import ejercicio.java.demo.Repositories.IPhoneRepository;
import ejercicio.java.demo.Repositories.IUserRepository;
import ejercicio.java.demo.Adapter.UserAdapter;
import ejercicio.java.demo.Utils.UuidGenerator;
import ejercicio.java.demo.Utils.Validation;
import ejercicio.java.demo.Security.ApplicationConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private IUserRepository userRepository;

    @Mock
    private IPhoneRepository phoneRepository;

    @Mock
    private UserAdapter userAdapter;

    @Mock
    private Validation validation;

    @Mock
    private IJwtService jwtService;

    @Mock
    private ApplicationConfig applicationConfig;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UuidGenerator uuidGenerator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(applicationConfig.passwordEncoder()).thenReturn(passwordEncoder);
    }

    @Test
    public void testCreateUser_Successful() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("aaaaa@dominio.cl");
        userDTO.setPassword("Testin123!");
        User user = new User();
        user.setEmail("aaaaa@dominio.cl");
        user.setPassword("Testin123!");
        user.setPhones(Collections.emptyList());

        when(userAdapter.dtoToEntity(userDTO)).thenReturn(user);
        when(validation.isValidEmail(anyString())).thenReturn(true);
        when(validation.isValidPasswordRegex(anyString())).thenReturn(true);
        when(userRepository.findByEmail(anyString())).thenReturn(null);
        when(uuidGenerator.generateUuid()).thenReturn("uuid");
        when(passwordEncoder.encode(anyString())).thenReturn("Testin123!");
        when(jwtService.generateToken(user)).thenReturn("token");

        User createdUser = userService.create(userDTO);

        assertNotNull(createdUser);
        assertEquals("Testin123!", createdUser.getPassword());
        verify(userRepository).save(user);
        verify(phoneRepository).saveAll(Collections.emptyList());
    }

    @Test
    public void testCreateUser_EmailExists() {
        UserDTO userDTO = new UserDTO();
        User existingUser = new User();

        when(userAdapter.dtoToEntity(userDTO)).thenReturn(new User());
        when(validation.isValidEmail(anyString())).thenReturn(true);
        when(userRepository.findByEmail(anyString())).thenReturn(existingUser);

        assertThrows(Exception.class, () -> userService.create(userDTO));
    }

    @Test
    public void testGetUsers() {
        List<User> userList = Collections.singletonList(new User());
        when(userRepository.findAll()).thenReturn(userList);

        Collection<User> result = userService.getUsers();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(userList.size(), result.size());
        verify(userRepository).findAll();
    }

    @Test
    public void testGetUser_UserExists() {
        String userId = "testUuid";
        User user = new User();
        user.setActive(true);
        UserDTO userDTO = new UserDTO();

        when(userRepository.findByUuid(userId)).thenReturn(user);
        when(userAdapter.entityToDTO(user)).thenReturn(userDTO);

        UserDTO result = userService.getUser(userId);

        assertNotNull(result);
        verify(userRepository).findByUuid(userId);
        verify(userAdapter).entityToDTO(user);
    }

    @Test
    public void testGetUser_UserNotFound() {
        String userId = "testUuid";
        when(userRepository.findByUuid(userId)).thenReturn(null);

        assertThrows(RuntimeException.class, () -> userService.getUser(userId));
    }

    @Test
    public void testChangeUserState() {
        String userId = "testUuid";
        User user = new User();
        UserDTO userDTO = new UserDTO();

        when(userRepository.findByUuid(userId)).thenReturn(user);
        when(userAdapter.entityToDTO(user)).thenReturn(userDTO);

        UserDTO result = userService.changeUserState(userId, true);

        assertNotNull(result);
        assertTrue(user.isActive());
        verify(userRepository).findByUuid(userId);
        verify(userRepository).save(user);
        verify(userAdapter).entityToDTO(user);
    }

    @Test
    public void testChangeUserState_UserNotFound() {
        String userId = "testUuid";
        when(userRepository.findByUuid(userId)).thenReturn(null);

        assertThrows(RuntimeException.class, () -> userService.changeUserState(userId, true));
    }


}
