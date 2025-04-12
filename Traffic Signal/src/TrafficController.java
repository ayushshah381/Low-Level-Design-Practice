import java.util.HashMap;
import java.util.Map;

public class TrafficController {
    private static TrafficController instance;
    private final Map<String, Road> roads;

    public TrafficController() {
        roads = new HashMap<>();
    }

    public static synchronized TrafficController getInstance() {
        if(instance == null) {
            instance = new TrafficController();
        }
        return instance;
    }

    public void addRoad(Road road) {
        roads.put(road.getRoadId(), road);
    }

    public void removeRoad(String roadId) {
        roads.remove(roadId);
    }

    public void startTrafficControl() {
        for(Road road: roads.values()) {
            TrafficLight trafficLight = road.getTrafficLight();
            Thread t1 = new Thread(() -> {
                while (true) {
                    try {
                        // Stop the red signal, switch to green
                        Thread.sleep(trafficLight.getRedSignalDuration());
                        trafficLight.setCurrentSignal(Signal.GREEN);

                        // Stop the green signal, make it to yellow state
                        Thread.sleep(trafficLight.getGreenSignalDuration());
                        trafficLight.setCurrentSignal(Signal.YELLOW);

                        // Stop the yellow signal, make it red
                        Thread.sleep(trafficLight.getYellowSignalDuration());
                        trafficLight.setCurrentSignal(Signal.RED);

                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t1.start();
        }
    }

    public void handleEmergency(String roadId) {
        Road road = roads.get(roadId);
        if (road != null) {
            TrafficLight trafficLight = road.getTrafficLight();
            trafficLight.setCurrentSignal(Signal.GREEN);
            // Perform emergency handling logic
            // ...
        }
    }
}
