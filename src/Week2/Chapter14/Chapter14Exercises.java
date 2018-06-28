package Week2.Chapter14;

import java.util.Scanner;

public class Chapter14Exercises {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String compare1 = input.nextLine();
        String compare2 = input.nextLine();

        int compare = compare1.compareTo(compare2);
        if(compare == 0){
            System.out.println("Equals");
        }
        else if(compare < 0){
            System.out.println("less than");
        }
        else{
            System.out.println("greatet than");
        }

        String reverse = input.nextLine();
        String[] tokens = reverse.split(" ");
        for(int i = tokens.length-1; i >= 0; i--){
            System.out.println(tokens[i]);
        }

        String upperLower = input.nextLine();
        System.out.println(upperLower.toUpperCase());
        System.out.println(upperLower.toLowerCase());
    }
}
