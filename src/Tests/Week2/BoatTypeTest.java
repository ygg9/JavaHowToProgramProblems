package Tests.Week2;

import Week2.Week2ReviewedProgram.BoatType;
import org.junit.Assert;
import org.junit.Test;

public class BoatTypeTest {
    @Test
    public void getLuxuryTaxTest(){
        BoatType barge = BoatType.BARGE;
        BoatType cargo = BoatType.CARGO;
        BoatType speed = BoatType.SPEED;
        BoatType yacht = BoatType.YACHT;

        Assert.assertEquals(barge.getLuxuryTax(), 5000, 0);
        Assert.assertEquals(cargo.getLuxuryTax(), 8500, 0);
        Assert.assertEquals(speed.getLuxuryTax(), 2200, 0 );
        Assert.assertEquals(yacht.getLuxuryTax(), 60000, 0);
    }
}
