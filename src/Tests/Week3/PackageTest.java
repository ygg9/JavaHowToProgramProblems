package Tests.Week3;

import org.junit.Assert;
import org.junit.Test;
import Week3.Package;

public class PackageTest {
    @Test
    public void compareToTestSmall(){
        Package p1;
        Package p2;
        p1 = new Package(10, "GRD", 10230, 20394, 30, 210, 10, 10, "Hello");
        p2 = new Package(12, "AIR", 10430, 46224, 34, 100, 15, 40, "HILLY");
        Assert.assertEquals(p1.compareTo(p2),-1, 0);
    }

    @Test
    public void compareToTestLarge(){
        Package p1;
        Package p2;
        p1 = new Package(14, "GRD", 10230, 20394, 30, 210, 10, 10, "Hello");
        p2 = new Package(12, "AIR", 10430, 46224, 34, 100, 15, 40, "HILLY");
        Assert.assertEquals(p1.compareTo(p2),1, 0);
    }

    @Test
    public void compareToTestEqual(){
        Package p1;
        Package p2;
        p1 = new Package(10, "GRD", 10230, 20394, 30, 210, 10, 10, "Hello");
        p2 = new Package(10, "AIR", 10430, 46224, 34, 100, 15, 40, "HILLY");
        Assert.assertEquals(p1.compareTo(p2),0, 0);
    }
}
