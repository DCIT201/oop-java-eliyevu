package vehiclerental.model;

public class Truck extends Vehicle {
    private double loadCapacity;
    //Constructor
    public Truck(String vehicleID, String model, double baseRentalRate, double loadCapacity) {
        super(vehicleID, model, baseRentalRate);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity(){
        return loadCapacity; }

    public void setLoadCapacity(double loadCapacity){
        if(loadCapacity < 0){
            throw new IllegalArgumentException("Load capacity must be a non-negative number");
        }
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRentalCost(int daysRented) {
        double cost = getBaseRentalRate()*daysRented +(loadCapacity*20);
        return cost;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }
}
