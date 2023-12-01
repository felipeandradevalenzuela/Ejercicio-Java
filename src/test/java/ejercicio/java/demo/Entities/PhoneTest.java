package ejercicio.java.demo.Entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PhoneTest {

    @Test
    public void testPhoneTestConstructorWithParameters() {
        int expectedNumber = 123456;
        int expectedCityCode = 1;
        int expectedCountryCode = 57;

        Phone phoneTest = new Phone(expectedNumber, expectedCityCode, expectedCountryCode);

        assertEquals(expectedNumber, phoneTest.getNumber());
        assertEquals(expectedCityCode, phoneTest.getCityCode());
        assertEquals(expectedCountryCode, phoneTest.getCountryCode());
    }

    @Test
    public void testPhoneTestSettersAndGetters() {
        Phone phoneTest = new Phone();
        phoneTest.setNumber(123456);
        phoneTest.setCityCode(1);
        phoneTest.setCountryCode(57);

        assertEquals(123456, phoneTest.getNumber());
        assertEquals(1, phoneTest.getCityCode());
        assertEquals(57, phoneTest.getCountryCode());
    }

}
