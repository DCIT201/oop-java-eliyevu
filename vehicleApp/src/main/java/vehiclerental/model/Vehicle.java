package vehiclerental.model;

import vehiclerental.interfaces.Rentable;

public abstract class Vehicle implements Rentable {
    //Fields
    private String vehicleID;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;
    //mVehicle constructor
    public Vehicle(String vehicleID, String model, double baseRentalRate) {
        this.vehicleID = vehicleID;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = true; //default to available
    }
    //Getter and setters
    public String getVehicleID() {
        return vehicleID;
    }
    public String getModel() {
        return model;
    }
    public double getBaseRentalRate() {
        return baseRentalRate;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public void setVehicleID(String vehicleID) {
        if(vehicleID == null || vehicleID.isEmpty()){
            throw new IllegalArgumentException("Vehicle ID cannot be null or empty.");
        }
        this.vehicleID = vehicleID;
    }
    public void setModel(String model) {
        if(model == null || model.isEmpty()){
            throw new IllegalArgumentException("Vehicle model cannot be null or empty.");
        }
        this.model = model;
    }
    public void setBaseRentalRate(double baseRentalRate) {
        if(baseRentalRate < 0){
            throw new IllegalArgumentException("Base rental rate cannot be negative.");
        }
        this.baseRentalRate = baseRentalRate;
    }

    //Methods

    public abstract double calculateRentalCost(int daysRented);
    public abstract boolean isAvailableForRental();

    @Override
    public boolean rent(Customer customer, int daysRented) {
        if (isAvailable() && daysRented > 0) {
            isAvailable = false;
            System.out.println("Customer " + customer.getName() + " rented Vehicle " + vehicleID +
                    daysRented + " days.");
            return true;
        }
        System.out.println("Vehicle " + vehicleID + " is not available for rent.");
        return false;
    }

    @Override
    public boolean returnVehicle() {
        if (!isAvailable()) {
            isAvailable = true;
            System.out.println("Vehicle " + vehicleID + " has been returned and available for rent.");
            return true;
        }
        System.out.println("Vehicle " + vehicleID + " is not currently rented.");
        return false;
    }

}

