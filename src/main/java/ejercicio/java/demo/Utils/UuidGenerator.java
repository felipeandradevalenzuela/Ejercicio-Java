package ejercicio.java.demo.Utils;

import java.util.UUID;

public class UuidGenerator {
    public String generateUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}