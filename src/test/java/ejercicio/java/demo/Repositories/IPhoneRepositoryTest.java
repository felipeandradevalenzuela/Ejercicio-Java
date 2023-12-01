package ejercicio.java.demo.Repositories;

import ejercicio.java.demo.Entities.Phone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class IPhoneRepositoryTest {

    @Mock
    private IPhoneRepository phoneRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        Phone phone = new Phone();
        phone.setId(1L);
        when(phoneRepository.findById(1L)).thenReturn(Optional.of(phone));

        Optional<Phone> foundPhone = phoneRepository.findById(1L);
        assertTrue(foundPhone.isPresent());
        assertEquals(phone, foundPhone.get());
    }

}
