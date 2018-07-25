package Week5.JITSTravelGroup;

import java.util.ArrayList;
import java.util.List;

public class ManagementSystem {
    public static List<Passenger> journey = new ArrayList<Passenger>();

    public static void main(String[] args){
        addCommuter(100, 3, true);
        addCommuter(100, 5, true);
        addCommuter(100, 4, false);
        journey.get(2).requestNewspaper();

        addVactioner(90, 1);
        addVactioner(199, 2);
        journey.get(4).requestNewspaper();

        int numNewspaper = calculateNumNewspaper();
        int numMeals = calculateNumMeals();
        double cost = calculateCost();

        System.out.println("Number of Newspapers: " + numNewspaper);
        System.out.println("Number of Meals: " + numMeals);
        System.out.println("Number of Cost: " + cost);
    }

    public static double calculateCost(){
        double cost = 0;
        for(Passenger p: journey){
            cost += p.calculatePrice();
        }
        return cost;
    }

    public static int calculateNumMeals(){
        int numMeals = 0;
        for(Passenger p: journey){
            if(p instanceof Vacationer){
                numMeals += ((Vacationer) p).getNumMeals();
            }
        }
        return numMeals;
    }

    public static int calculateNumNewspaper(){
        int numNewspaper = 0;
        for(Passenger p: journey){
            numNewspaper += p.getNumNewspapers();
        }
        return numNewspaper;
    }

    public static void addCommuter(double numMiles, double numStops, boolean frequentRiderCard){
        journey.add(new Commuter(numMiles, numStops, frequentRiderCard));
    }

    public static void addVactioner(double numMiles, double numStops){
        journey.add(new Vacationer(numMiles, numStops));
    }
}
