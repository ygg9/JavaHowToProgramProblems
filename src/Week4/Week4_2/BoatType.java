package Week4.Week4_2;

public enum BoatType {
    BARGE(5000), //input different luxury taxes here
    CARGO(8500),
    SPEED(2200),
    YACHT(60000);

    public double getLuxuryTax() {
        return luxuryTax;
    }

    public void setLuxuryTax(double luxuryTax) {
        this.luxuryTax = luxuryTax;
    }

    private double luxuryTax;

    BoatType() {

    }

    BoatType(double luxuryTax) {
        this.luxuryTax = luxuryTax;
    }
}