package Tests.Week4;

import Week4.Address;
import Week4.DeliveryMethod;
import Week4.Durability;
import Week4.Parcel;
import Week4.TimeZone.AirZone;
import com.jits.core.Letter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AirZoneTest {
    AirZone airZone;

    @Before
    public void beforeEachTest(){
        airZone = new AirZone();
    }

    @Test
    public void daystoDeliverTest(){
        Address from = new Address("", "", "", "", "1234");
        Address to = new Address("", "", "", "", "5321");
        Parcel parcel = new Letter("", from, to, DeliveryMethod.AIR, Durability.WEATHERPROOF);
        Assert.assertEquals(airZone.daysToDeliver(parcel), 1, 0);
    }

}
