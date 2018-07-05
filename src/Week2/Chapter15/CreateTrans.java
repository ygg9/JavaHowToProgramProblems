package Week2.Chapter15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.SecurityException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTrans {
    private static ObjectOutputStream output;
    private static Formatter transactions;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("1 for serialized, 2 for text");

        if (input.nextInt() == 1) {
            openTransFileSerialized();
            addTransRecordsSerialized();
            closeTransFileSerialized();
        } else {
            openTransFile();
            addTransRecords();
            closeTransFile();
        }
    }

    public static void closeTransFileSerialized() {
        try {
            if (output != null) {
                output.close();
            }
        } catch (IOException ioException) {
            System.err.println("Error closing file. Terminating");
        }
    }

    public static void openTransFileSerialized() {
        try {
            output = new ObjectOutputStream(Files.newOutputStream(Paths.get("trans.ser")));
        } catch (IOException ioException) {
            System.err.println("Error opening file. Terminating");
            System.exit(1);
        }
    }

    public static void addTransRecordsSerialized() {
        System.out.printf("%s%n%s%n: ", "Enter account number and Transaction Amount.", "Enter end-of-file indicator to end input.");

        while (input.hasNext()) {
            try {
                TransactionRecord transaction = new TransactionRecord(input.nextInt(), input.nextDouble());
                output.writeObject(transaction);
            } catch (NoSuchElementException elementException) {
                System.err.println("Invalid input. Please try again.");
                input.nextLine();
            } catch (IOException ioException) {
                System.err.println("Error writing to file. Terminating");
                break;
            }
            System.out.print(": ");
        }
    }


    public static void openTransFile() {
        try {
            transactions = new Formatter("trans.txt");
        } catch (SecurityException securityException) {
            System.err.println("Write permission denied: Terminating");
            System.exit(1);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening oldmast.txt. Terminating");
        }
    }

    public static void closeTransFile() {
        if (transactions != null) {
            transactions.close();
        }
    }

    public static void addTransRecords() {
        System.out.printf("%s%n%s%n: ", "Enter account number and Transaction Amount.", "Enter end-of-file indicator to end input.");

        while (input.hasNext()) {
            try {
                transactions.format("%d %.2f%n", input.nextInt(), input.nextDouble());
            } catch (FormatterClosedException formatterClosedException) {
                System.err.println("Error writing to file. Terminating");
                break;
            } catch (NoSuchElementException elementException) {
                System.err.println("Invalid input. Please try again.");
                input.nextLine();
            }

            System.out.print(": ");
        }
    }
}
