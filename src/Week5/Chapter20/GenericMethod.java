package Week5.Chapter20;

public class GenericMethod {
    public static void main(String[] args){
        Integer[] intArray = {1,2,3,4,5};
        Double[] doubleArray = {1.1,2.2,3.3,4.4,5.5,6.6,7.7};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

        System.out.printf("Array integerArray contains: %n");
        printArray(intArray);
        System.out.printf("%nArray doubleArray contains: %n");
        printArray(doubleArray);
        System.out.printf("%nArray characterArray contains:%n");
        printArray(charArray);

        try{
            System.out.printf("%nArray integerArray index 1 to 3 contains: %n");
            printArray(intArray, 1,3);
            System.out.printf("%nArray doubleArray index 3 to 4 contains: %n");
            printArray(doubleArray, 3, 4);
            System.out.printf("%nArray characterArray index 2 to 5 contains: %n");
            printArray(charArray, 2,5);
        } catch(InvalidSubscriptException e){
            System.out.print(e);
        }

        String[] stringArray = {"one", "two", "three", "four", "five", "six", "seven", "eight"};

        System.out.printf("%nArray stringArray contains: %n");
        printArray(stringArray);
    }

    public static <T> void printArray(T[] inputArray){
        for(T element: inputArray) {
            System.out.printf("%s ", element);
        }

        System.out.println();
    }

    public static <T> void printArray(T[] inputArray, int lowSubscript, int highSubscript) throws InvalidSubscriptException{
        if(lowSubscript > 0 && highSubscript < inputArray.length){
            for(int i = lowSubscript; i <= highSubscript; i++){
                System.out.printf("%s ", inputArray[i]);
            }

            System.out.println();
        }
        else{
            throw new InvalidSubscriptException("Subscript out of bounds\n");
        }
    }

    public static void printArray(String[] inputArray){
        for(int i = 0; i < inputArray.length; i++){
            System.out.printf("%-10s", inputArray[i]);
            if((i+1)%4 == 0 ){
                System.out.println();
            }
        }
    }
}
