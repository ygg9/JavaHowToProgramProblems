package Tests.Week2;

import Week2.Week2ReviewedProgram.Date;
import org.junit.Assert;
import org.junit.Test;

public class DateTest {
    Date date = new Date(10, 20, 1998);

    @Test
    public void getMonthTest(){
        Assert.assertEquals(date.getMonth(), 10, 0);
    }

    @Test //???
    public void setMonthTest(){

    }
}
