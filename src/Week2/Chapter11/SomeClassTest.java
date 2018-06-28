package Week2.Chapter11;

public class SomeClassTest {
    public static void main(String[] args){
        try{
            SomeClass someClass = new SomeClass();
        } catch (Exception exception){
            System.out.println(exception);
        }
    }
}
