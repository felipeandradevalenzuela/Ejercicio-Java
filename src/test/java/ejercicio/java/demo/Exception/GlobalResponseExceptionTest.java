package ejercicio.java.demo.Exception;

import org.junit.jupiter.api.Test;
import java.sql.Timestamp;
import static org.junit.jupiter.api.Assertions.*;

public class GlobalResponseExceptionTest {

    @Test
    public void testGlobalResponseExceptionProperties() {
        String expectedMessage = "Error Message";
        int expectedStatus = 500;
        Timestamp expectedTime = new Timestamp(System.currentTimeMillis());

        GlobalResponseException globalResponseException = new GlobalResponseException();
        globalResponseException.setMessage(expectedMessage);
        globalResponseException.setStatus(expectedStatus);
        globalResponseException.setTime(expectedTime);

        assertEquals(expectedMessage, globalResponseException.getMessage());
        assertEquals(expectedStatus, globalResponseException.getStatus());
        assertEquals(expectedTime, globalResponseException.getTime());
    }

    @Test
    public void testGlobalResponseExceptionAllArgsConstructor() {
        String expectedMessage = "Error Message";
        int expectedStatus = 500;
        Timestamp expectedTime = new Timestamp(System.currentTimeMillis());

        GlobalResponseException globalResponseException = new GlobalResponseException(expectedMessage, expectedStatus, expectedTime);

        assertEquals(expectedMessage, globalResponseException.getMessage());
        assertEquals(expectedStatus, globalResponseException.getStatus());
        assertEquals(expectedTime, globalResponseException.getTime());
    }
}
