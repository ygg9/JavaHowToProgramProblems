package Week4;

import Week4.TimeZone.AirZone;
import Week4.TimeZone.GroundZone;
import Week4.TimeZone.RailZone;
import Week4.TimeZone.TimeZoneBehaviour;
import Week4.XmlManager.DeliveryInformation;
import com.jits.audit.Audit;
import com.jits.core.Address;
import com.jits.transfer.IConfirmation;
import com.thirdParty.calibration.MailScale;

public abstract class Parcel implements Scale, IConfirmation {
    public abstract double getVolume();
    public abstract boolean isInsured();

    private String id;
    private Address origin;
    private Address dest;
    private DeliveryMethod deliveryMethod;
    private TimeZoneBehaviour timeZoneBehaviour;
    private MailScale scale = new MailScale();
    private double weight;
    private String status = "Not delivered";
    private DeliveryInformation deliveryInformation;
    private double cost;
    private double deliveryTime;
    private boolean insured;
    private String deliveryType;

    public Parcel(String id, Address origin, Address dest, DeliveryMethod deliveryMethod) {
        this.id = id;
        this.origin = origin;
        this.dest = dest;
        this.deliveryMethod = deliveryMethod;

        if(deliveryMethod.equals(DeliveryMethod.AIR)){
            timeZoneBehaviour = new AirZone();
            deliveryType = "AIR";
        }
        else if (deliveryMethod.equals(DeliveryMethod.GROUND)){
            timeZoneBehaviour = new GroundZone();
            deliveryType = "GROUND";
        }
        else if (deliveryMethod.equals(DeliveryMethod.RAIL)){
            timeZoneBehaviour = new RailZone();
            deliveryType = "RAIL";
        }
    }

    public void setDeliveryTime(double deliveryTime){
        this.deliveryTime = deliveryTime;
    }

    @Override
    public double getDeliveryTime(){
        return deliveryTime;
    }

    public double calculateDaysToDeliver(){
        return timeZoneBehaviour.daysToDeliver(this);
    }

    public double calculateShippingCost(){
        return timeZoneBehaviour.shippingCost(this);
    }

    @Override
    public double getCost(){
        return cost;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    @Override
    public Address getOrigin() {
        return origin;
    }

    @Override
    public Address getDest() {
        return dest;
    }

    @Override
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

    public void setDest(Address dest) {
        this.dest = dest;
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

    @Override
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    @Override
    public String getDeliveryType() {
        return deliveryType;
    }

    public final DeliveryInformation createDeliveryInformation(){
        deliveryInformation = new DeliveryInformation();
        deliveryInformation.setDeliveryStatus(this.getStatus());
        deliveryInformation.setOriginZip(this.getOrigin().getPostalCode());
        deliveryInformation.setDestinationZip(this.getDest().getPostalCode());
        deliveryInformation.setParcelType(this.getClass().toString());
        deliveryInformation.setDeliveryMethod(this.getDeliveryMethod().toString());
        deliveryInformation.setWeight(Double.toString(this.getWeight()));
        deliveryInformation.setDeliveryTime(Double.toString(this.getDeliveryTime()));
        deliveryInformation.setShippingCost(Double.toString(this.getCost()));
        deliveryInformation.setHasInsurance(Boolean.toString(this.insured));
        return deliveryInformation;
    }

    public final void prepareForDelivery(){
        double cost = this.calculateShippingCost();
        cost = (double)Math.round(cost * 100d)/100;
        this.setCost(cost);

        if(this.getClass().toString().contains("Box")){
            if(this.isInsured()){
                this.setInsured(this.isInsured()); // set insurance
            }
        }

        this.setDeliveryTime(this.calculateDaysToDeliver());
    }
}
