package ejercicio.java.demo.Adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ejercicio.java.demo.DTO.UserDTO;
import ejercicio.java.demo.Entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserAdapterTest {

    private UserAdapter userAdapter;

    @BeforeEach
    public void setUp() {
        userAdapter = new UserAdapter();
    }

    @Test
    public void testDtoToEntity() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Felipe Andrade");
        userDTO.setEmail("f.andrade@gmail.com");
        userDTO.setPassword("Testing193!");

        User user = userAdapter.dtoToEntity(userDTO);

        assertEquals(userDTO.getName(), user.getName());
        assertEquals(userDTO.getEmail(), user.getEmail());
        assertEquals(userDTO.getPassword(), user.getPassword());
    }

    @Test
    public void testEntityToDto() {
        User user = new User();
        user.setUuid("12345");
        user.setName("Felipe Andres");
        user.setEmail("f.andrade@gmail.com");
        user.setPassword("Testing193!");

        UserDTO userDTO = userAdapter.entityToDTO(user);

        assertEquals(user.getUuid(), userDTO.getUuid());
        assertEquals(user.getName(), userDTO.getName());
        assertEquals(user.getEmail(), userDTO.getEmail());
        assertEquals(user.getPassword(), userDTO.getPassword());
    }
}
