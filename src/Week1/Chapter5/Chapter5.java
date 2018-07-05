package Week1.Chapter5;

import java.util.Scanner;

public class Chapter5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double product1 = 2.98, product2 = 4.50, product3 = 9.98, product4 = 4.49, product5 = 6.87, totalRetail = 0;
        int productNumber, quantity, flag = 0;

        while (flag != -1) {
            System.out.print("Enter a product number: ");
            productNumber = input.nextInt();
            System.out.print("Enter the quanitity: ");
            quantity = input.nextInt();

            switch (productNumber) {
                case 1:
                    totalRetail += product1 * quantity;
                    break;
                case 2:
                    totalRetail += product2 * quantity;
                    break;
                case 3:
                    totalRetail += product3 * quantity;
                    break;
                case 4:
                    totalRetail += product4 * quantity;
                    break;
                case 5:
                    totalRetail += product5 * quantity;
                    break;
                case -1:
                    break;
                default:
                    System.out.println("Invalid product number");
            }

            if (productNumber == -1 || quantity == -1) {
                flag = -1;
            }
        }

        System.out.print("Total retail price: " + totalRetail);
    }
}
