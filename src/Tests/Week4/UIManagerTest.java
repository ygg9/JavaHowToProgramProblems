package Tests.Week4;

import Week4.UIManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UIManagerTest {
    @Mock
    ArrayList<String> mockData = new ArrayList<String>();

    @Mock
    BufferedReader bufferedReader;

    @InjectMocks
    UIManager uiManager = UIManager.getInstance();

    @Test
    public void openStreamTest() throws IOException {
        uiManager.openStream();
    }

    @Test
    public void readStreamTest() throws IOException{
        uiManager.openStream();
        uiManager.readStream();
    }

    @Test
    public void parseDataTest() throws IOException{
        bufferedReader = new BufferedReader(new FileReader("kiosk.txt"));

        when(mockData.get(0)).thenReturn("BG");
        when(mockData.get(1)).thenReturn("104");
        when(mockData.get(2)).thenReturn("Joker");
        when(mockData.get(3)).thenReturn("Hello Street");
        when(mockData.get(4)).thenReturn("Dallas");
        when(mockData.get(5)).thenReturn("Texas");
        when(mockData.get(6)).thenReturn("75080");
        when(mockData.get(7)).thenReturn("Batman");
        when(mockData.get(8)).thenReturn("Batcave cove");
        when(mockData.get(9)).thenReturn("Wayne manor");
        when(mockData.get(10)).thenReturn("BAT BAT STATE");
        when(mockData.get(11)).thenReturn("12345");
        when(mockData.get(12)).thenReturn("null");
        when(mockData.get(13)).thenReturn("103");
        when(mockData.get(14)).thenReturn("245");
        when(mockData.get(15)).thenReturn("1245");

        uiManager.parseData();
    }

    @Test
    public void parseLetterTest(){
        when(mockData.get(0)).thenReturn("LG");
        when(mockData.get(1)).thenReturn("104");
        when(mockData.get(2)).thenReturn("Joker");
        when(mockData.get(3)).thenReturn("Hello Street");
        when(mockData.get(4)).thenReturn("Dallas");
        when(mockData.get(5)).thenReturn("Texas");
        when(mockData.get(6)).thenReturn("75080");
        when(mockData.get(7)).thenReturn("Batman");
        when(mockData.get(8)).thenReturn("Batcave cove");
        when(mockData.get(9)).thenReturn("Wayne manor");
        when(mockData.get(10)).thenReturn("BAT BAT STATE");
        when(mockData.get(11)).thenReturn("12345");
        when(mockData.get(12)).thenReturn("null");
        when(mockData.get(13)).thenReturn("103");
        when(mockData.get(14)).thenReturn("245");
        when(mockData.get(15)).thenReturn("1245");

        uiManager.parseLetter();
    }
}
