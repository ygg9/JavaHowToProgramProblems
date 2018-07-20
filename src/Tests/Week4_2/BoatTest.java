package Tests.Week4_2;

import Week4.Week4_2.Boat;
import Week4.Week4_2.BoatType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoatTest {
    Boat boat;

    @Before
    public void setupTest(){
        boat = new Boat(10,10,10,10,BoatType.SPEED);
    }

    @Test
    public void calculateRangeTest(){
        Assert.assertEquals(70,boat.getRange(),0);

        boat.calculateRange();

        Assert.assertEquals(490, boat.getRange(),0);
    }

    @Test
    public void toStringTest(){
        String expected = "Speed with VIN 10 is available to rent. This beauty has a range of 70.0 and only costs $2200.15";
        Assert.assertEquals(expected, boat.toString());
    }
}
