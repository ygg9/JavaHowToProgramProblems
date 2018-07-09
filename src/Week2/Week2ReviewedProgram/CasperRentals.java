package Week2.Week2ReviewedProgram;

import java.util.ArrayList;

public class CasperRentals {
    public static ArrayList<Vehicle> rentalVehicles = new ArrayList<Vehicle>();

    public static void main(String[] args) {
        Vehicle standard = new Automobile(new Date(11, 30, 1995), 4,40, 40, 12, 3000, "HONDA", "grey");
        Vehicle electric = new Electric(new Date(5, 4, 1999), 4, "red", 50, 102, 76, 15000, "TESLA", 4, true, 153);
        Vehicle diesel = new Diesel(new Date(3, 12, 2018), 2, "orange", 100, 101, 54, 8000, "FORD", 18, 5, 50);
        Vehicle semiTruck = new SemiTruck(new Date(10, 20, 2016), 5, "green", 300, 103, 66, 20000, "SUBARU", 3, 1, true, 3000);

        Vehicle yacht = new Boat(100, 100, 8047, 985000, BoatType.YACHT);
        Vehicle speed = new Boat(50, 123, 123, 35000, BoatType.SPEED);
        Vehicle barge = new Boat(200, 120, 893, 500000, BoatType.BARGE);
        Vehicle cargo = new Boat(300, 122, 542, 750000, BoatType.CARGO);

        rentalVehicles.add(standard);
        rentalVehicles.add(electric);
        rentalVehicles.add(diesel);
        rentalVehicles.add(semiTruck);
        rentalVehicles.add(yacht);
        rentalVehicles.add(speed);
        rentalVehicles.add(barge);
        rentalVehicles.add(cargo);

        for (Vehicle vehicle : rentalVehicles) {
            System.out.println(vehicle.toString());
        }

        System.out.println();
        System.out.print("The cost to rent 2 electric cars, a speed boat, yacht, semi truck, diesel, and standard vehicle is: $");
        System.out.print(electric.calculateCost() * 2 + speed.calculateCost() + yacht.calculateCost() + semiTruck.calculateCost() + diesel.calculateCost() + standard.calculateCost());

    }
}