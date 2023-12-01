package ejercicio.java.demo.Services;

import ejercicio.java.demo.DTO.AuthResponse;
import ejercicio.java.demo.DTO.LoginRequest;
import ejercicio.java.demo.Entities.User;
import ejercicio.java.demo.Repositories.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private IUserRepository userRepository;

    @Mock
    private IJwtService jwtService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLogin_Successful() {
        String username = "testUser";
        String password = "testPassword";
        String token = "testToken";
        User user = new User();
        user.setUsername(username);
        user.setCreated(new Date());
        user.setModified(new Date());
        user.setLastLogin(new Date());
        user.setActive(true);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username);
        loginRequest.setPassword(password);

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));
        when(jwtService.generateToken(user)).thenReturn(token);

        AuthResponse response = authService.login(loginRequest);

        assertNotNull(response);
        assertEquals(token, response.getToken());
        verify(authenticationManager).authenticate(new UsernamePasswordAuthenticationToken(username, password));
        verify(userRepository).save(any(User.class));
    }

    @Test
    public void testLogin_UserNotFound() {
        String username = "testUser";
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username);

        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> authService.login(loginRequest));
    }

}
