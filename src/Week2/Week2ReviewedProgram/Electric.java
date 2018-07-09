package Week2.Week2ReviewedProgram;

import org.w3c.dom.ranges.RangeException;

public class Electric extends Automobile implements Limitable, Renewable {
    private int numOfBatteries;
    private boolean isTesla;

    public Electric(Date emissionTest, int seats, String color, double range, int vin, int vehicleCode, double basePrice, String MANUFACTURER_NAME, int numOfBatteries, boolean isTesla, double luxuryTax) {
        super(emissionTest, seats, range, vin, vehicleCode, basePrice, MANUFACTURER_NAME, color);
        this.numOfBatteries = numOfBatteries;
        this.isTesla = isTesla;
        super.setLuxuryTax(luxuryTax);
    }

    public void checkRange(double range) throws RangeException{
        if (range > 50 && range < 499) {
            this.setRange(range);
        } else {
            throw new RangeException((short)1, "Range is not between 50 and 499");
        }
    }

}
