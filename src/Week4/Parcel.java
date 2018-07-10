package Week4;

public abstract class Parcel{
    private String Id;
    private String Origin;
    private String Destination;
    private String Address;
    private DeliveryMethod deliveryMethod;

    public Parcel(String id, String origin, String destination, String address, DeliveryMethod deliveryMethod) {
        Id = id;
        Origin = origin;
        Destination = destination;
        Address = address;
        this.deliveryMethod = deliveryMethod;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }


}
