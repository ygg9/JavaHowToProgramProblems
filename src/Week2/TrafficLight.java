package Week2;

public enum TrafficLight {
    RED(10),
    GREEN(20),
    YELLOW(5);

    private final int duration;

    TrafficLight(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}
