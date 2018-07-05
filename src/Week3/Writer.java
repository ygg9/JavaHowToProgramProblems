package Week3;

import com.jits.shipping.util.TrackingWriter;

import java.util.Date;

public class Writer {
    private static TrackingWriter write = new TrackingWriter("tracking.txt", false);
    private static Writer instance;
    private static Date date = new Date();

    private Writer() {
    }

    public static Writer getInstance() {
        if (instance == null) {
            instance = new Writer();
        }
        return instance;
    }

    public static void setWrite(String trackingString) {
        write.write(trackingString + date.toString());
    }

}
