package Week2;

public class HourlyEmployee extends Employee {
    public double getHours() {
        return hours;
    }

    public double getWage() {
        return wage;
    }

    public void setHours(double hours) {
        if(hours >= 0 && hours <= 168){
            this.hours = hours;
        }
    }

    public void setWage(double wage) {
        if(wage >=0){
            this.wage = wage;
        }
    }

    double hours;
    double wage;

    HourlyEmployee(String firstName, String lastName, String SSN, double wage, double hours){
        super(firstName, lastName, SSN);
        this.hours = hours;
        this.wage = wage;
    }

    public double earnings(){
        if(hours > 40){
            double overtime = hours - 40;
            return 40 * wage + overtime * wage * 1.5;
        }
        else{
            return hours * wage;
        }
    }

    public String toString(){
        return super.firstName + " " + super.lastName + " " + super.SSN + " " + wage + " " + hours;
    }
}
