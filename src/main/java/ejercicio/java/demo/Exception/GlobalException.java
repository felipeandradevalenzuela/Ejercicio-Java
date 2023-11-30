package ejercicio.java.demo.Exception;

import ejercicio.java.demo.DTO.GlobalResponseException;
import ejercicio.java.demo.Utils.Time;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class GlobalException {

    private GlobalResponseException globalResponseException;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalResponseException> exception(Exception e) {
        globalResponseException = new GlobalResponseException("[Exception] - "+
                e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), Time.getTime());

        return new ResponseEntity<>(globalResponseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<GlobalResponseException> Ioexception(IOException e) {
        globalResponseException = new GlobalResponseException("[IOException] - " +
                e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), Time.getTime());
        return new ResponseEntity<>(globalResponseException,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<GlobalResponseException> runtimeException(RuntimeException e){
        globalResponseException = new GlobalResponseException("[RunetimeException] - " +
                e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), Time.getTime());
        return new ResponseEntity<>(globalResponseException,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<GlobalResponseException> nullPointerException(NullPointerException e){
        globalResponseException = new GlobalResponseException("[NullPointerException] - " +
                e.getMessage(), HttpStatus.NOT_FOUND.value(), Time.getTime());
        return new ResponseEntity<>(globalResponseException,HttpStatus.NOT_FOUND);
    }
}
