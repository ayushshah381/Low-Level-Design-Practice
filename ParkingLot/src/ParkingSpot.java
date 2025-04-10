import VehicleType.VehicleType;
import VehicleType.Vehicle;

public class ParkingSpot {
    private final int spotNumber;
    private VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    // Define all the methods
    // Is parking available
    public synchronized boolean isParkingAvailable() {
        return parkedVehicle == null;
    }

    // Allot parking if available
    public synchronized void parkVehicle(Vehicle incomingVehicle) {
        if(isParkingAvailable() && incomingVehicle.getVehicleType() == vehicleType) {
            parkedVehicle = incomingVehicle;
        }
        else {
            throw new IllegalArgumentException("Cannot park the car here");
        }
    }

    // Unpark the vehicle
    public void unparkVehicle() {
        parkedVehicle = null;
    }

    // Get vehicle type
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    // Get parked vehicle
    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    // Get spot number
    public int getSpotNumber() {
        return spotNumber;
    }
}
