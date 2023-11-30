package ejercicio.java.demo.DTO;

import ejercicio.java.demo.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class UserDTO extends User{
    public UserDTO(User user) {
        setUuid(user.getUuid());
        setName(user.getName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        setPhones(user.getPhones());
    }

}
