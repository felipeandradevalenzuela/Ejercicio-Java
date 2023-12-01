package ejercicio.java.demo.Exception;

public enum ErrorMessages {
    INVALID_EMAIL("El correo ingresado no es válido, debe seguir el formato: aaaaa@dominio.cl"),
    REGISTERED_EMAIL("Correo ya registrado"),
    INVALID_PASSWORD("El password ingresado no es válido."),
    USER_NOT_FOUND("Usuario no encontrado o desactivado");


    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}