package Week4.TimeZone;

import com.jits.core.Address;
import Week4.Parcel;
import org.w3c.dom.ranges.RangeException;

public class GroundZone implements TimeZoneBehaviour {
    private final double ZONE_FACTOR = 1.5;
    private final double COST_FACTOR = 1.1;
    private final double DISCOUNT = .95;

    @Override
    public double daysToDeliver(Parcel parcel){
        return ZONE_FACTOR * zoneDifference(parcel);
    }

    @Override
    public double shippingCost(Parcel parcel){
        double weight = parcel.getWeight();
        weight = weight > 0 ? weight : 1;

        if(crossRocky(parcel)){
            return zoneDifference(parcel) * weight * COST_FACTOR;
        }
        else{
            return zoneDifference(parcel) * weight * COST_FACTOR * DISCOUNT;
        }
    }

    public boolean crossRocky(Parcel parcel){
        Address origin = parcel.getOrigin();
        Address destination = parcel.getDest();

        String fromZip = origin.getPostalCode();
        String toZip = destination.getPostalCode();

        int fromDigit = getFirstDigit(fromZip);
        int toDigit = getFirstDigit(toZip);

        int fromZone = getTimeZone(fromDigit);
        int toZone = getTimeZone(toDigit);

        if (fromZone == 3 || toZone == 3){
            if(fromZone == toZone){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }

    public int zoneDifference(Parcel parcel){
        Address origin = parcel.getOrigin();
        Address destination = parcel.getDest();

        String fromZip = origin.getPostalCode();
        String toZip = destination.getPostalCode();

        int fromDigit = getFirstDigit(fromZip);
        int toDigit = getFirstDigit(toZip);

        // ET = 0, CT = 1, MT = 2, PT = 3;
        int fromTZ = getTimeZone(fromDigit);
        int toTZ = getTimeZone(toDigit);

        return Math.abs(fromTZ - toTZ);
    }

    public int getFirstDigit(String zip){
        char first = zip.charAt(0);
        return Character.getNumericValue(first);
    }

    public int getTimeZone(int digit) throws RangeException {
        if(digit == 0 || digit == 1 || digit == 2){
            return 0;
        }
        else if (digit == 3 || digit == 4 || digit == 5){
            return 1;
        }
        else if (digit == 6 || digit == 7){
            return 2;
        }
        else if (digit == 8 || digit == 9){
            return 3;
        }
        else{
            throw new RangeException((short)1, "not a valid digit");
        }
    }
}
