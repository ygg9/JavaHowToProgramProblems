package Week1;

import java.util.ArrayList;

public class Id{
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
            if(!uniqueId.contains(random)){
                unique = true;
            }
        }
        return random;
    }
}
