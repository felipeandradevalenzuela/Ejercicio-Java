package ejercicio.java.demo.DTO;

import ejercicio.java.demo.DTO.LoginRequest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginRequestTest {

    @Test
    public void testUsername() {
        String expectedUsername = "testUser";
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(expectedUsername);
        assertEquals(expectedUsername, loginRequest.getUsername());
    }

    @Test
    public void testPassword() {
        String expectedPassword = "testPassword";
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword(expectedPassword);
        assertEquals(expectedPassword, loginRequest.getPassword());
    }
}
