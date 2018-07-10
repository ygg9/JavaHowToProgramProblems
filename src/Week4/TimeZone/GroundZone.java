package Week4.TimeZone;

import Week4.Address;
import org.w3c.dom.ranges.RangeException;

public class GroundZone implements TimeZoneBehaviour {
    public int daysToDeliver(Address origin, Address destination){
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
