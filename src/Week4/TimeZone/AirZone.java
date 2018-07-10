package Week4.TimeZone;

import Week4.Address;

public class AirZone implements TimeZoneBehaviour {
    public int daysToDeliver(Address origin, Address destination){
        int fromDigit = origin.getPostalCode().charAt(0);
        int toDigit = destination.getPostalCode().charAt(0);

        return Math.abs(fromDigit - toDigit);
    }
}
