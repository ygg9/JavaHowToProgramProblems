package Week3;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class DistributionTest {
    @Test
    public void distributionTest(){
        Distribution distTest = new Distribution();
        distTest.main(null);
        HashMap<String, Distribution.DIST> map = Distribution.distributionCenter;
        Assert.assertTrue(map.get("AL").toString().equals("DC2"));
        Assert.assertTrue(map.get("GA").toString().equals("DC1"));
        Assert.assertTrue(map.get("HI").toString().equals("NA"));
        Assert.assertTrue(map.get("MN").toString().equals("DC2"));
        Assert.assertTrue(map.get("MO").toString().equals("DC2"));
    }

}
