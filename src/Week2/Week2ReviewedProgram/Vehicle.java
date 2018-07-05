package Week2.Week2ReviewedProgram;

public abstract class Vehicle {
    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void setLuxuryTax(double luxuryTax) {
        this.luxuryTax = luxuryTax;
    }

    public int getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(int vehicleCode) {
        this.vehicleCode = vehicleCode;
    }

    private double range;
    private int vin;
    private double basePrice;
    private int vehicleCode;
    private double luxuryTax = 0;

    public double calculateCost() {
        return ((this.basePrice * ((double) this.vin / this.vehicleCode)) / this.range) + this.luxuryTax;
    }

    Vehicle() {
        range = 0;
        vin = 0;
        basePrice = 0;
    }

    Vehicle(double range, int vin, int vehicleCode, double basePrice) {
        super();
        this.range = range;
        this.vin = vin;
        this.vehicleCode = vehicleCode;
        this.basePrice = basePrice;
    }

    @Override
    public abstract String toString();

    public abstract void calculateRange();
}
