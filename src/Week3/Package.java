package Week3;

public class Package implements Comparable<Package> {
    public Package() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGRD() {
        return GRD;
    }

    public void setGRD(String GRD) {
        this.GRD = GRD;
    }

    public int getFromZip() {
        return fromZip;
    }

    public void setFromZip(int fromZip) {
        this.fromZip = fromZip;
    }

    public int getToZip() {
        return toZip;
    }

    public void setToZip(int toZip) {
        this.toZip = toZip;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getStreet() {
        return street;
    }

    private int id;
    private String GRD;
    private int fromZip;
    private int toZip;
    private double weight;
    private int height;
    private int width;
    private int depth;
    private String street;

    Package(int id, String grd, int fromZip, int toZip, double weight, int height, int width, int depth, String street) {
        this.id = id;
        this.GRD = grd;
        this.fromZip = fromZip;
        this.toZip = toZip;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.street = street;
    }

    @Override
    public int compareTo(Package o) {
        if (this.id < o.getId()) {
            return -1;
        }
        if (this.id == o.getId()) {
            return 0;
        }
        return 1;
    }
}
