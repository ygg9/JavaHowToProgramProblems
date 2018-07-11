package Week4;

import Week4.TimeZone.AirZone;
import Week4.TimeZone.GroundZone;
import Week4.TimeZone.RailZone;
import Week4.TimeZone.TimeZoneBehaviour;
import com.thirdParty.calibration.MailScale;

public abstract class Parcel implements Scale{
    public abstract double getVolume();

    private String Id;
    private Address Origin;
    private Address Destination;
    private DeliveryMethod deliveryMethod;
    private TimeZoneBehaviour timeZoneBehaviour;
    private MailScale scale = new MailScale();
    private double weight;
    private String deliveryStatus = "Not delivered";

    public Parcel(String id, Address origin, Address destination, DeliveryMethod deliveryMethod) {
        Id = id;
        Origin = origin;
        Destination = destination;
        this.deliveryMethod = deliveryMethod;

        if(deliveryMethod.equals(DeliveryMethod.AIR)){
            timeZoneBehaviour = new AirZone();
        }
        else if (deliveryMethod.equals(DeliveryMethod.GROUND)){
            timeZoneBehaviour = new GroundZone();
        }
        else if (deliveryMethod.equals(DeliveryMethod.RAIL)){
            timeZoneBehaviour = new RailZone();
        }
    }

    public double daysToDeliver(){
        return timeZoneBehaviour.daysToDeliver(this);
    }

    public double shippingCost(){
        return timeZoneBehaviour.shippingCost(this);
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }


    public Address getOrigin() {
        return Origin;
    }

    public Address getDestination() {
        return Destination;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public double weighParcel(){
        return scale.calculateWeight(this);
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
