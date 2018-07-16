package Week4.XmlManager;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "DeliveryInformation")
@XmlType(propOrder = {"id", "deliveryStatus", "originZip", "destinationZip", "parcelType", "deliveryMethod", "weight", "deliveryTime", "shippingCost", "hasInsurance"})
public class DeliveryInformation implements Comparable<DeliveryInformation>{
    private String id;
    private String deliveryStatus;
    private String originZip;
    private String destinationZip;
    private String parcelType;
    private String deliveryMethod;
    private String weight;
    private String deliveryTime;
    private String shippingCost;
    private String hasInsurance;

    public String getId() {
        return id;
    }

    @XmlElement
    public void setId(String id) {
        this.id = id;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    @XmlElement
    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getOriginZip() {
        return originZip;
    }

    @XmlElement
    public void setOriginZip(String originZip) {
        this.originZip = originZip;
    }

    public String getDestinationZip() {
        return destinationZip;
    }

    @XmlElement
    public void setDestinationZip(String destinationZip) {
        this.destinationZip = destinationZip;
    }

    public String getParcelType() {
        return parcelType;
    }

    @XmlElement
    public void setParcelType(String parcelType) {
        this.parcelType = parcelType;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    @XmlElement
    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getWeight() {
        return weight;
    }

    @XmlElement
    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    @XmlElement
    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getShippingCost() {
        return shippingCost;
    }

    @XmlElement
    public void setShippingCost(String shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getHasInsurance() {
        return hasInsurance;
    }

    @XmlElement
    public void setHasInsurance(String hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    @Override
    public int compareTo(DeliveryInformation d){
        Double thisCost = Double.parseDouble(this.shippingCost);
        Double dCost = Double.parseDouble(d.getShippingCost());
        if(thisCost < dCost){
            return -1;
        }
        if(thisCost == dCost){
            return 0;
        }
        return 1;
    }
}
