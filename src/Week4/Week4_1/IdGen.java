package Week4.Week4_1;

public class IdGen {
    public long generateId(){
        return (long)(Math.random()*2000) + 1;
    }

    public static int generateStatic(){
        return 100;
    }
}
