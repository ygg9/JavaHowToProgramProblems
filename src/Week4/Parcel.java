package Week4;

public abstract class Parcel{
    private String Id;
    private Address Origin;
    private Address Destination;
    private DeliveryMethod deliveryMethod;

    public Parcel(String id, Address origin, Address destination, DeliveryMethod deliveryMethod) {
        Id = id;
        Origin = origin;
        Destination = destination;
        this.deliveryMethod = deliveryMethod;
    }
}
