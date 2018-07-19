package Week4.Week4_1;

import java.util.ArrayList;

public class VideoGameDisplay {
    public static void main(String[] args){
        IdGen idGen = new IdGen();
        Audition audition = new Audition(idGen,4, 2, 1);

        displayList(audition.generateAudition());
    }

    public static void displayList(ArrayList<Performer> performers){
        for(Performer p: performers){
            System.out.println(p.toString());
        }
    }
}
