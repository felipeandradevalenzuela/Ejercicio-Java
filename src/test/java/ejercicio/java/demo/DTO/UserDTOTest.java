package ejercicio.java.demo.DTO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDTOTest {

    @Test
    public void testUserDTOAssignment() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Felipe");
        userDTO.setEmail("felipe@gmail.com");
        userDTO.setPassword("Password123!");

        assertEquals("Felipe", userDTO.getName());
        assertEquals("felipe@gmail.com", userDTO.getEmail());
        assertEquals("Password123!", userDTO.getPassword());
    }
}
