package Week4.Employees;

public class SalariedEmployee extends Employee implements Insurable {
    double salary;

    @Override
    public double pay() {
        return salary;
    }

    public void payLifePremium() {
        //can buy up to 250,000
    }
}
