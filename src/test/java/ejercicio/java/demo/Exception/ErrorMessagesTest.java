package ejercicio.java.demo.Exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ErrorMessagesTest {

    @Test
    public void testInvalidEmailMessage() {
        assertEquals("El correo ingresado no es válido, debe seguir el formato: aaaaa@dominio.cl",
                ErrorMessages.INVALID_EMAIL.getMessage());
    }

    @Test
    public void testRegisteredEmailMessage() {
        assertEquals("Correo ya registrado",
                ErrorMessages.REGISTERED_EMAIL.getMessage());
    }

    @Test
    public void testInvalidPasswordMessage() {
        assertEquals("El password ingresado no es válido.",
                ErrorMessages.INVALID_PASSWORD.getMessage());
    }

    @Test
    public void testUserNotFoundMessage() {
        assertEquals("Usuario no encontrado o desactivado",
                ErrorMessages.USER_NOT_FOUND.getMessage());
    }
}
