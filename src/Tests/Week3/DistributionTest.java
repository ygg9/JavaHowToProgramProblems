package Tests.Week3;

import Week3.Dist;
import Week3.Distribution;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;

public class DistributionTest {
    private Distribution distribution;

    @Before
    public void beforeEachTest(){
        distribution.mapStatesToDist();
    }

    @Test
    public void mapStatesToDistTest(){
        HashMap<String, Dist> map = Distribution.distributionCenter;
        Assert.assertTrue(map.get("AL").toString().equals("DC2"));
        Assert.assertTrue(map.get("GA").toString().equals("DC1"));
        Assert.assertTrue(map.get("HI").toString().equals("NA"));
        Assert.assertTrue(map.get("MN").toString().equals("DC2"));
        Assert.assertTrue(map.get("MO").toString().equals("DC2"));
    }

    @Test
    public void openZipCodesTest(){
        distribution.openZipCodes();
    }

    @Test
    public void getZipCodesTest(){
        distribution.getZipCodes();
    }

}
