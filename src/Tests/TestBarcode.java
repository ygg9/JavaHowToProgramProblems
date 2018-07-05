package Tests;

import Week3.Barcode;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TestBarcode {
    @Test
    public void testBarcodes() {
        Barcode barcode = mock(Barcode.class);
        String s = "";
        String[] test = {"11112324", "GRD", "30131", "30132", "30.0", "5", "8", "10", "Xalkdjf", "adc", "123 Main street"};
        doReturn(test).when(barcode.splitter(s));

        barcode.validatePackage(barcode.splitter(s));
    }

    @Test
    public void testBarcode1() {
        Barcode bar1 = new Barcode();
        String barcode1 = "11112324|GRD|12345|12345|30.0|5|8|10|Xalkdjf|adc";

        bar1.validatePackage(bar1.splitter(barcode1));
    }

    @Test
    public void testBarcode2() {
        Barcode bar2 = new Barcode();
        String barcode2 = "11112324|AIR|12345|12345|30.0|5|8|10|Xalkdjf|adc";

        bar2.validatePackage(bar2.splitter(barcode2));
    }

    @Test
    public void testBarcode3() {
        Barcode bar3 = new Barcode();
        String barcode3 = "11112324|RAL|12354|12354|30.0|5|8|10|Xalkdjf|adc";

        bar3.validatePackage(bar3.splitter(barcode3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBarcode4() {
        Barcode bar4 = new Barcode();
        String barcode4 = "11112224|Gll|123dd|1d34|31.0|1-00|8|10|Xalkdjf|adc";

        bar4.validatePackage(bar4.splitter(barcode4));
    }


}
