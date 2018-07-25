package Tests.Week5.JITSTravelGroupTests;

import Week5.JITSTravelGroup.Commuter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommuterTest {
    Commuter testCommuterFrequentRider;
    Commuter testCommuter;

    @Before
    public void setupTest(){
        testCommuterFrequentRider = new Commuter(100, 100, true);
        testCommuter = new Commuter(100, 100, false);
    }

    @Test
    public void calculatePriceFrequentTest(){
        Assert.assertEquals(45.0,testCommuterFrequentRider.calculatePrice(), 0);
    }

    @Test
    public void calculatePriceTest(){
        Assert.assertEquals(50.0, testCommuter.calculatePrice(), 0);
    }
}
