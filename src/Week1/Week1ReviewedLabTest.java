package Week1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Week1ReviewedLabTest {
    @Test
    public void testPerformer(){
        Performer test = new Performer();
        Assert.assertNotNull(test);

        Assert.assertTrue(test.getId() > 0 && test.getId() < 101);
        Assert.assertFalse(test.getId() < 0 || test.getId() > 100);
    }

    @Test
    public void testId(){
        Id identification = Id.getInstance();
        Assert.assertNotNull(identification);

        Assert.assertTrue(identification.uniqueId() > 0 && identification.uniqueId() < 101);
        Assert.assertFalse(identification.uniqueId() < 0 || identification.uniqueId() > 100);
    }

    @Test
    public void testDancer(){
        Dancer ballerina = new Dancer();
        Assert.assertNotNull(ballerina);

        final String[] styles = new String[] { "Ballet", "Jive", "Salsa", "Swing", "Tap"};
        Assert.assertTrue(Arrays.binarySearch(styles, ballerina.getStyle()) >= 0);
    }

    @Test
    public void testVocalistNoVolume(){
        Vocalist gaga = new Vocalist();
        Assert.assertNotNull(gaga);

        final String[] key = new String[] { "A", "B", "C", "D", "E", "F", "G"};
        Assert.assertTrue(Arrays.binarySearch(key, gaga.getKey()) >= 0);
        Assert.assertEquals(0, gaga.getVolume());
    }

    @Test
    public void testVocalist(){
        Vocalist samSmith = new Vocalist(20);
        Assert.assertNotNull(samSmith);

        final String[] key = new String[] { "A", "B", "C", "D", "E", "F", "G"};
        Assert.assertTrue(Arrays.binarySearch(key, samSmith.getKey()) >= 0);
        Assert.assertEquals(20, samSmith.getVolume());
    }
}
