package ejercicio.java.demo.Controller;

import ejercicio.java.demo.DTO.LoginRequest;
import ejercicio.java.demo.DTO.UserDTO;
import ejercicio.java.demo.Services.AuthService;
import ejercicio.java.demo.Services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO request) throws Exception {
        return ResponseEntity.ok(userService.create(request));
    }

}
