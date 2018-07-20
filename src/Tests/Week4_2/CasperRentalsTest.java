package Tests.Week4_2;

import Week4.Week4_2.CasperRentals;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CasperRentalsTest {
    @Before
    public void setupTest(){
        CasperRentals.createAvailableVehicles();
    }

    @Test
    public void calculatorCostTest(){
        double cost = 172029.24;

        double calculator = CasperRentals.calculatorCost(1, 10, 2, 4, 2,2, 4,1);

        Assert.assertEquals(cost, calculator, 0);
    }

    @Test
    public void applyDiscountTest(){
        double cost = 86014.62;

        double calculator = CasperRentals.applyDiscount(1, 10, 2, 4, 2,2, 4,1);

        Assert.assertEquals(cost, calculator, 0);
    }
}
