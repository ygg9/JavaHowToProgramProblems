package Week5.Chapter20;

public class GenericIsEqual {
    public static void main(String[] args){
        Integer i1 = new Integer(0);
        i1 += 1;
        i1 -= 1;
        Integer i2 = new Integer( 0);
        System.out.printf("Comparing %d and %d: %s%n", i1, i2, isEqualTo(i1, i2)? "true": "false");

        Object o1 = new Object();
        Object o2 = new Object();
        System.out.printf("Comparing %s and %s: %s%n", o1, o2, isEqualTo(o1, o2)? "true": "false");

        Double d1 = new Double(2.0);
        d1 += .11;
        d1 -= .11;
        Double d2 = new Double(2.0);
        System.out.printf("Comparing %f and %f: %s%n", d1, d2, isEqualTo(d1, d2)? "true": "false");
    }

    public static <T> boolean isEqualTo(T firstObject, T secondObject){
        return firstObject.equals(secondObject);
    }
}
