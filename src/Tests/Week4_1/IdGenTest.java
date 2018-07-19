package Tests.Week4_1;

import Week4.Week4_1.IdGen;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.when;

public class IdGenTest {

    @Test
    public void generateIdTest(){
        IdGen idGen = new IdGen();

        Assert.assertTrue(idGen.generateId() > 0);
        Assert.assertTrue(idGen.generateId() < 2001);
    }
}
