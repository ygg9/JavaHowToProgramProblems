package Tests.Week4;

import com.jits.core.Address;
import Week4.DeliveryMethod;
import Week4.Durability;
import Week4.Parcel;
import Week4.TimeZone.GroundZone;
import com.jits.core.Letter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GroundZoneTest {
    private GroundZone groundZone;
    private Parcel parcel;

    @Before
    public void beforeTest(){
        groundZone = new GroundZone();
    }

    @Test
    public void shippingCostTest(){
        Address from = new Address("", "", "", "", "1234");
        Address to = new Address("", "", "", "", "9321");
        parcel = new Letter("", from, to, DeliveryMethod.AIR, Durability.WEATHERPROOF);

        Assert.assertEquals(groundZone.shippingCost(parcel), 3*1*1.1, 0);

    }

    @Test
    public void crossRockyTest(){
        Address from = new Address("", "", "", "", "1234");
        Address to = new Address("", "", "", "", "9321");
        parcel = new Letter("", from, to, DeliveryMethod.AIR, Durability.WEATHERPROOF);

        Assert.assertTrue(groundZone.crossRocky(parcel));
    }

    @Test
    public void zoneDifferenceTest(){
        Address from = new Address("", "", "", "", "1234");
        Address to = new Address("", "", "", "", "5321");
        parcel = new Letter("", from, to, DeliveryMethod.AIR, Durability.WEATHERPROOF);

        Assert.assertEquals(groundZone.zoneDifference(parcel), 1, 0);
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
        parcel = new Letter("", from, to, DeliveryMethod.AIR, Durability.WEATHERPROOF);

        Assert.assertEquals(groundZone.daysToDeliver(parcel), 1.5, 0);

        from = new Address("", "", "", "", "2234");
        to = new Address("", "", "", "", "9321");

        parcel = new Letter("", from, to, DeliveryMethod.AIR, Durability.WEATHERPROOF);

        Assert.assertEquals(groundZone.daysToDeliver(parcel), 4.5, 0);

        from = new Address("", "", "", "", "3234");
        to = new Address("", "", "", "", "5321");

        Parcel parcel = new Letter("", from, to, DeliveryMethod.AIR, Durability.WEATHERPROOF);
        Assert.assertEquals(groundZone.daysToDeliver(parcel), 0, 0);

    }
}
