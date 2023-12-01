package ejercicio.java.demo.DTO;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class AuthResponseTest {

    @Test
    public void testToken() {
        String expectedToken = "someToken";
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(expectedToken);
        assertEquals(expectedToken, authResponse.getToken());
    }

    @Test
    public void testCreated() {
        Date expectedDate = new Date();
        AuthResponse authResponse = new AuthResponse();
        authResponse.setCreated(expectedDate);
        assertEquals(expectedDate, authResponse.getCreated());
    }

    @Test
    public void testModified() {
        Date expectedDate = new Date();
        AuthResponse authResponse = new AuthResponse();
        authResponse.setModified(expectedDate);
        assertEquals(expectedDate, authResponse.getModified());
    }

    @Test
    public void testLastLogin() {
        Date expectedDate = new Date();
        AuthResponse authResponse = new AuthResponse();
        authResponse.setLast_login(expectedDate);
        assertEquals(expectedDate, authResponse.getLast_login());
    }

    @Test
    public void testIsActive() {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setActive(true);
        assertTrue(authResponse.isActive());
    }
}
