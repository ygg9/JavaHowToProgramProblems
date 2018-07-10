package Week4;

import Week4.TimeZone.AirZone;
import Week4.TimeZone.GroundZone;
import Week4.TimeZone.TimeZoneBehaviour;

public abstract class Parcel{
    private String Id;
    private Address Origin;
    private Address Destination;
    private DeliveryMethod deliveryMethod;
    private TimeZoneBehaviour timeZoneBehaviour;

    public Parcel(String id, Address origin, Address destination, DeliveryMethod deliveryMethod) {
        Id = id;
        Origin = origin;
        Destination = destination;
        this.deliveryMethod = deliveryMethod;

        if(deliveryMethod.equals(DeliveryMethod.AIR)){
            timeZoneBehaviour = new AirZone();
        } else{
            timeZoneBehaviour = new GroundZone();
        }
    }
}
