package Week4.TimeZone;

import com.jits.core.Address;
import Week4.Parcel;

public class AirZone implements TimeZoneBehaviour {
    private final double COST_FACTOR = 1.75;
    private final double ZONE_FACTOR = .25;

    @Override
    public double daysToDeliver(Parcel parcel){
        return ZONE_FACTOR * zoneDifference(parcel);
    }

    @Override
    public double shippingCost(Parcel parcel){
        double weight = parcel.getWeight();
        weight = weight > 0 ? weight : 1;
        double volume = parcel.getVolume();
        volume = volume > 0 ? volume : 1;

        return zoneDifference(parcel) * weight * volume * COST_FACTOR;
    }

    public int zoneDifference(Parcel parcel){
        Address origin = parcel.getOrigin();
        Address destination = parcel.getDest();

        int fromDigit = origin.getPostalCode().charAt(0);
        int toDigit = destination.getPostalCode().charAt(0);

        return Math.abs(fromDigit - toDigit);
    }
}
