package Week1;

import java.util.ArrayList;

public class Week1ReviewedLab {
    public static void main(String[] args){
        for (int i = 0; i<4; i++){
            Performer jimmy = new Performer();
            System.out.println(jimmy.getId() + " - performer");
        }
        for (int j = 0; j<2; j++){
            Dancer bob = new Dancer();
            System.out.println(bob.getStyle() + " - " + bob.getId() + " - dancer");
        }
        int rand = (int)(Math.random() * 2 + 1);
        if(rand == 1){
            rand = (int)(Math.random() * 5 + 1);
            Vocalist joe = new Vocalist(rand);
            System.out.println("I sing in the key of - " + joe.getKey() + " - at the volume " + joe.getVolume() + " - "  + joe.getId());
        }
        else{
            Vocalist joe = new Vocalist();
            System.out.println("I sing in the key of - " + joe.getKey() + " - " + joe.getId());
        }
    }
}

class Performer{
    public int getId() {
        return id;
    }

    private int id;
    Performer(){
        Id generateId = Id.getInstance();
        id = generateId.uniqueId();
    }
}

class Dancer extends Performer{
    public String getStyle() {
        return style;
    }

    private String style;
    Dancer(){
        style = randomStyle();
    }

    private String randomStyle(){
        int randomInt = (int)(Math.random() * 5 + 1);
        String randomStyle = "";
        switch(randomInt){
            case 1:
                randomStyle = "Ballet";
                break;
            case 2:
                randomStyle = "Jive";
                break;
            case 3:
                randomStyle = "Salsa";
                break;
            case 4:
                randomStyle = "Swing";
                break;
            case 5:
                randomStyle = "Tap";
                break;
        }
        return randomStyle;
    }
}

class Vocalist extends Performer{
    public String getKey() {
        return key;
    }

    public int getVolume() {
        return volume;
    }

    private String key;
    private int volume;
    Vocalist(){
        key = randomKey();
        volume = 0;
    }

    Vocalist(int volume){
        key = randomKey();
        this.volume = volume;
    }

    private String randomKey(){
        int randomInt = (int)(Math.random() * 7 + 1);
        String random = "";
        switch(randomInt){
            case 1:
                random = "A";
                break;
            case 2:
                random = "B";
                break;
            case 3:
                random = "C";
                break;
            case 4:
                random = "D";
                break;
            case 5:
                random = "E";
                break;
            case 6:
                random = "F";
                break;
            case 7:
                random = "G";
                break;
        }
        return random;
    }
}

class Id{
    private ArrayList<Integer> uniqueId = new ArrayList();

    private static Id instance;

    private Id(){}

    public static Id getInstance(){
        if(instance == null){
            instance = new Id();
        }
        return instance;
    }

    public int uniqueId(){
        boolean unique = false;
        int random = 0;
        while(!unique){
            random = (int)(Math.random() * 100 + 1);
            if(!uniqueId.contains(new Integer(random))){
                unique = true;
            }
        }
        return random;
    }
}