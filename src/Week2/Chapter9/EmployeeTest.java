package Week2.Chapter9;

public class EmployeeTest {
    public static void main(String[] args){
        Employee brian = new HourlyEmployee("Brian", "Hoyer", "12352034", 100, 12);
        System.out.println(brian.toString());
    }
}
