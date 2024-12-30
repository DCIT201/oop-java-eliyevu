package vehiclerental.model;

public class Motorcycle extends Vehicle {

    //Constructor
    public Motorcycle(String vehicleID, String model, double baseRentalRate) {
        super(vehicleID, model, baseRentalRate);
    }

    @Override
    public double calculateRentalCost(int daysRented) {
        return getBaseRentalRate() * daysRented;
    }


    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }
}
