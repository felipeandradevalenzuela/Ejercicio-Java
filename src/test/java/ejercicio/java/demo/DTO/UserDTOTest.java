package ejercicio.java.demo.DTO;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserDTOTest {

    @Test
    public void testUserDTOInheritsUserProperties() {
        String expectedUsername = "testUser";
        String expectedPassword = "testPassword";

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(expectedUsername);
        userDTO.setPassword(expectedPassword);

        assertEquals(expectedUsername, userDTO.getUsername());
        assertEquals(expectedPassword, userDTO.getPassword());
    }
}
