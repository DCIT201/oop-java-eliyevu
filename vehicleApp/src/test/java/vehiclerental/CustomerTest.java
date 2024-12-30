package vehiclerental;

import org.junit.jupiter.api.Test;
import vehiclerental.model.Car;
import vehiclerental.model.Customer;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerTest {
    @Test
    void testRentVehicle() {
        Customer customer = new Customer("Eli Yevu", "eli@gmail.com",
                "0596851110", "North Carolina");
        Car car = new Car("V-2023", "Honda Civic", 70, true, true);
        boolean success = customer.rentVehicle(car, 2);
        assertTrue(success, "Customer should be able to rent available vehicle");

    }
}
