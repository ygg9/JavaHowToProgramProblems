package Week2.Chapter10;

public class SalariedEmployee extends AbstractEmployee {
    private double weeklySalary;

    // contructor
    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary, Date birthday) {
        super(firstName, lastName, socialSecurityNumber, birthday);

        if (weeklySalary < 0.0) {
            throw new IllegalArgumentException("Weekly salary must be >= 0.0:");
        }

        this.weeklySalary = weeklySalary;
    }

    // set salary
    public void setWeeklySalary(double weeklySalary) {
        if (weeklySalary < 0.0) {
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");
        }

        this.weeklySalary = weeklySalary;
    }

    // return salary
    public double getWeeklySalary() {
        return weeklySalary;
    }

    // calculate earnings; override abstract method earnings in Employee
    @Override
    public double earnings() {
        return getWeeklySalary();
    }

    // return String representation of SalariedEmployee object
    @Override
    public String toString() {
        return String.format("salaried employee: %s%n%s: $%,.2f", super.toString(), "weekly salary", getWeeklySalary());
    }
}
