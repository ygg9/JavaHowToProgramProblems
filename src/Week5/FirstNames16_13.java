package Week5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FirstNames16_13 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String[] names = {"James", "Matt", "Pinky", "Charles", "Aaron", "Charles"};
        Set<String> firstNames = new HashSet(Arrays.asList(names));

        System.out.println("Enter a name to search for: ");

        String userName = input.nextLine();

        if(firstNames.contains(userName)){
            System.out.println("Contains: " + userName);
        }else{
            System.out.println("Does not contain " + userName);
        }
    }
}
