public class Bus {
    private final String busId;
    private final String registrationNumber;
    private final BusType busType; // Using our enum here
    private final int totalSeats;

    public Bus(String busId, String registrationNumber, BusType busType, int totalSeats) {
        this.busId = busId;
        this.registrationNumber = registrationNumber;
        this.busType = busType;
        this.totalSeats = totalSeats;
    }

    public String getBusId() { return busId; }
    public int getTotalSeats() { return totalSeats; }
    public BusType getBusType() { return busType; }
}