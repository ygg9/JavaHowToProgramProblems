package Week4;

import com.jits.core.Box;
import com.jits.core.Letter;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UIManager {
    private BufferedReader bufferedReader = null;
    private static UIManager instance;
    @Resource
    private ArrayList<String> data = new ArrayList<String>();

    public static UIManager getInstance() {
        if (instance == null) {
            instance = new UIManager();
        }
        return instance;
    }

    public void openStream() throws IOException {
        bufferedReader = new BufferedReader(new FileReader("kiosk.txt"));
    }

    public void readStream() throws IOException{
        String line = null;
        while((line = bufferedReader.readLine()) != null){
            data.add(line);
        }
    }

    public Parcel parseData() throws IOException{
        if(bufferedReader != null){
            String type = data.get(0);
            if(type.equals("LG") || type.equals("LA")){
                return parseLetter();
            }
            if(type.equals("BG") || type.equals("BA")){
                return parseBox();
            }

        } else{
            throw new IOException();
        }
        return null;
    }

    public Box parseBox(){
        String type = data.get(0);

        DeliveryMethod deliveryMethod = null;
        if (type.equals("BG")){
            deliveryMethod = DeliveryMethod.GROUND;
        }
        if (type.equals("BA")){
            deliveryMethod = DeliveryMethod.AIR;
        }

        String id = data.get(1);
        String toName = data.get(2);
        String toStreet = data.get(3);
        String toCity = data.get(4);
        String toState = data.get(5);
        String toZip = data.get(6);
        String fromName = data.get(7);
        String fromStreet = data.get(8);
        String fromCity = data.get(9);
        String fromState = data.get(10);
        String fromZip = data.get(11);
        String lType = data.get(12);
        Double height = Double.parseDouble(data.get(13));
        Double width = Double.parseDouble(data.get(14));
        Double depth = Double.parseDouble(data.get(15));

        Address to = new Address(toName, toStreet, toCity, toState, toZip);
        Address from = new Address(fromName, fromStreet, fromCity, fromState, fromZip);
        return new Box(id, from, to, deliveryMethod, height, width, depth);
    }

    public Letter parseLetter(){
        String type = data.get(0);

        DeliveryMethod deliveryMethod = null;
        if (type.equals("LG")){
            deliveryMethod = DeliveryMethod.GROUND;
        }
        if (type.equals("LA")){
            deliveryMethod = DeliveryMethod.AIR;
        }

        String id = data.get(1);
        String toName = data.get(2);
        String toStreet = data.get(3);
        String toCity = data.get(4);
        String toState = data.get(5);
        String toZip = data.get(6);
        String fromName = data.get(7);
        String fromStreet = data.get(8);
        String fromCity = data.get(9);
        String fromState = data.get(10);
        String fromZip = data.get(11);
        String lType = data.get(12);

        Durability durability = null;
        if(lType.equals("plain")){
            durability = Durability.PLAIN;
        }
        if(lType.equals("weatherproof")){
            durability = Durability.WEATHERPROOF;
        }
        if(lType.equals("fireproof")){
            durability = Durability.FIREPROOF;
        }

        Double height = Double.parseDouble(data.get(13));
        Double width = Double.parseDouble(data.get(14));
        Double depth = Double.parseDouble(data.get(15));

        Address to = new Address(toName, toStreet, toCity, toState, toZip);
        Address from = new Address(fromName, fromStreet, fromCity, fromState, fromZip);
        return new Letter(id, from, to, deliveryMethod, durability);
    }
}
