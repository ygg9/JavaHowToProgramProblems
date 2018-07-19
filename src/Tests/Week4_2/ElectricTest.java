package Tests.Week4_2;

import Week4.Week4_2.Date;
import Week4.Week4_2.Electric;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.ranges.RangeException;

public class ElectricTest {
    Electric electric;
    @Before
    public void setupTest(){
        Date date = new Date(10, 10, 1000);
        electric = new Electric(date, 1, "grey",3, 2, 3,1,"Honda", 4, true, 10);
    }

    @Test (expected= RangeException.class)
    public void checkRangeTest(){
        electric.checkRange(10);
    }

    @Test
    public void checkRangeTestPass(){
        electric.checkRange(51);
        Assert.assertEquals(51.0, electric.getRange(),0);
    }

    @Test
    public void calculateCostTest(){
        double cost = electric.calculateCost();

        Assert.assertEquals(10.23, cost, 0);
    }

    @Test
    public void toStringTest(){
        String expected = "Electric by Honda with VIN 2 is available to rent in grey. This beast has a range of 3.0 and only costs $10.23 unless range exceeded";

        Assert.assertEquals(expected, electric.toString());
    }
}
