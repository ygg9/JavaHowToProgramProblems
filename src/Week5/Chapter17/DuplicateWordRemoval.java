package Week5.Chapter17;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DuplicateWordRemoval {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String [] tokens = input.nextLine().split(" ");
        System.out.println("Enter some words: ");

        System.out.printf("Unique words in alphabetical order: %s%n",
                Arrays.stream(tokens)
                .map(String::toLowerCase)
                .distinct()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList()));

    }
}
