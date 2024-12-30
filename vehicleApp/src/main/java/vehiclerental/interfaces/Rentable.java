package vehiclerental.interfaces;
import vehiclerental.model.Customer;

public interface Rentable {
    boolean rent(Customer customer, int daysRented);
    boolean returnVehicle();
}
