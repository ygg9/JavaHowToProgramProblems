package Week5.JITSTravelGroup;

public class Vacationer extends Passenger {
    public int numMeals = 0;

    public Vacationer(double numMiles, double numStops){
        super(numMiles, numStops);

        try{
            checkRange(numMiles);
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }

        numMeals = calculateMeals(numMiles);
    }

    public int getNumMeals() {
        return numMeals;
    }

    public void checkRange(double numMiles) throws IllegalArgumentException{
        if(numMiles < 5 || numMiles > 4000){
            throw new IllegalArgumentException("Range not acceptable");
        }
    }

    public int calculateMeals(double numMiles){
        if(numMiles%100 != 0){
            return (int)numMiles/100 + 1;
        } else{
            return (int)numMiles/100;
        }

    }

    public double calculatePrice(){
        return getRATE_FACTOR() * getNumMiles();
    }
}
