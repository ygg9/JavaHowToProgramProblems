package Tests.Week4_1;

import Week4.Week4_1.Dancer;
import Week4.Week4_1.IdGen;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.powermock.api.mockito.PowerMockito.when;

public class DancerTest {
    @Mock
    IdGen idGen;

    @Before
    public void setUpTest(){
        MockitoAnnotations.initMocks(this);
        when(idGen.generateId()).thenReturn((long)772);
    }

    @Test
    public void toStringTest(){
        Dancer dancer = new Dancer(idGen, "tap");

        String expected = "tap - 772 - dancer";

        Assert.assertEquals(expected, dancer.toString());
    }
}
