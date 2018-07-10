package Week4;

public class Boxes extends Parcel{
    private double height;
    private double width;
    private double depth;

    public Boxes(String id, Address origin, Address destination, DeliveryMethod deliveryMethod, double height, double width, double depth) {
        super(id, origin, destination, deliveryMethod);
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
