package Tests.Week4;

import Week4.Address;
import Week4.TimeZone.AirZone;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AirZoneTest {
    AirZone airZone;

    @Before
    public void beforEachTest(){
        airZone = new AirZone();
    }

    @Test
    public void daystoDeliverTest(){
        Address from = new Address("", "", "", "", "1234");
        Address to = new Address("", "", "", "", "5321");
        Assert.assertEquals(airZone.daysToDeliver(from, to), 4);
    }

}
