package ejercicio.java.demo.Entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoleTest {

    @Test
    public void testRoleValues() {
        Role[] roles = Role.values();
        assertTrue(roles.length == 2);
        assertEquals(Role.ADMIN, roles[0]);
        assertEquals(Role.USER, roles[1]);
    }

    @Test
    public void testRoleValueOf() {
        assertEquals(Role.ADMIN, Role.valueOf("ADMIN"));
        assertEquals(Role.USER, Role.valueOf("USER"));
    }
}
