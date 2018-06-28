package Week1.Week1ReviewedLab;

public class Performer{
    public int getId() {
        return id;
    }

    private int id;
    Performer(){
        Id generateId = Id.getInstance();
        id = generateId.uniqueId();
    }
}
