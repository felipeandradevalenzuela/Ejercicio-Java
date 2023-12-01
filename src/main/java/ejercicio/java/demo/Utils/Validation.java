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

}
