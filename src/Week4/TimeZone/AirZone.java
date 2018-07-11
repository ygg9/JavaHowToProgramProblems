package Week4.TimeZone;

import Week4.Address;

public class AirZone implements TimeZoneBehaviour {
    public double daysToDeliver(Address origin, Address destination){
        int fromDigit = origin.getPostalCode().charAt(0);
        int toDigit = destination.getPostalCode().charAt(0);

        return .25 * Math.abs(fromDigit - toDigit);
    }
}
