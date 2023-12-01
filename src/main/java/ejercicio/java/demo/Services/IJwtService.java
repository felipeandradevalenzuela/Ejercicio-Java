package ejercicio.java.demo.Services;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface IJwtService {
    String generateToken(UserDetails user);

    String createToken(Map<String, Object> claims, String subject);

    Boolean validateToken(String token, UserDetails userDetails);

    String extractUsername(String token);

    Date extractExpirationDate(String token);

    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    Boolean isTokenExpired(String token);
}
