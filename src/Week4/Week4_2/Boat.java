package Week4.Week4_2;

public class Boat extends Vehicle {
    private BoatType boatType;

    public Boat(BoatType boatType) {
        this.boatType = boatType;
    }

    public Boat(double range, int vin, int vehicleCode, double basePrice, BoatType boatType) {
        super(range, vin, vehicleCode, basePrice);
        this.boatType = boatType;
        super.setLuxuryTax(boatType.getLuxuryTax());
        this.calculateRange();
    }

    public void calculateRange() {
        this.setRange(Math.max(1, this.getRange()) * 7);
    }

    @Override
    public String toString() {
        String formattedBoatType = boatType.toString().substring(0,1) + boatType.toString().substring(1).toLowerCase();
        return formattedBoatType + " with VIN " + super.getVin() + " is available to rent. This beauty has a range of " + this.getRange() + " and only costs $" + this.calculateCost();
    }
}
