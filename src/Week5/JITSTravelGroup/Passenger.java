package Week5.JITSTravelGroup;

public abstract class Passenger {
    private final double RATE_FACTOR = .5;
    private int numNewspapers = 0;
    private final double numMiles;
    private final double numStops;

    public Passenger(double numMiles, double numStops){
        this.numMiles = numMiles;
        this.numStops = numStops;
    }

    public void requestNewspaper(){
        numNewspapers +=1;
    }

    public abstract double calculatePrice();

    public double getRATE_FACTOR(){
        return RATE_FACTOR;
    }

    public double getNumMiles(){
        return numMiles;
    }

    public double getNumStops(){
        return numStops;
    }

    public int getNumNewspapers(){
        return numNewspapers;
    }
}
