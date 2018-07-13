package Week4.TimeZone;

import com.jits.core.Address;
import Week4.Parcel;
import org.w3c.dom.ranges.RangeException;

// no information except cheaper and slower than ground zone
public class RailZone implements TimeZoneBehaviour {
    private final double ZONE_FACTOR = 2.0;
    private final double COST_FACTOR = .7;
    // discount?

    @Override
    public double daysToDeliver(Parcel parcel) {

        return ZONE_FACTOR * zoneDifference(parcel);
    }

    @Override
    public double shippingCost(Parcel parcel) {
        double weight = parcel.getWeight();
        weight = weight > 0 ? weight : 1;
        double volume = parcel.getVolume();
        volume = volume > 0 ? volume : 1;

        return zoneDifference(parcel) * weight * volume * COST_FACTOR;
    }

    public int zoneDifference(Parcel parcel){
        Address origin = parcel.getOrigin();
        Address destination = parcel.getDest();

        int fromDigit = Character.getNumericValue(origin.getPostalCode().charAt(0));
        int toDigit = Character.getNumericValue(destination.getPostalCode().charAt(0));

        // east = 0, west = 1
        int fromTZ = getTimeZone(fromDigit);
        int toTZ = getTimeZone(toDigit);

        return Math.abs(fromTZ - toTZ);
    }

    public int getTimeZone(int digit) throws RangeException {
        if(digit >= 0 && digit <= 4){
            return 0;
        }
        else if(digit >= 5 && digit <= 9){
            return 1;
        }
        else{
            throw new RangeException((short)1, "not a valid digit");
        }
    }
}
