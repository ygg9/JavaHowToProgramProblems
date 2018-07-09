package Tests.Week3;

import Week3.Barcode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class TestBarcode {

    @Before
    public void setUpBarcodes(){
        Barcode.createBarcodes();
    }

    @Test
    public void testSplitter(){
        String[] empty = {""};
        Assert.assertTrue(Arrays.equals(empty, Barcode.splitter("")));

        String[] split = {"Telephone", "Bob", "Gross", "Pinapple"};
        Assert.assertTrue(Arrays.equals(split, Barcode.splitter("Telephone|Bob|Gross|Pinapple")));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShipValidate(){
        Barcode.shipValidate("HELLO");
    }

    @Test (expected = NumberFormatException.class)
    public void testIdValidate(){
        Barcode.idValidate("id");
    }

    @Test (expected = NumberFormatException.class)
    public void testZipValidate(){
        Barcode.zipValidate("1234567");
    }

    @Test (expected = NumberFormatException.class)
    public void weightValidate(){
        Barcode.weightValidate("hhi");
    }

    @Test (expected = NumberFormatException.class)
    public void dimensionValidate(){
        Barcode.dimensionValidate("height is 100");
    }
}
