package Tests.Week3;

import Week3.Package;
import Week3.PackageManager;
import org.junit.Test;

public class PackageManagerTest {

    @Test // no way to test static methods without going to differnt version of junit
    public void getAirportCodeToTest(){
        Package pack = new Package(10, "GRD", 30131, 30132, 30, 210, 10, 10, "Hello");
        PackageManager.getAirportCodeTo(pack);
    }
}
