package com.company;

import java.util.Scanner;

public class Chapter2 {

    public static void main(String[] args) {
        chapter2_14();
        chapter2_15();
        chapter2_17();
        chapter2_28();
        chapter2_34();
    }

    static void chapter2_14(){
        System.out.println("1 2 3 4");
        System.out.print("1 ");
        System.out.print("2 ");
        System.out.print("3 ");
        System.out.print("4 \n");
        System.out.printf("1 2 3 4\n");
    }

    static void chapter2_15(){ // Ints or floats?
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int firstNumber = input.nextInt();
        int secondNumber = input.nextInt();
        System.out.printf("Sum: %d\n", (firstNumber + secondNumber));
        System.out.printf("Product: %d\n", (firstNumber * secondNumber));
        System.out.printf("Difference: %d\n", (firstNumber - secondNumber));
        System.out.printf("Quotient: %d\n", (firstNumber / secondNumber));
    }

    static void chapter2_17(){
        Scanner inputArithmetic = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int firstNumber = inputArithmetic.nextInt();
        int secondNumber = inputArithmetic.nextInt();
        int thirdNumber = inputArithmetic.nextInt();
        System.out.printf("Sum: %d\n", (firstNumber + secondNumber + thirdNumber));
        System.out.printf("Average: %d\n", (firstNumber + secondNumber + thirdNumber)/3);
        System.out.printf("Product: %d\n", (firstNumber * secondNumber * thirdNumber));
        int smallest = firstNumber, largest = firstNumber;
        if(secondNumber < smallest){
            smallest = secondNumber;
        }
        if(thirdNumber < smallest){
            smallest = thirdNumber;
        }
        if(secondNumber > largest){
            largest = secondNumber;
        }
        if(thirdNumber > largest){
            largest = thirdNumber;
        }
        System.out.printf("Smallest: %d\n", smallest);
        System.out.printf("Largest: %d\n", largest);
    }

    static void chapter2_28(){
        Scanner inputCircle = new Scanner(System.in);
        System.out.print("Enter a radius: ");
        int radius = inputCircle.nextInt();
        System.out.printf("Diameter: %d\n", (2 * radius));
        System.out.printf("Circumference: %f\n", (2 * Math.PI * radius));
        System.out.printf("Area: %f\n", (Math.PI * radius * radius));
    }

    static void chapter2_34(){
        Scanner inputPopulation = new Scanner(System.in);
        System.out.print("Enter the world population: ");
        long population = inputPopulation.nextLong();
        System.out.print("Enter the world population growth rate per year as a percentage: ");
        float populationGrowth = inputPopulation.nextFloat()/100;
        System.out.printf("Estimated population in one year: %f\n", population * Math.exp(populationGrowth * 1));
        System.out.printf("Estimated population in two years: %f\n", population * Math.exp(populationGrowth * 2));
        System.out.printf("Estimated population in three years: %f\n", population * Math.exp(populationGrowth * 3));
        System.out.printf("Estimated population in four years: %f\n", population * Math.exp(populationGrowth * 4));
        System.out.printf("Estimated population in five years: %f\n", population * Math.exp(populationGrowth * 5));
    }
}
