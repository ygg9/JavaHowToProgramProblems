package Week1;

public class Vocalist extends Performer{
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