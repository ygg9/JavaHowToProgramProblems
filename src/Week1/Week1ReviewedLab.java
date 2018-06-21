package Week1;

public class Week1ReviewedLab {
    public static void main(String[] args){
        int numPerformers = 4;
        int numDancers = 2;
        int numVocalist = 1;

        printPerformers(numPerformers);
        printDancers(numDancers);
        printVocalists(numVocalist);

    }

    private static void printPerformers(int numberOfPerformers){
        for (int i = 0; i<numberOfPerformers; i++){
            Performer jimmy = new Performer();
            System.out.println(jimmy.getId() + " - performer");
        }
    }

    private static void printDancers(int numberOfDancers){
        for (int i = 0; i<numberOfDancers; i++){
            Dancer bob = new Dancer();
            System.out.println(bob.getStyle() + " - " + bob.getId() + " - dancer");
        }
    }

    private static void printVocalists(int numOfVocalists){
        for (int i = 0; i<numOfVocalists; i++){
            int rand = (int)(Math.random() * 2 + 1);
            if(rand == 1){
                rand = (int)(Math.random() * 5 + 1);
                Vocalist joe = new Vocalist(rand);
                System.out.println("I sing in the key of - " + joe.getKey() + " - at the volume " + joe.getVolume() + " - "  + joe.getId());
            }
            else{
                Vocalist joe = new Vocalist();
                System.out.println("I sing in the key of - " + joe.getKey() + " - " + joe.getId());
            }
        }
    }
}