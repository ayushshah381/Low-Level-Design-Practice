public class TrafficLight {
    private final String id;
    private int redSignalDuration;
    private int yellowSignalDuration;
    private int greenSignalDuration;
    private Signal currentSignal;

    public TrafficLight(String id, int redSignalDuration, int yellowSignalDuration, int greenSignalDuration) {
        this.id = id;
        this.redSignalDuration = redSignalDuration;
        this.yellowSignalDuration = yellowSignalDuration;
        this.greenSignalDuration = greenSignalDuration;
        this.currentSignal = Signal.RED;
    }

    public int getRedSignalDuration() {
        return redSignalDuration;
    }

    public void setRedSignalDuration(int duration) {
        this.redSignalDuration = duration;
    }

    public int getYellowSignalDuration() {
        return yellowSignalDuration;
    }

    public void setYellowSignalDuration(int duration) {
        this.yellowSignalDuration = duration;
    }

    public int getGreenSignalDuration() {
        return greenSignalDuration;
    }

    public void setGreenSignalDuration(int duration) {
        this.greenSignalDuration = duration;
    }

    public synchronized void setCurrentSignal(Signal signal) {
        this.currentSignal = signal;
        // notify all the roads (observers)
        this.notifyObservers();

    }

    public String getTrafficLightId() {
        return this.id;
    }

    private void notifyObservers() {
        System.out.println("Signal changed to: " + this.currentSignal);
    }
}
