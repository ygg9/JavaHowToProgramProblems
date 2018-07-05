package Week2.Chapter8;

public class TrafficLightTest {
    public static void main(String[] args) {
        for (TrafficLight pole : TrafficLight.values()) {
            System.out.println(pole + " " + pole.getDuration());
        }
    }
}
