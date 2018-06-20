package com.company;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int length = 5;
        String palindrome;

        do{
            System.out.println("Enter a number that is five characters long: ");
        }while((palindrome = input.next()).length() != length);

        if(isPalindrome(Integer.parseInt(palindrome))){
            System.out.println("Is a palindrome");
        }
        else{
            System.out.println("Not a palindrome");
        }

    }

    public static boolean isPalindrome(int number){
        if(number == reverseNumber(number)){
            return true;
        }
        else{
            return false;
        }
    }

    public static int reverseNumber(int number){
        int reverse = 0, tempDigit;
        while(number > 0){
            tempDigit = number%10;
            reverse = reverse *10 + tempDigit;
            number /= 10;
        }
        return reverse;
    }
}
