import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Schedule {
    private String scheduleId;
    private Bus bus;
    private Route route;
    private LocalDateTime departureTime;
    private List<Seat> seats;

    public Schedule(String scheduleId, Bus bus, Route route, LocalDateTime departureTime) {
        this.scheduleId = scheduleId;
        this.bus = bus;
        this.route = route;
        this.departureTime = departureTime;
        this.seats = initializeSeats();
    }

    // initialize the seats for each schedule
    private List<Seat> initializeSeats() {
        return IntStream.rangeClosed(1, this.bus.getTotalSeats())
                .mapToObj(seatNum -> new Seat("S" + seatNum))
                .collect(Collectors.toList());
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public Bus getBus() {
        return bus;
    }

    public Route getRoute() {
        return route;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
