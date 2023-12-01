package ejercicio.java.demo.Services;

import ejercicio.java.demo.DTO.AuthResponse;
import ejercicio.java.demo.DTO.LoginRequest;
import ejercicio.java.demo.Entities.User;
import ejercicio.java.demo.Repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final IUserRepository userRepository;
    private final IJwtService jwtService;
    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        String token = jwtService.generateToken(user);
        user.setLastLogin(new Date());
        user.setToken(token);
        userRepository.save(user);

        return AuthResponse.builder()
                .token(token)
                .created(user.getCreated())
                .modified(user.getModified())
                .last_login(user.getLastLogin())
                .isActive(user.isActive())
                .build();
    }

}
