package Week4;

public class Boxes extends Parcel{
    private double height;
    private double width;
    private double depth;

    public Boxes(String id, String origin, String destination, String address, DeliveryMethod deliveryMethod, double height, double width, double depth) {
        super(id, origin, destination, address, deliveryMethod);
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
}
