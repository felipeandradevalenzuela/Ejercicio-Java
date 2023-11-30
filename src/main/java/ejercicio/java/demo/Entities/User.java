package ejercicio.java.demo.Entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    
    @Id
    private String uuid;
    private String name;
    private String email;
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date created;
    @Column(name = "is_active")
    private boolean isActive;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified")
    private Date modified;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login")
    private Date lastLogin;
    @Column(name = "token")
    private String token;
    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Phone> phones;

    public User(String name, String email, String password, List<Phone> phones) {
        setName(name);
        setEmail(email);
        setPassword(password);
        setPhones(phones);
    }
}
