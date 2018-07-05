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

public class CreateMast {
    private static ObjectOutputStream output;
    private static Formatter oldMaster;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("1 for serialized, 2 for text");

        if (input.nextInt() == 1) {
            openOldMastFileSerialized();
            addOldMastFileRecordsSerialized();
            closeOldMastFileSerialized();
        } else {
            openOldMastFile();
            addOldMastRecords();
            closeOldMastFile();
        }
    }

    public static void closeOldMastFileSerialized() {
        try {
            if (output != null) {
                output.close();
            }
        } catch (IOException ioException) {
            System.err.println("Error closing file. Terminating");
        }
    }

    public static void openOldMastFileSerialized() {
        try {
            output = new ObjectOutputStream(Files.newOutputStream(Paths.get("oldmast.ser")));
        } catch (IOException ioException) {
            System.err.println("Error opening file. Terminating");
            System.exit(1);
        }
    }

    public static void addOldMastFileRecordsSerialized() {
        System.out.printf("%s%n%s%n: ", "Enter account number, first name, last name, and balance.", "Enter end-of-file indicator to end input.");

        while (input.hasNext()) {
            try {
                Account account = new Account(input.nextInt(), input.next(), input.next(), input.nextDouble());
                output.writeObject(account);
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

    public static void addOldMastRecords() {
        System.out.printf("%s%n%s%n: ", "Enter account number, first name, last name, and balance.", "Enter end-of-file indicator to end input.");

        while (input.hasNext()) {
            try {
                oldMaster.format("%d %s %s %.2f%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
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

    public static void openOldMastFile() {
        try {
            oldMaster = new Formatter("oldmast.txt");
        } catch (SecurityException securityException) {
            System.err.println("Write permission denied: Terminating");
            System.exit(1);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening oldmast.txt. Terminating");
        }
    }

    public static void closeOldMastFile() {
        if (oldMaster != null) {
            oldMaster.close();
        }
    }
}