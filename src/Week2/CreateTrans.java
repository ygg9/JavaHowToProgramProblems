package Week2;

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTrans {
    private static Formatter transactions;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        openTransFile();
        addTransRecords();
        closeTransFile();
    }

    public static void openTransFile(){
        try{
            transactions = new Formatter("trans.txt");
        } catch (SecurityException securityException){
            System.err.println("Write permission denied: Terminating");
            System.exit(1);
        } catch (FileNotFoundException fileNotFoundException){
            System.err.println("Error opening oldmast.txt. Terminating");
        }
    }

    public static void closeTransFile(){
        if (transactions != null){
            transactions.close();
        }
    }

    public static void addTransRecords(){
        System.out.printf("%s%n%s%n: ", "Enter account number and Transaction Amount.", "Enter end-of-file indicator to end input.");

        while(input.hasNext()){
            try{
                transactions.format("%d %.2f%n", input.nextInt(), input.nextDouble());
            } catch (FormatterClosedException formatterClosedException){
                System.err.println("Error writing to file. Terminating");
                break;
            } catch (NoSuchElementException elementException){
                System.err.println("Invalid input. Please try again.");
                input.nextLine();
            }

            System.out.print(": ");
        }
    }
}
