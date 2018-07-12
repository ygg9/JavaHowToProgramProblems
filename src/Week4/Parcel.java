package Week4;

import Week4.TimeZone.AirZone;
import Week4.TimeZone.GroundZone;
import Week4.TimeZone.RailZone;
import Week4.TimeZone.TimeZoneBehaviour;
import com.thirdParty.calibration.MailScale;

public abstract class Parcel implements Scale{
    public abstract double getVolume();

    private String id;
    private Address origin;
    private Address destination;
    private DeliveryMethod deliveryMethod;
    private TimeZoneBehaviour timeZoneBehaviour;
    private MailScale scale = new MailScale();
    private double weight;
    private String deliveryStatus = "Not delivered";
    private DeliveryInformation deliveryInformation;

    public Parcel(String id, Address origin, Address destination, DeliveryMethod deliveryMethod) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
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
        return origin;
    }

    public Address getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOrigin(Address origin) {
        this.origin = origin;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public TimeZoneBehaviour getTimeZoneBehaviour() {
        return timeZoneBehaviour;
    }

    public void setTimeZoneBehaviour(TimeZoneBehaviour timeZoneBehaviour) {
        this.timeZoneBehaviour = timeZoneBehaviour;
    }

    public MailScale getScale() {
        return scale;
    }

    public void setScale(MailScale scale) {
        this.scale = scale;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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

    public DeliveryInformation createDeliveryInformation(){
        deliveryInformation = new DeliveryInformation();
        deliveryInformation.setDeliveryStatus(this.deliveryStatus);
        deliveryInformation.setOriginZip(this.origin.getPostalCode());
        deliveryInformation.setDestinationZip(this.destination.getPostalCode());
        deliveryInformation.setParcelType(this.getClass().toString());
        deliveryInformation.setDeliveryMethod(this.getDeliveryMethod().toString());
        deliveryInformation.setWeight(Double.toString(this.weight));
        deliveryInformation.setDeliveryTime(Double.toString(this.daysToDeliver()));
        deliveryInformation.setShippingCost(Double.toString(this.shippingCost()));
        return deliveryInformation;
    }
}
