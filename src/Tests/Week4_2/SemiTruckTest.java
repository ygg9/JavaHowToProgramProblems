package Tests.Week4_2;

import Week4.Week4_2.Date;
import Week4.Week4_2.SemiTruck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.ranges.RangeException;

public class SemiTruckTest {
    SemiTruck semi;

    @Before
    public void setupTest() {
        Date date = new Date(10, 10, 1000);
        semi = new SemiTruck(date, 1, "grey", 3, 2, 3, 1, "Honda", 4, 4, true,100);
    }

    @Test(expected = RangeException.class)
    public void checkRangeTest() {
        semi.checkRange(10);
    }

    @Test
    public void checkRangeTestPass() {
        semi.checkRange(51);
        Assert.assertEquals(51.0, semi.getRange(), 0);
    }
}
