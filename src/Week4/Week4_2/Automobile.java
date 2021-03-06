package Week4.Week4_2;

public class Automobile extends Vehicle { //this is the standard automobile
    private Date emissionTest;
    private int seats;
    private String color;
    private final String MANUFACTURER_NAME;

    public String getColor() {
        return color;
    }

    public Automobile() {
        emissionTest = new Date();
        MANUFACTURER_NAME = "NO MANUFACTURER NAME";
        color = "black";
    }

    public Automobile(Date emissionTest, int seats, double range, int vin, int vehicleCode, double basePrice, String MANUFACTURER_NAME) {
        super(range, vin, vehicleCode, basePrice);
        this.emissionTest = emissionTest;
        this.seats = seats;
        this.color = "black";
        this.MANUFACTURER_NAME = MANUFACTURER_NAME;
    }

    public Automobile(Date emissionTest, int seats, double range, int vin, int vehicleCode, double basePrice, String MANUFACTURER_NAME, String color) {
        super(range, vin, vehicleCode, basePrice);
        this.emissionTest = emissionTest;
        this.seats = seats;
        this.color = color;
        this.MANUFACTURER_NAME = MANUFACTURER_NAME;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " by " + this.MANUFACTURER_NAME + " with VIN " + getVin() + " is available to rent in " + this.color + ". This beast has a range of " + this.getRange() + " and only costs $" + super.calculateCost();
    }

    public void calculateRange() {
        if (this.getRange() > 0) {
            this.setRange(this.getRange());
        } else {
            this.setRange(1);
        }

    }

    public String getMANUFACTURER_NAME() {
        return MANUFACTURER_NAME;
    }
}
