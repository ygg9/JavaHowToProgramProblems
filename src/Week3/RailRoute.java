package Week3;

public class RailRoute implements TrackerWrite {
    public static void trackingString(Package pack, String regionCode) {
        Writer.getInstance().setWrite(regionCode + "|" + pack.getId() + "|");
    }
}
