package vehiclerental;

import org.junit.jupiter.api.Test;
import vehiclerental.model.Car;
import vehiclerental.service.RentalAgency;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalAgencyTest {
    @Test
    void testAddVehicle() {
        RentalAgency rentalAgency = new RentalAgency();
        Car car = new Car("V-2023", "Honda Civic", 70, true, true);
        rentalAgency.addVehicle(car);
        assertEquals(1, rentalAgency.getVehicleFleet().size(), "Fleet should have 1 vehicle after adding");
    }

}
