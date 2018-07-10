package Tests.Week2;

import Week2.Week2ReviewedProgram.Automobile;
import Week2.Week2ReviewedProgram.Date;
import org.junit.Assert;
import org.junit.Test;

public class AutomobileTest {
    private Date date = new Date(10, 10, 10);
    private Automobile automobile = new Automobile(date, 10, 100, 100, 100, 100, "HONDA","black");

    @Test
    public void testToString(){
        String expected = "class Week2.Week2ReviewedProgram.Automobile by HONDA with VIN 100 is available to rent in black. This beast has a range of 100.0 and only costs $1.0";
        Assert.assertEquals(expected, automobile.toString());
    }

    @Test //ASK ABOUT THIS
    public void testCalculateRange(){
        //when(vehicle.getRange()).thenReturn(20.0);
        automobile.calculateRange();
    }

    @Test
    public void testConstructor(){
        Automobile defaultAuto = new Automobile();
        Assert.assertEquals("black", defaultAuto.getColor());
    }
}
