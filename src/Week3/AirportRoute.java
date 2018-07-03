package Week3;

public class AirportRoute implements TrackerWrite {
    public static void trackingString(Package pack, String AirportCode){
        Writer.getInstance().setWrite(AirportCode + "|" + pack.getId() + "|");
    }
}
