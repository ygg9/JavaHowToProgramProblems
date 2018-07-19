package Tests.Week4_1;

import Week4.Week4_1.IdGen;
import Week4.Week4_1.Vocalist;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class VocalistTest {
    @Mock
    IdGen idGen;

    @Before
    public void setupTest(){
        MockitoAnnotations.initMocks(this);
        when(idGen.generateId()).thenReturn((long)1191);
    }

    @Test
    public void toStringTest(){
        Vocalist vocalist = new Vocalist(idGen,"G");

        String expected = "I sing in the key of - G - 1191";
        Assert.assertEquals(expected, vocalist.toString());
    }

    @Test public void toStringVolumeTest(){
        Vocalist vocalist = new Vocalist(idGen, "G", 7);

        String expected = "I sing in the key of - G - at the volume of 7 - 1191";
        Assert.assertEquals(expected, vocalist.toString());
    }
}