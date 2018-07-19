package Tests.Week4_1;

import Week4.Week4_1.IdGen;
import Week4.Week4_1.Performer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.powermock.api.mockito.PowerMockito.when;


public class PerformerTest {
    @Mock
    IdGen idGen;

    @Before
    public void setUpTest(){
        MockitoAnnotations.initMocks(this);
        when(idGen.generateId()).thenReturn((long)324);
    }

    @Test
    public void toStringTest(){
        Performer performer = new Performer(idGen);

        String expected = "324 - performer";
        Assert.assertEquals(expected, performer.toString());
    }
}
