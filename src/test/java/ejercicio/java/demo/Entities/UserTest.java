package ejercicio.java.demo.Entities;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUserProperties() {
        String uuid = "123";
        String name = "Test User";
        String email = "test@example.com";
        String username = "testUser";
        String password = "testPassword";
        Role role = Role.USER;
        Date created = new Date();
        boolean isActive = true;
        Date modified = new Date();
        Date lastLogin = new Date();
        String token = "token";
        List<Phone> phones = Collections.emptyList();

        User user = new User();
        user.setUuid(uuid);
        user.setName(name);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        user.setCreated(created);
        user.setActive(isActive);
        user.setModified(modified);
        user.setLastLogin(lastLogin);
        user.setToken(token);
        user.setPhones(phones);

        assertEquals(uuid, user.getUuid());
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        assertEquals(role, user.getRole());
        assertEquals(created, user.getCreated());
        assertTrue(user.isActive());
        assertEquals(modified, user.getModified());
        assertEquals(lastLogin, user.getLastLogin());
        assertEquals(token, user.getToken());
        assertEquals(phones, user.getPhones());
    }

    @Test
    public void testUserDetailsMethods() {
        User user = new User();
        user.setRole(Role.ADMIN);

        assertTrue(user.isAccountNonExpired());
        assertTrue(user.isAccountNonLocked());
        assertTrue(user.isCredentialsNonExpired());
        assertTrue(user.isEnabled());
        assertEquals(Collections.singletonList(new SimpleGrantedAuthority("USER")), user.getAuthorities());
    }
}
