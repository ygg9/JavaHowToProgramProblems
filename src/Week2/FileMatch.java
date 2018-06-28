package Week2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.SecurityException;
import java.nio.file.Paths;
import java.util.*;

public class FileMatch {
    private static Formatter output;
    private static Formatter log;
    private static Scanner inOldMaster;
    private static Scanner inTransaction;
    private static ArrayList<Account> accountArrayList = new ArrayList<Account>();
    private static ArrayList<TransactionRecord> transactionRecordArrayList = new ArrayList<TransactionRecord>();

    public static void main(String[] args){
        openOldMastFile();
        readOldMastFile();
        closeOldMastFile();

        openTransactionFile();
        readTransactionFile();
        closeTransactionFile();

        openNewMastFile();
        writeNewMastFile();
        closeNewMastFile();

        openLogFile();
        writeLogFile();
        closeLogFile();
    }

    public static void writeLogFile(){
        for(TransactionRecord transaction: transactionRecordArrayList){
            try{
                log.format("%s %d%n", "Unmatched transaction record for account number: ", transaction.getAccountNumber());
            } catch (FormatterClosedException formatterClosedException){
                System.err.println("Error writing to file. Terminating");
            }
        }
    }

    public static void openLogFile(){
        try{
            log = new Formatter("log.txt");
        } catch (SecurityException securityException){
            System.err.println("Write permission denied: Terminating.");
            System.exit(1);
        } catch (FileNotFoundException fileNotFoundException){
            System.err.println("Error opening log.txt file. Terminating");
            System.exit(1);
        }
    }

    public static void closeLogFile(){
        if (log != null){
            log.close();
        }
    }

    public static void readTransactionFile(){
        try{
            while(inTransaction.hasNext()){
                int accountNumber = inTransaction.nextInt();
                double amount = inTransaction.nextDouble();

                transactionRecordArrayList.add(new TransactionRecord(accountNumber, amount));
            }
        } catch (NoSuchElementException | IllegalStateException e){
            System.out.println("Error processing file. Terminating");
            System.exit(1);
        }
    }

    public static void openTransactionFile(){
        try{
            inTransaction = new Scanner(Paths.get("trans.txt"));
        } catch (IOException ioException){
            System.err.println("Error opening trans.txt file. Terminating");
        }
    }

    public static void closeTransactionFile(){
        if(inTransaction != null){
            inTransaction.close();
        }
    }

    public static void readOldMastFile(){
        try{
            while(inOldMaster.hasNext()){
                int account = inOldMaster.nextInt();
                String firstName = inOldMaster.next();
                String lastName = inOldMaster.next();
                double balance = inOldMaster.nextDouble();

                accountArrayList.add(new Account(account, firstName, lastName, balance));
            }
        } catch (NoSuchElementException | IllegalStateException e){
            System.out.println("Error processing file. Terminating");
            System.exit(1);
        }
    }

    public static void openOldMastFile(){
        try{
            inOldMaster = new Scanner(Paths.get("oldmast.txt"));
        } catch (IOException ioException){
            System.err.println("Error opening oldmast.txt file. Terminating");
        }
    }

    public static void closeOldMastFile(){
        if(inOldMaster != null){
            inOldMaster.close();
        }
    }

    public static void writeNewMastFile(){
        List<TransactionRecord> found = new ArrayList<TransactionRecord>();
        for (Account account: accountArrayList){
            for(TransactionRecord transaction: transactionRecordArrayList){
                if(account.getAccount() == transaction.getAccountNumber()){
                    account.combine(transaction);
                    found.add(transaction);
                }
            }
            try{
                output.format("%d %s %s %.2f%n", account.getAccount(), account.getFirstName(), account.getLastName(), account.getBalance());
            } catch (FormatterClosedException formatterClosedException){
                System.err.println("Error writing to file. Terminating");
            }
        }
        transactionRecordArrayList.removeAll(found);
    }

    public static void openNewMastFile(){
        try{
            output = new Formatter("newmast.txt");
        } catch (SecurityException securityException){
            System.err.println("Write permission denied: Terminating.");
            System.exit(1);
        } catch (FileNotFoundException fileNotFoundException){
            System.err.println("Error opening newmast.txt file. Terminating");
            System.exit(1);
        }
    }

    public static void closeNewMastFile(){
        if (output != null){
            output.close();
        }
    }
}
