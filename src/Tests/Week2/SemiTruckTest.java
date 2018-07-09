package Tests.Week2;

import Week2.Week2ReviewedProgram.Date;
import Week2.Week2ReviewedProgram.SemiTruck;
import org.junit.Test;
import org.w3c.dom.ranges.RangeException;

public class SemiTruckTest {
    private SemiTruck semiTruck = new SemiTruck(new Date(10, 10 ,10), 10, "black", 100, 100, 100, 30, "TESLA", 10, 20, true, 100);

    @Test(expected = RangeException.class)
    public void checkRangeTest(){
        semiTruck.checkRange(10);
    }

    @Test
    public void checkRangeTestPass(){
        semiTruck.checkRange(51);
    }
}
