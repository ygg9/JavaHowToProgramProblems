package Week3;

public class Destination implements TrackerWrite {
    static void trackingString(Package pack) {
        String street = pack.getStreet();
        String concat = street + Integer.toString(pack.getToZip());
        int total = 0;
        for (Character c : concat.toCharArray()) {
            total += (int) c;
        }
        Writer.getInstance().setWrite(Integer.toString(total) + "|" + pack.getId() + "|");
    }
}
