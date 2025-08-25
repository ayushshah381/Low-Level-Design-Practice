public class Route {
    private final String routeId;
    private final String source;
    private final String destination;

    public Route(String routeId, String source, String destination) {
        this.routeId = routeId;
        this.source = source;
        this.destination = destination;
    }

    public String getSource() { return source; }
    public String getDestination() { return destination; }
}