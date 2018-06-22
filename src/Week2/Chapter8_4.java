package Week2;

import java.util.Scanner;

public class Chapter8_4 {
    public static void main(String[] args){
        testRectangle();
    }

    public static void testRectangle(){
        Scanner input = new Scanner(System.in);
        Rectangle rect = new Rectangle();
        System.out.println("Enter a width: ");
        double width = input.nextDouble();
        try{
            rect.setWidth(width);
        }
        catch(OutOfRange e){

        }
        System.out.println("Enter a height: ");
        double height = input.nextDouble();
        try{
            rect.setHeight(height);
        }
        catch(OutOfRange e){

        }
    }
}