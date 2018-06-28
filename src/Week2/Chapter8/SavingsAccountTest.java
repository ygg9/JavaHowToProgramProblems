package Week2.Chapter8;

public class SavingsAccountTest {
    public static void main(String[] args){
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);
        SavingsAccount.modifyInterestRate(.04);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.printf("4%% saver1: %.2f\n", saver1.getSavingsBalance());
        System.out.printf("4%% saver2: %.2f\n", saver2.getSavingsBalance());

        SavingsAccount.modifyInterestRate(.05);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.printf("5%% saver1: %.2f\n", saver1.getSavingsBalance());
        System.out.printf("5%% saver2: %.2f\n", saver2.getSavingsBalance());
    }
}
