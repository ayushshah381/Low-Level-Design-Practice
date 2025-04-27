public class Driver {
    private int id;
    private String name;
    private String contact;
    private String licensePlate;
    private Location location;
    private DriverStatus driverStatus;

    public Driver(String contact, int id, String name, String licensePlate, Location location, DriverStatus driverStatus) {
        this.contact = contact;
        this.id = id;
        this.name = name;
        this.licensePlate = licensePlate;
        this.location = location;
        this.driverStatus = driverStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }
}
