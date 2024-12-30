package vehiclerental.model;

public  class Car extends Vehicle {
    private boolean hasAirCondition;
    private boolean hasGPS;


    //Constructor
    public Car(String vehicleID, String model, double baseRentalRate, boolean hasGPS, boolean hasAirCondition) {
        super(vehicleID, model, baseRentalRate);
        this.hasGPS = hasGPS;
        this.hasAirCondition = hasAirCondition;
    }
    //Getters and Setters
    public boolean hasGPS() { return hasGPS; }
    public boolean hasAirConditioner() { return hasAirCondition; }
    public void setHasGPS(boolean hasGPS) { this.hasGPS = hasGPS; }
    public void setHasAirConditioner(boolean hasAirConditioner) { this.hasAirCondition = hasAirConditioner; }

    //Method to calculate the cost of renting a car
    @Override
    public double calculateRentalCost(int daysRented) {
        double cost = getBaseRentalRate() * daysRented;
        if (hasGPS && hasAirCondition) {
            cost += 100; //Additional fee for GPS and Air Conditioner
        } else if (hasGPS) {
            cost += 40; //Additional fee for only GPS
        } else if (hasAirCondition) {
            cost += 60; // Additional fee for only Air Conditioner
        }
        return cost;

    }
    //Method to show if a car is available for renting
    public boolean isAvailableForRental() {
        return isAvailable();
    }



}
