package Week3;

public class Warehouse implements TrackerWrite {
    public static void trackingString(Package pack){
        Writer.getInstance().setWrite("Whse|" + pack.getId() + "|");
    }
}
