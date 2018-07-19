package Week4.Week4_1;

public class Vocalist extends Performer {
    private String key;
    private Integer volume = null;

    public Vocalist(IdGen idGen, String key){
        super(idGen);
        this.key = key;
    }

    public Vocalist(IdGen idGen, String key, int volume){
        super(idGen);
        this.key = key;
        this.volume = volume;
    }

    @Override
    public String toString(){
        if(this.volume != null){
            return "I sing in the key of - " + key + " - at the volume of " + volume + " - " + super.getId();
        }else{
            return "I sing in the key of - " + key + " - " + super.getId();
        }
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
}
