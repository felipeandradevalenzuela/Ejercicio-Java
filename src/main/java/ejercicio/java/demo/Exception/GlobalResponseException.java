package ejercicio.java.demo.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalResponseException {
    private String message;
    private int status;
    private Timestamp time;
}
