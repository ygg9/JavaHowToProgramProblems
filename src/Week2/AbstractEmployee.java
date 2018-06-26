package Week2;

public abstract class AbstractEmployee {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    // constructor
    public AbstractEmployee(String firstName, String lastName, String socialSecurityNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    // return first name
    public String getFirstName(){
        return firstName;
    }

    // return last name
    public String getLastName(){
        return lastName;
    }

    // return social security number
    public String getSocialSecurityNumber(){
        return socialSecurityNumber;
    }

    // return String representation of Employee object
    @Override
    public String toString(){
        return String.format("%s %s%nsocial security number: %s", getFirstName(), getLastName(), getSocialSecurityNumber());
    }

    // abstract method must be overridden by concrete subclasses
    public abstract  double earnings(); // no implementation
    // end abstract class Employee
}
