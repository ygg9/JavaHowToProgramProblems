package Week2.Chapter10;

public abstract class AbstractEmployee {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    public Date getBirthday() {
        return birthday;
    }

    private final Date birthday;

    // constructor
    public AbstractEmployee(String firstName, String lastName, String socialSecurityNumber, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.birthday = birthday;
    }

    // return first name
    public String getFirstName() {
        return firstName;
    }

    // return last name
    public String getLastName() {
        return lastName;
    }

    // return social security number
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    // return String representation of Employee object
    @Override
    public String toString() {
        return String.format("%s %s%nsocial security number: %s", getFirstName(), getLastName(), getSocialSecurityNumber());
    }

    // abstract method must be overridden by concrete subclasses
    public abstract double earnings(); // no implementation
    // end abstract class Employee
}
