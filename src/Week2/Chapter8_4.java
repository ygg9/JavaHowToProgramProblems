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
        catch(outOfRange e){

        }
        System.out.println("Enter a height: ");
        double height = input.nextDouble();
        try{
            rect.setHeight(height);
        }
        catch(outOfRange e){

        }
    }
}

class Rectangle{
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) throws outOfRange {
        if(width > 0.0 && width < 20.0){
            this.width = width;
        }
        else{
            throw new outOfRange("Width out of range. Must be between 0-20");
        }
    }

    public void setHeight(double height) throws outOfRange {
        if(height > 0.0 && height < 20.0){
            this.height = height;
        }
        else{
            throw new outOfRange("Height out of range. Must be between 0-20");
        }
    }

    double width, height;
    Rectangle(){
        width = 1;
        height = 1;
    }

}

class outOfRange extends Exception{
    outOfRange(String s){
        System.out.println(s);
    }
}