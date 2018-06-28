package Week2.Chapter10;

public class PayrollSystemTest {
    public static void main(String[] args){
        SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00, new Date(12, 4, 1992));
        AbstractHourlyEmployee hourlyEmployee = new AbstractHourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40, new Date(6, 10, 1985));
        CommissionEmployee commissionEmployee = new CommissionEmployee("Sue","Jones", "333-33-3333", 10000, .06, new Date(4, 6, 1970));
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300, new Date(11, 23, 2001));
        AbstractPieceWorker abstractPieceWorker = new AbstractPieceWorker("Joe", "Prince", "555-55-5555", 1000, 12, new Date(4, 15, 2005));

        System.out.println("Employees processed individually:");

        System.out.printf("%n%s%n%s: $%,.2f%n%n", salariedEmployee, "earned", salariedEmployee.earnings());

        System.out.printf("%s%n%s: $%,.2f%n%n", hourlyEmployee, "earned", hourlyEmployee.earnings());

        System.out.printf("%s%n%s: $%,.2f%n%n", commissionEmployee, "earned", commissionEmployee.earnings());

        System.out.printf("%s%n%s: $%,.2f%n%n", basePlusCommissionEmployee, "earned", basePlusCommissionEmployee.earnings());

        AbstractEmployee[] employees = new AbstractEmployee[5];

        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;
        employees[4] = abstractPieceWorker;

        System.out.printf("Employees processed polymorphically:%n%n");

        for(AbstractEmployee currentEmployee: employees){
            System.out.println(currentEmployee);

            if (currentEmployee instanceof BasePlusCommissionEmployee){
                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;

                employee.setBaseSalary(1.10 * employee.getBaseSalary());

                System.out.printf("new base salary with 10%% increase is $%,.2f%n", employee.getBaseSalary());
            }

            System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings());
        }

        for(int j= 0; j < employees.length; j++){
            System.out.printf("Employee %d is a %s%n", j, employees[j].getClass().getName());
        }

        Date today = new Date(6, 26, 2018);

        for(AbstractEmployee dateEmployee: employees){
            System.out.println(dateEmployee + "\n");

            if (dateEmployee.getBirthday().getMonth() == today.getMonth()){
                System.out.println("Birthday Bonus!");
                if (dateEmployee instanceof BasePlusCommissionEmployee){
                    BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) dateEmployee;

                    employee.setBaseSalary(1.10 * employee.getBaseSalary());

                    System.out.printf("new base salary with 10%% increase is $%,.2f%n", employee.getBaseSalary() + 100);
                }

                System.out.printf("earned $%,.2f%n%n", dateEmployee.earnings() + 100);
            }
        }

    }
}
