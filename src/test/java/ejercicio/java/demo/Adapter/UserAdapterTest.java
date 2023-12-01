package ejercicio.java.demo.Adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ejercicio.java.demo.DTO.UserDTO;
import ejercicio.java.demo.Entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserAdapterTest {

    private UserAdapter userAdapter;

    @BeforeEach
    void setUp() {
        userAdapter = new UserAdapter();
    }

    @Test
    void testDtoToEntity() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Test Name");
        userDTO.setEmail("test@example.com");

        User user = userAdapter.dtoToEntity(userDTO);

        assertEquals(userDTO.getName(), user.getName());
        assertEquals(userDTO.getEmail(), user.getEmail());
    }

    @Test
    void testEntityToDto() {
        User user = new User();
        user.setName("Test Name");
        user.setEmail("test@example.com");

        UserDTO userDTO = userAdapter.entityToDTO(user);

        assertEquals(user.getName(), userDTO.getName());
        assertEquals(user.getEmail(), userDTO.getEmail());
    }
}
