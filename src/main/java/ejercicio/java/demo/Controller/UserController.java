package ejercicio.java.demo.Controller;

import ejercicio.java.demo.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ejercicio.java.demo.DTO.UserDTO;
import ejercicio.java.demo.Services.IUserService;

import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private IUserService userService;

    @PostMapping("/add")
    public UserDTO create(@RequestBody UserDTO userDTO) throws Exception {
        return userService.create(userDTO);
    }

    @GetMapping("/all")
    public Collection<User> findUsers() throws Exception{
        return userService.getUsers();
    }

    @GetMapping("{userId}")
    public UserDTO getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @PostMapping("/deactivate/{userId}")
    public UserDTO deactivateUser(@PathVariable String userId) {
        return userService.changeUserState(userId, false);
    }

    @PostMapping("/activate/{userId}")
    public UserDTO activateUser(@PathVariable String userId) {
        return userService.changeUserState(userId, true);
    }

}
