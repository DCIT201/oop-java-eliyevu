package vehiclerental.service;



import vehiclerental.model.Customer;
import vehiclerental.model.Vehicle;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentalAgency {
    private List<Vehicle> vehicleFleet;
    private Map<String, Customer> customers;
    private List<RentalTransaction> rentalTransactions;

    public RentalAgency() {
        this.vehicleFleet = new ArrayList<>();
        this.customers = new HashMap<>();
        this.rentalTransactions = new ArrayList<>();
    }

    public List<Vehicle> getVehicleFleet() {
        return vehicleFleet;
    }

    public Vehicle getVehicle(String vehicleID) {
        for (Vehicle vehicle : vehicleFleet) {
            if (vehicle.getVehicleID().equals(vehicleID)) {
                return vehicle;
            }
        }
        return null;
    }
    //Method to manage vehicle fleet
    public void addVehicle(Vehicle vehicle) {
        this.vehicleFleet.add(vehicle);
        System.out.println("Vehicle " + vehicle.getVehicleID() + " added to the fleet");
    }
    //Remove a vehicle from fleet
    public void removeVehicle(String vehicleID) {
        Vehicle vehicle = getVehicle(vehicleID);
        if (vehicle != null) {
            vehicleFleet.remove(vehicle);
            System.out.println("Vehicle " + vehicle.getVehicleID() + " removed from the fleet");
        } else {
            System.out.println("Vehicle " + vehicle.getVehicleID() + " not found");
        }
    }
    //List all vehicles in the fleet
    public void listAvailableVehicles() {
        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : vehicleFleet) {
            System.out.println(vehicle);
        }
    }
    //Process rentals
   public void rentVehicle(Customer customer, String vehicleID, int daysRented ) {
        Vehicle vehicle = getVehicle(vehicleID);
        if (vehicle == null) {
            System.out.println("Vehicle " + vehicleID + " not found.");
            return;
        }
        if (!vehicle.isAvailable()){
            System.out.println("Vehicle " + vehicleID + " is not available for rent.");
            return;
        }
        customer.rentVehicle(vehicle, daysRented);
        this.rentalTransactions.add(new RentalTransaction(vehicle, customer, daysRented));
       System.out.println("Vehicle " + vehicle.getVehicleID() + " rented to customer"+ customer.getName() + " for " + daysRented + " days.");

   }

   public void returnVehicle(Customer customer, String vehicleID) {
        Vehicle vehicle = getVehicle(vehicleID);
        if (vehicle == null) {
            System.out.println("Vehicle " + vehicleID + " not found.");
            return;
        }
        customer.returnVehicle(vehicle);
       System.out.println("Vehicle " + vehicleID + " returned by customer"+ customer.getName() +".");
   }
   //Generate reports
    public void getAvailableVehicles() {
        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : vehicleFleet) {
            if (vehicle.isAvailable()) {
                System.out.println(vehicle);
            }
        }
    }
    public void getRentedVehicles() {
        System.out.println("Currently rented Vehicles:");
        for (Vehicle vehicle : vehicleFleet) {
            if (vehicle.isAvailable()) {
                System.out.println(vehicle);
            }
        }
    }

    public void customerReports(Customer customer) {
        System.out.println("Customer " + customer.getName() + " rental history:");
        for (String rental : customer.getRentalHistory()) {
            System.out.println(rental);
        }
    }
    //Business logic
    public void loyaltyProgram(Customer customer) {
        int rentals = customer.getRentalHistory().size();
        if (rentals > 3) {
            System.out.println("You are eligible for loyalty discount!.");
        } else {
            System.out.println("You are not yet eligible for loyalty discount.");
        }
    }
    //Calculate total revenue
    public String calculateRevenue(){
        double totalRevenue = 0;
        for (RentalTransaction transaction : rentalTransactions) {
            totalRevenue += transaction.getTotalCost();
        }
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        return "Total revenue is: " + currencyFormat.format(totalRevenue);
    }






}
