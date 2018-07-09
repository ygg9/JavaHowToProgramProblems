package Week2.Week2ReviewedProgram;

public class Diesel extends Automobile {
    private int wheels;
    private int cylinders;

    Diesel(int wheels, int cylinders) {
        this.wheels = wheels;
        this.cylinders = cylinders;
    }

    Diesel(Date emissionTest, int seats, String color, double range, int vin, int vehicleCode, double basePrice, String MANUFACTURER_NAME, int wheels, int cylinders, double luxuryTax) {
        super(emissionTest, seats, range, vin, vehicleCode, basePrice, MANUFACTURER_NAME, color);
        super.setLuxuryTax(luxuryTax);
        this.wheels = wheels;
        this.cylinders = cylinders;
    }
}