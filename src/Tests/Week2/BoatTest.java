package Tests.Week2;

import Week2.Week2ReviewedProgram.Boat;
import Week2.Week2ReviewedProgram.BoatType;
import Week2.Week2ReviewedProgram.Vehicle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BoatTest {
    /*
    Boat boat = null;

    @Before
    public void beforeEachTest(){
        boat = mock(Boat.class);
        when(boat.getClass()).thenReturn();

    }
    */

    @Test
    public void calculateRangeTest(){
        Boat boat = new Boat(100, 20, 100, 100, BoatType.SPEED);
        Assert.assertEquals(700, boat.getRange(), 0);
    }

    @Test
    public void toStringTest(){
        Boat boat1 = new Boat(100, 300, 100, 100, BoatType.YACHT);
        String expected = "class Week2.Week2ReviewedProgram.Boat with VIN 300 is available to rent. This beauty has a range of 700.0 and only costs $60000.42857142857";
        Assert.assertEquals(expected, boat1.toString());
    }


}
