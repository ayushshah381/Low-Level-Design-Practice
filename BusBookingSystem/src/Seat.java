public class Seat {
    private String seatNumber;
    private SeatStatus status;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.status = SeatStatus.AVAILABLE;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}
