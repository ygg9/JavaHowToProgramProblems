package Tests.Week2;

import Week2.Week2ReviewedProgram.Date;
import Week2.Week2ReviewedProgram.Electric;
import org.junit.Test;
import org.w3c.dom.ranges.Range;
import org.w3c.dom.ranges.RangeException;

public class ElectricTest {
    private Electric electric = new Electric(new Date(10, 10 ,10), 10, "black", 100, 100, 100, 30, "TESLA", 10, true, 10);

    @Test (expected = RangeException.class)
    public void checkRangeTest(){
        electric.checkRange(10);
    }

    @Test
    public void checkRangeTestPass(){
        electric.checkRange(51);
    }
}
