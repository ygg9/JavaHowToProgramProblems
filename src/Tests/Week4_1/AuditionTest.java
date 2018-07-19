package Tests.Week4_1;

import Week4.Week4_1.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.when;


public class AuditionTest {
    private Performer performer;
    private Dancer dancer;
    private Vocalist vocalist;

    @Mock
    IdGen idGen;

    @Mock
    Audition audition;

    @Before
    public void setUpTest(){
        MockitoAnnotations.initMocks(this);
        when(idGen.generateId()).thenReturn((long)100);

        performer = new Performer(idGen);
        dancer = new Dancer(idGen, "Tap");
        vocalist = new Vocalist(idGen, "G");

        when(audition.generatePerfomer()).thenReturn(performer);
        when(audition.generateDancer()).thenReturn(dancer);
        when(audition.generateVocalist()).thenReturn(vocalist);
    }

    @Test
    public void generatePerformerTest(){
        audition = new Audition(idGen,2,2,4);

        ArrayList<Performer> auditionList = audition.generateAudition();

        String expectedPerfomer = "100 - performer";

        String returnedPerformer = auditionList.get(0).toString();

        Assert.assertEquals(expectedPerfomer, returnedPerformer);

        Assert.assertEquals(8, auditionList.size());
    }
}
