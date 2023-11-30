package ejercicio.java.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Phone {

    @Id
    @GeneratedValue()
    private Long id;
    private int number;
    private int cityCode;
    private int countryCode;
    @ManyToOne
    @JoinColumn(name = "user_uuid")
    @JsonIgnoreProperties("phones")
    private User user;

    public Phone(int number, int cityCode, int countryCode) {
        setNumber(number);
        setCityCode(cityCode);
        setCountryCode(countryCode);
    }
}
