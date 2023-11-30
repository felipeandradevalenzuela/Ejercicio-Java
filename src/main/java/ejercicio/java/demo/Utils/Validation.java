package ejercicio.java.demo.Utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class Validation{

    @Value("${email.validation.regex.regexp}")
    public String emailRegex;
    @Value("${password.validation.regex.regexp}")
    public String passwordRegex;


    public boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public boolean isValidPasswordRegex(String pass) {
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(pass);
        return matcher.matches();
    }

    public boolean isValidPassword(String password) {
        // Verifica si la contraseña tiene al menos 8 caracteres
        if (password.length() < 8) {
            return false;
        }

        // Verifica si la contraseña contiene al menos una letra minúscula
        boolean containsLowerCase = false;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                containsLowerCase = true;
                break;
            }
        }

        // Verifica si la contraseña contiene al menos una letra mayúscula
        boolean containsUpperCase = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                containsUpperCase = true;
                break;
            }
        }

        // Verifica si la contraseña contiene al menos un dígito
        boolean containsDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                containsDigit = true;
                break;
            }
        }

        // Verifica si la contraseña contiene al menos un carácter especial
        boolean containsSpecialCharacter = false;
        String specialCharacters = "!@#$%^&*()_+{}[]-=:;\"'<>,.?/~";
        for (char c : password.toCharArray()) {
            if (specialCharacters.contains(String.valueOf(c))) {
                containsSpecialCharacter = true;
                break;
            }
        }

        // La contraseña es válida si cumple con todos los criterios
        return containsLowerCase && containsUpperCase && containsDigit && containsSpecialCharacter;
    }
}
