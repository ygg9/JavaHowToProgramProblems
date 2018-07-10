package Tests.Week4;

import Week4.Address;
import Week4.TimeZone.GroundZone;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GroundZoneTest {
    private GroundZone groundZone;

    @Before
    public void beforeTest(){
        groundZone = new GroundZone();
    }

    @Test
    public void getFirstDigitTest(){
        int first = 2;
        Assert.assertEquals(first, groundZone.getFirstDigit("2345645"));
    }

    @Test
    public void getTimeZoneTest(){
        int timeZone = 3;
        Assert.assertEquals(timeZone, groundZone.getTimeZone(9));
    }

    @Test
    public void daysToDeliverTest(){
        Address from = new Address("", "", "", "", "1234");
        Address to = new Address("", "", "", "", "5321");
        Assert.assertEquals(groundZone.daysToDeliver(from, to), 1);

    }
}
