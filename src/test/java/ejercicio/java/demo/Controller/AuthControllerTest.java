package ejercicio.java.demo.Controller;

import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.OK;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ejercicio.java.demo.DTO.AuthResponse;
import ejercicio.java.demo.DTO.LoginRequest;
import ejercicio.java.demo.DTO.UserDTO;
import ejercicio.java.demo.Services.AuthService;
import ejercicio.java.demo.Services.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

public class AuthControllerTest {

    @Mock
    private AuthService authService;

    @Mock
    private IUserService userService;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("testUser");
        loginRequest.setPassword("testPass");

        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken("Token");

        when(authService.login(loginRequest)).thenReturn(authResponse);

        ResponseEntity<?> response = authController.login(loginRequest);
        assertEquals(OK, response.getStatusCode());
        assertEquals(authResponse, response.getBody());
    }

    @Test
    public void testRegister() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Test User");
        userDTO.setEmail("test@example.com");

        when(userService.create(userDTO)).thenReturn(userDTO);

        ResponseEntity<?> response = authController.register(userDTO);
        assertEquals(OK, response.getStatusCode());
        assertEquals(userDTO, response.getBody());
    }
}
