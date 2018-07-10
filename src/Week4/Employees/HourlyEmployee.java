package Week4.Employees;

public class HourlyEmployee extends Employee implements Insurable {
    private double rate;
    private double hours;

    @Override
    public double pay(){
        return rate * hours;
    }

    public void payLifePremium() {
        //can buy up to 100,000 coverage
    }
}
