package Week5.JITSTravelGroup;

public class Commuter extends Passenger {
    private boolean frequentRiderCard = false;

    public Commuter(double numMiles, double numStops, boolean frequentRiderCard){
        super(numMiles, numStops);
        this.frequentRiderCard = frequentRiderCard;
    }

    public double calculatePrice(){
        if(frequentRiderCard){
            return getRATE_FACTOR() * getNumStops() * .9;
        } else{
            return getRATE_FACTOR() * getNumStops();
        }
    }

}


