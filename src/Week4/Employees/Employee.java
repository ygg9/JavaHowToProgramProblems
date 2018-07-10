package Week4.Employees;

public abstract class Employee{
    private String id;
    private String firstName;
    private String lastName;
    PensionManager pensionManager;

    private void giveToCharity(){

    }

    public abstract double pay();
}
