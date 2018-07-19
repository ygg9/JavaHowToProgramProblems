package Week4.Week4_1;

public class Dancer extends Performer {
    private final String style;

    public Dancer(IdGen idGen, String style){
        super(idGen);
        this.style = style;
    }

    @Override
    public String toString(){
        return style + " - " + super.getId() + " - dancer";
    }

    public String getStyle() {
        return style;
    }
}
