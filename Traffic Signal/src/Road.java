public class Road {
    private final String roadId;
    private final String name;
    private TrafficLight trafficLight;

    public Road(String id, String name) {
        this.roadId = id;
        this.name = name;
    }

    public void setTrafficLight(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public TrafficLight getTrafficLight() {
        return this.trafficLight;
    }

    public String getRoadId() {
        return this.roadId;
    }

    public String getRoadName() {
        return this.name;
    }
}
