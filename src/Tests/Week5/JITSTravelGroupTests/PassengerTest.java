package Tests.Week5.JITSTravelGroupTests;

import Week5.JITSTravelGroup.Passenger;
import Week5.JITSTravelGroup.Vacationer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PassengerTest {
    Passenger testPassenger;

    @Before
    public void setupTest(){
        testPassenger = new Vacationer(100, 200);
    }


    @Test
    public void requestNewsPaperTest(){
        Assert.assertTrue(testPassenger.getNumNewspapers() == 0);

        testPassenger.requestNewspaper();

        Assert.assertTrue(testPassenger.getNumNewspapers() == 1);
    }
}
