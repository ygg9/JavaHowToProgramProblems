package Week2.Week2ReviewedProgram;

import org.w3c.dom.ranges.RangeException;

public class SemiTruck extends Diesel implements Limitable {
    boolean specialLicense;

    SemiTruck(Date emissionTest, int seats, String color, double range, int vin, int vehicleCode, double basePrice, String MANUFACTURER_NAME, int wheels, int cylinders, boolean specialLicense, double luxuryTax){
        super(emissionTest, seats, color, range, vin, vehicleCode, basePrice, MANUFACTURER_NAME, wheels, cylinders, luxuryTax);
        this.specialLicense = specialLicense;
    }

    public void checkRange(double range){
        try{
            if(range > 50 && range <499){
                this.setRange(range);
            } else{
                throw new RangeException((short)1 ,"Range is not between 50 and 499");
            }
        } catch(RangeException rangeException){
            System.err.println(rangeException);
        }
    }
}
