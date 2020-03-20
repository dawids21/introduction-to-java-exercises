package chapter9.Account;

public class TestAccount {
    public static void main(String[] args) {
        Account acc = new Account(1122, 20000);
        Account.setAnnualInterestRate(4.5);
        acc.withdraw(2500);
        acc.deposit(3000);
        System.out.println("Balance: " + acc.getBalance());
        System.out.println("Monthly interest: " + acc.getMonthlyInterest());
        System.out.println("Created: " + acc.getDateCreated());
        Account acc2 = new Account(1122, 20000);
        System.out.println("Created: " + acc2.getDateCreated());
    }
}