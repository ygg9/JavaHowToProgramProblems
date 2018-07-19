package Week4.Week4_2;

import java.util.HashMap;
import java.util.Map;

public class CasperRentals {
    public static Map<String, Vehicle> rentalVehicles = new HashMap<String, Vehicle>();


    public static void main(String[] args) {
        Date date = new Date(10, 20, 2020);
        int standard = 1;
        int electric = 2;
        int diesel = 1;
        int semiTruck = 1;
        int yacht = 1;
        int speed = 1;
        int barge = 0;
        int cargo = 0;
        double cost;
        createAvailableVehicles();

        System.out.println();
        System.out.print("The cost to rent 2 electric cars, a speed boat, yacht, semi truck, diesel, and standard vehicle is: $");


        if(DiscountDayz.isDiscountDay(date)){
            cost = applyDiscount(standard, electric, diesel, semiTruck, yacht, speed, barge, cargo);
        } else{
            cost = calculatorCost(standard, electric, diesel, semiTruck, yacht, speed, barge, cargo);
        }

        System.out.print(cost);

    }

    public static double applyDiscount(int s, int e, int d, int sem, int y, int speed, int b, int c){
        return .5 * calculatorCost(s, e, d, sem, y, speed, b, c);
    }

    public static double calculatorCost(int standardNum, int electricNum, int dieselNum, int semiTruckNum, int yachtNum, int speedNum, int bargeNum, int cargoNum)
    {
        double standardCost = rentalVehicles.get("standard").calculateCost();
        double electricCost = rentalVehicles.get("electric").calculateCost();
        double dieselCost = rentalVehicles.get("diesel").calculateCost();
        double semiCost = rentalVehicles.get("semiTruck").calculateCost();
        double yachtCost = rentalVehicles.get("yacht").calculateCost();
        double speedCost = rentalVehicles.get("speed").calculateCost();
        double bargeCost = rentalVehicles.get("barge").calculateCost();
        double cargoCost = rentalVehicles.get("cargo").calculateCost();

        return standardCost * standardNum + electricCost * electricNum + dieselCost * dieselNum + semiCost * semiTruckNum + yachtCost * yachtNum + speedCost * speedNum + bargeCost * bargeNum + cargoCost * cargoNum;

    }
    public static void createAvailableVehicles(){
        Vehicle standard = new Automobile(new Date(11, 30, 1995), 4,40, 40, 12, 3000, "HONDA", "grey");
        Vehicle electric = new Electric(new Date(5, 4, 1999), 4, "red", 50, 102, 76, 15000, "TESLA", 4, true, 153);
        Vehicle diesel = new Diesel(new Date(3, 12, 2018), 2, "orange", 100, 101, 54, 8000, "FORD", 18, 5, 50);
        Vehicle semiTruck = new SemiTruck(new Date(10, 20, 2016), 5, "green", 300, 103, 66, 20000, "SUBARU", 3, 1, true, 3000);

        Vehicle yacht = new Boat(100, 100, 8047, 985000, BoatType.YACHT);
        Vehicle speed = new Boat(50, 123, 123, 35000, BoatType.SPEED);
        Vehicle barge = new Boat(200, 120, 893, 500000, BoatType.BARGE);
        Vehicle cargo = new Boat(300, 122, 542, 750000, BoatType.CARGO);

        rentalVehicles.put("standard", standard);
        rentalVehicles.put("electric", electric);
        rentalVehicles.put("diesel", diesel);
        rentalVehicles.put("semiTruck", semiTruck);
        rentalVehicles.put("yacht", yacht);
        rentalVehicles.put("speed", speed);
        rentalVehicles.put("barge", barge);
        rentalVehicles.put("cargo", cargo);

        System.out.println(rentalVehicles.get("standard"));
        System.out.println(rentalVehicles.get("electric"));
        System.out.println(rentalVehicles.get("diesel"));
        System.out.println(rentalVehicles.get("semiTruck"));
        System.out.println(rentalVehicles.get("yacht"));
        System.out.println(rentalVehicles.get("speed"));
        System.out.println(rentalVehicles.get("barge"));
        System.out.println(rentalVehicles.get("cargo"));
    }
}