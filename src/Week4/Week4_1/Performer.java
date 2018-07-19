package Week4.Week4_1;

public class Performer {
    private int id;

    public Performer(IdGen idGen){
        this.id = (int)idGen.generateId();
    }

    @Override
    public String toString(){
        return id + " - performer";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
