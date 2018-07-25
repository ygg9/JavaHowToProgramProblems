package Tests.Week5.JITSTravelGroupTests;

import Week5.JITSTravelGroup.Vacationer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VacationerTest {
    Vacationer vacationerTest;

    @Before
    public void setupTest(){
        vacationerTest = new Vacationer(100, 100);
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkRangeTestBelow(){
        vacationerTest.checkRange(0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkRangeTestAbove(){
        vacationerTest.checkRange(4001);
    }

    @Test
    public void calculatePriceTest(){
        Assert.assertEquals(50.0, vacationerTest.calculatePrice(), 0);
    }

    @Test
    public void calculateMealsTest(){
        Assert.assertEquals(6, vacationerTest.calculateMeals(503));
        Assert.assertEquals(3, vacationerTest.calculateMeals(300));
    }

}
