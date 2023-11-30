package ejercicio.java.demo.Controller;

import ejercicio.java.demo.Controller.UserController;
import ejercicio.java.demo.DTO.UserDTO;
import ejercicio.java.demo.Entities.User;
import ejercicio.java.demo.Services.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private IUserService userService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testCreateUser() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Felipe");
        userDTO.setEmail("felipe@gmail.com");
        userDTO.setPassword("Testing123!");

        when(userService.create(any(UserDTO.class))).thenReturn(userDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/user/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Felipe\",\"email\":\"felipe@gmail.com\",\"password\":\"Testing123!\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Felipe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("felipe@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("Testing123!"));

        verify(userService, times(1)).create(any(UserDTO.class));
    }

    @Test
    public void testFindUsers() throws Exception {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Felipe", "felipe@gmail.com", "Password123!", null));
        userList.add(new User("Andres", "andres@gmail.com", "Secret123!", null));

        when(userService.getUsers()).thenReturn(userList);

        mockMvc.perform(MockMvcRequestBuilders.get("/user/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Felipe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Andres"));

        verify(userService, times(1)).getUsers();
    }

    @Test
    public void testGetUser() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Felipe Andrade");
        userDTO.setEmail("felipe.andrade@gmail.com");
        userDTO.setPassword("Password123!");

        when(userService.getUser("1")).thenReturn(userDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/user/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Felipe Andrade"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("felipe.andrade@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("Password123!"));

        verify(userService, times(1)).getUser("1");
    }
}
