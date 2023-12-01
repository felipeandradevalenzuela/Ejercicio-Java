package ejercicio.java.demo.Exception;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class GlobalExceptionTest {

    @InjectMocks
    private GlobalException globalException = new GlobalException();

    @Test
    public void testException() {
        Exception exception = new Exception("General Exception");
        ResponseEntity<GlobalResponseException> response = globalException.exception(exception);

        assertNotNull(response);
        assertEquals(500, response.getStatusCodeValue());
        assertEquals("[Exception] - General Exception", response.getBody().getMessage());
    }

    @Test
    public void testIoException() {
        IOException ioException = new IOException("IO Exception");
        ResponseEntity<GlobalResponseException> response = globalException.Ioexception(ioException);

        assertNotNull(response);
        assertEquals(500, response.getStatusCodeValue());
        assertEquals("[IOException] - IO Exception", response.getBody().getMessage());
    }

    @Test
    public void testRuntimeException() {
        RuntimeException runtimeException = new RuntimeException("Runtime Exception");
        ResponseEntity<GlobalResponseException> response = globalException.runtimeException(runtimeException);

        assertNotNull(response);
        assertEquals(500, response.getStatusCodeValue());
        assertEquals("[RunetimeException] - Runtime Exception", response.getBody().getMessage());
    }

    @Test
    public void testNullPointerException() {
        NullPointerException nullPointerException = new NullPointerException("Null Pointer Exception");
        ResponseEntity<GlobalResponseException> response = globalException.nullPointerException(nullPointerException);

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
        assertEquals("[NullPointerException] - Null Pointer Exception", response.getBody().getMessage());
    }
}
