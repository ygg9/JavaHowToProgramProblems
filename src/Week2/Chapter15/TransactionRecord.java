package Week2.Chapter15;

import java.io.Serializable;

public class TransactionRecord implements Serializable {
    public TransactionRecord(int accountNumber, double amount){
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    private int accountNumber;
    private double amount;


}
