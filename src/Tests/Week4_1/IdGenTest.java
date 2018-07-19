package Tests.Week4_1;

import Week4.Week4_1.IdGen;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
//@PrepareForTest(Math.class)
@PrepareForTest(IdGen.class)
public class IdGenTest {
    IdGen idGen;

    @Before
    public void setupTest(){
        idGen = new IdGen();
    }

    @Test
    public void generateStaticTest(){
        PowerMockito.mockStatic(IdGen.class);
        when(IdGen.generateStatic()).thenReturn(200);

        Assert.assertEquals(200, IdGen.generateStatic());
    }

    @Test
    public void generateIdTestStatic(){
        PowerMockito.mockStatic(Math.class);
        when(Math.random()).thenReturn((double).1);

        Assert.assertEquals(201, idGen.generateId());
    }

    @Test
    public void generateIdTest(){


        Assert.assertTrue(idGen.generateId() > 0);
        Assert.assertTrue(idGen.generateId() < 2001);
    }
}
