package Tests.Week4_2;

import Week4.Week4_2.Date;
import Week4.Week4_2.DiscountDayz;
import org.junit.Assert;
import org.junit.Test;

public class DiscountDayzTest {
    @Test
    public void isDiscountDayTest(){
        Date date = new Date(10,10,1010);

        Assert.assertTrue(DiscountDayz.isDiscountDay(date));
    }

    @Test
    public void isDiscountDayTestFalse(){
        Date date = new Date(10,11,1010);

        Assert.assertFalse(DiscountDayz.isDiscountDay(date));
    }
}
