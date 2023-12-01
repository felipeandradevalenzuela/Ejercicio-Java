package ejercicio.java.demo.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class JwtServiceImplTest {

    @InjectMocks
    private JwtServiceImpl jwtService;

    private final String SECRET = "123412512QWESAD123123QWEQWE123123123QWEQWEQWEQWE";
    private final Long EXPIRATION = 3600000L;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        jwtService = new JwtServiceImpl(SECRET, EXPIRATION);
    }

    @Test
    public void testGenerateToken() {
        UserDetails userDetails = new User("testUser", "password", Collections.emptyList());
        String token = jwtService.generateToken(userDetails);
        assertNotNull(token);

        assertEquals("testUser", jwtService.extractUsername(token));
        assertFalse(jwtService.isTokenExpired(token));
    }

    @Test
    public void testValidateToken_Valid() {
        UserDetails userDetails = new User("testUser", "password", Collections.emptyList());
        String token = jwtService.generateToken(userDetails);
        assertTrue(jwtService.validateToken(token, userDetails));
    }

    @Test
    public void testValidateToken_Invalid() {
        UserDetails userDetails = new User("testUser", "password", Collections.emptyList());
        String token = jwtService.generateToken(userDetails);
        UserDetails differentUser = new User("differentUser", "password", Collections.emptyList());
        assertFalse(jwtService.validateToken(token, differentUser));
    }

}
