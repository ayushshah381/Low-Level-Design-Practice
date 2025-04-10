import VehicleType.VehicleType;
import VehicleType.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private final int floor;
    private final List<ParkingSpot> parkingSpots;

    public Level(int floor, int numberOfSpots) {
        this.floor = floor;
        parkingSpots = new ArrayList<>(numberOfSpots);

        // Assigning spots for bikes, cars & trucks in the ration 50:40:1
        double bikeSpots = 0.5;
        double carSpots = 0.4;

        int numberOfBikes = (int)(bikeSpots * numberOfSpots);
        int numberOfCars = (int)(carSpots * numberOfSpots);

        // Add bike spots
        for(int i=1;i<=numberOfBikes;i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.MOTORCYCLE));
        }

        // Add car spots
        for(int i=numberOfBikes+1; i<= numberOfBikes+numberOfCars; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
        }

        // Add truck spots
        for(int i=numberOfBikes+numberOfCars+1;i<=numberOfSpots;i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
    }

    // All methods for this level
    // Park a vehicle
    public synchronized boolean parkVehicle(Vehicle incomingVehicle) {
        for(ParkingSpot parkingSpot: parkingSpots) {
            if(parkingSpot.isParkingAvailable() && parkingSpot.getVehicleType() == incomingVehicle.getVehicleType()) {
                parkingSpot.parkVehicle(incomingVehicle);
                return true;
            }
        }
        return false;
    }

    // unpark a vehicle
    public synchronized boolean unparkVehicle(Vehicle incomingVehicle) {
        for(ParkingSpot parkingSpot: parkingSpots) {
            if(!parkingSpot.isParkingAvailable() && parkingSpot.getParkedVehicle().equals(incomingVehicle)) {
                parkingSpot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("Level " + floor + " Availability:");
        for (ParkingSpot spot : parkingSpots) {
            System.out.println("Spot " + spot.getSpotNumber() + ": " + (spot.isParkingAvailable() ? "Available For"  : "Occupied By ")+" "+spot.getVehicleType());
        }
    }
}
