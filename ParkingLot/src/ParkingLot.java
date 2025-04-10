import java.util.ArrayList;
import java.util.List;

import VehicleType.Vehicle;

public class ParkingLot {
    private static ParkingLot instance;
    private List<Level> allLevels;

    private ParkingLot() {
        allLevels = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if(instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addLevel(Level level) {
        allLevels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for(Level level: allLevels) {
            if(level.parkVehicle(vehicle)) {
                System.out.println("Vehicle parked successfully!");
                return true;
            }
        }
        System.out.println("Could not find a parking spot for this vehicle.");
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for(Level level: allLevels) {
            if(level.unparkVehicle(vehicle)) {
                System.out.println("Vehicle unparked successfully!");
                return true;
            }
        }
        System.out.println("Could not find this vehicle.");
        return false;
    }

    public void displayAvailability() {
        for (Level level : allLevels) {
            level.displayAvailability();
        }
    }
}
