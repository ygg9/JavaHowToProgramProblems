package Week2;

public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public double getSavingsBalance() {
        return savingsBalance;
    }

    SavingsAccount(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest(){
        savingsBalance += savingsBalance * (annualInterestRate / 12);
    }

    public static void modifyInterestRate(double rate){
        annualInterestRate = rate;
    }

}
