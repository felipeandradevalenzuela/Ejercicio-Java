package ejercicio.java.demo.DTO;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalResponseExceptionTest {

    @Test
    public void testGlobalResponseExceptionAssignment() {
        Timestamp timestamp = new Timestamp(new Date().getTime());

        GlobalResponseException exception = new GlobalResponseException("Error message", 404, timestamp);

        assertEquals("Error message", exception.getMessage());
        assertEquals(404, exception.getStatus());
        assertEquals(timestamp, exception.getTime());
    }
}
