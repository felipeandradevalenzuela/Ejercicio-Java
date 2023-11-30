package ejercicio.java.demo.Utils;

public enum ErrorMessages {
    INVALID_EMAIL("El correo ingresado no es válido, debe seguir el formato: aaaaa@dominio.cl"),
    REGISTERED_EMAIL("Correo ya registrado"),
    INVALID_PASSWORD("El password ingresado no es válido, debe contener 1 mayúscula, 1 número y 1 caracter especial como mínimo."),
    USER_NOT_FOUND("Usuario no encontrado");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}