package Tests.Week4;

import Week4.TimeZone.RailZone;
import org.junit.Assert;
import org.junit.Test;

public class RailZoneTest {
    @Test
    public void getTimeZoneTest1(){
        int i = 1;
        RailZone railZone = new RailZone();
        Assert.assertEquals(railZone.getTimeZone(i), 0, 0);
    }

    @Test
    public void getTimeZoneTest9(){
        int i = 9;
        RailZone railZone = new RailZone();
        Assert.assertEquals(railZone.getTimeZone(i), 1, 0);
    }
}
