package Tests.Week4_2;

import Week4.Week4_2.Automobile;
import Week4.Week4_2.Date;
import Week4.Week4_2.Vehicle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AutomobileTest {
    Vehicle automobile;

    @Before
    public void setupTest(){
        Date date = new Date(10, 10, 1000);
        automobile = new Automobile(date, 1, 3, 2, 3,1,"Honda");
    }

    @Test
    public void calculateCostTest(){
        double cost = automobile.calculateCost();

        Assert.assertEquals(.23, cost, 0);
    }

    @Test
    public void toStringTest(){
        String expected = "Automobile by Honda with VIN 2 is available to rent in black. This beast has a range of 3.0 and only costs $0.23";

        Assert.assertEquals(expected, automobile.toString());
    }
}
