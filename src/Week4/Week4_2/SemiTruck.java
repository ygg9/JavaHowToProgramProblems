package Week4.Week4_2;

import org.w3c.dom.ranges.RangeException;

public class SemiTruck extends Diesel implements Limitable {
    boolean specialLicense;

    public SemiTruck(Date emissionTest, int seats, String color, double range, int vin, int vehicleCode, double basePrice, String MANUFACTURER_NAME, int wheels, int cylinders, boolean specialLicense, double luxuryTax) {
        super(emissionTest, seats, color, range, vin, vehicleCode, basePrice, MANUFACTURER_NAME, wheels, cylinders, luxuryTax);
        this.specialLicense = specialLicense;
    }

    public void checkRange(double range) throws RangeException{
        if (range > 50 && range < 499) {
            this.setRange(range);
        } else {
            throw new RangeException((short) 1, "Range is not between 50 and 499");
        }
    }
}
