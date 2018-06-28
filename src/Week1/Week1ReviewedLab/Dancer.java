package Week1.Week1ReviewedLab;


public class Dancer extends Performer {
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