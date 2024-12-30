package vehiclerental;

import vehiclerental.model.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
    @Test
    void testAvailableForRental() {
        Car car = new Car("V-2023", "Honda Civic", 70, true, true);
        assertTrue(car.isAvailableForRental(), "Car should be available for rental");
        car.setAvailable(false);
        assertFalse(car.isAvailableForRental(), "Car should not be available for rental");


    }
}

