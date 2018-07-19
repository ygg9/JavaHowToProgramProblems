package Week4.Week4_1;

import java.util.ArrayList;

public class Audition {
    private IdGen idGen;
    private int performers;
    private int dancers;
    private int vocalists;

    ArrayList<Performer> audition = new ArrayList<Performer>();

    public Audition(IdGen idGen, int performers, int dancers, int vocalists){
        this.idGen = idGen;
        this.performers = performers;
        this.dancers = dancers;
        this.vocalists = vocalists;
    }

    public ArrayList<Performer> generateAudition(){
        for(int i = 0; i < performers; i++){
            audition.add(generatePerfomer());
        }
        for(int j = 0; j < dancers; j++){
            audition.add(generateDancer());
        }
        for(int l = 0; l < vocalists; l++){
            int random = (int)(Math.random()*2);
            int volume = (int)(Math.random()*10) + 1;
            if(random == 0){
                audition.add(generateVocalist());
            } else{
                audition.add(generateVocalistVolume(volume));
            }
        }
        return audition;
    }

    public Performer generatePerfomer(){
        return new Performer(idGen);
    }

    public Dancer generateDancer(){
        return new Dancer(idGen, "Tap");
    }

    public Vocalist generateVocalist(){
        return new Vocalist(idGen, "G");
    }

    public Vocalist generateVocalistVolume(int volume){
        return new Vocalist(idGen, "G", volume);
    }

}
