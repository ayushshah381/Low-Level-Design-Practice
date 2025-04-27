public class Ride {
    private int id;
    private Passenger passenger;
    private Driver driver;
    private Location source;
    private Location destination;
    private RideStatus status;
    private double fare;

    public Ride(int id, Driver driver, Location source, Location destination, RideStatus rideStatus, double fare, Passenger passenger) {
        this.id = id;
        this.driver = driver;
        this.source = source;
        this.destination = destination;
        this.status = rideStatus;
        this.fare = fare;
        this.passenger = passenger;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public int getId() {
        return id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public Location getSource() {
        return source;
    }

    public Location getDestination() {
        return destination;
    }

    public RideStatus getStatus() {
        return status;
    }

    public double getFare() {
        return fare;
    }
}
