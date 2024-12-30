package vehiclerental.service;
import java.util.UUID;
import vehiclerental.model.Customer;

import vehiclerental.model.Vehicle;

public class RentalTransaction {
    private final String transactionID;
    private final int rentalDuration;
    private final double totalCost;
    private final Vehicle vehicle;
    private final Customer customer;
    //Constructor
    public RentalTransaction(Vehicle vehicle, Customer customer, int rentalDuration) {
        this.vehicle = vehicle;
        this.customer = customer;
        if (rentalDuration <= 0) {
            throw new IllegalArgumentException("Rental Duration must be greater than 0");
        }
        this.rentalDuration = rentalDuration;
        this.totalCost = rentalDuration * vehicle.getBaseRentalRate(); //Calculate total cost
        this.transactionID = UUID.randomUUID().toString(); //Generate a unique ID for each transaction

    }
    //Getters
    public String getTransactionID() { return transactionID; }
    public int getRentalDuration() { return rentalDuration; }
    public double getTotalCost() { return totalCost; }
    public Vehicle getVehicle() { return vehicle; }
    public Customer getCustomer() { return customer; }

    //Method to display transaction details
    public String toString() {
        return "Transaction Details" + "\n" + "Transaction ID: " + transactionID +
                "\n" + "Customer " + customer.getName() + "\n" + "Vehicle " + vehicle.getVehicleID()+
                "("+vehicle.getModel() + ")" + "\n" + "Rental Duration " + rentalDuration + "\n" +
                "Total Cost " + totalCost;
    }
}
