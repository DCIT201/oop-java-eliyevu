package vehiclerental.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    //Fields
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private List<String> rentalHistory;
    private String currentRental;
    //Constructor
    public Customer(String name, String email, String phoneNumber, String address) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("Email cannot be empty");
        }
        this.email = email;
        if(phoneNumber == null || phoneNumber.isEmpty()){
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        this.phoneNumber = phoneNumber;
        if(address == null || address.isEmpty()){
            throw new IllegalArgumentException("Address cannot be empty");
        }
        this.address = address;
        this.rentalHistory = new ArrayList<>();
        this.currentRental = null;
    }
    //Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }
    public List<String> getRentalHistory() { return rentalHistory; }
    public String getCurrentRental() { return currentRental; }

    //Method to rent a vehicle
    public boolean rentVehicle(Vehicle vehicle, int days){
        if (vehicle.isAvailable()){
            this.currentRental = vehicle.getVehicleID();
            this.rentalHistory.add(vehicle.getVehicleID());
            vehicle.setAvailable(false);//Mark vehicle as rented
            System.out.println("Vehicle " + vehicle.getVehicleID() + " successfully rented for "+ days + " days");
            return true;
        } else {
            System.out.println("Vehicle " + vehicle.getVehicleID() + " is not available");
            return false;
        }

    }
    //Method to return a rented vehicle
    public void returnVehicle(Vehicle vehicle){
        if (this.currentRental != null && this.currentRental.equals(vehicle.getVehicleID())){
            this.currentRental = null;
            vehicle.setAvailable(true);
            System.out.println("Vehicle " + vehicle.getVehicleID() + " has been successfully returned");
        } else {
            System.out.println("You do not have have any active rental to return ");
        }
    }
}

