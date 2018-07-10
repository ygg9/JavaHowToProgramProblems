package Week4;

public class Letter extends Parcel{

    Durability durability;

    public Letter(String id, String origin, String destination, String address, DeliveryMethod deliveryMethod, Durability durability) {
        super(id, origin, destination, address, deliveryMethod);
        this.durability = durability;
    }

    public Durability getDurability() {
        return durability;
    }

    public void setDurability(Durability durability) {
        this.durability = durability;
    }
}
