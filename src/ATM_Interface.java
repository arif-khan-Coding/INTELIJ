import java.util.Scanner;

class  BankAccount{
    private  double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public void deposit(double amount){
        if(amount > 0) {
            balance += amount;
            System.out.println("Successfully Deposit : $"+amount);
        }else {
            System.out.println("Deposit amount must be Positive.");
        }
    }
    public boolean withdraw(double amount) {
        if(amount > balance) {
            System.out.println("Insufficient balance ! Available Balance is $"+balance);
            return false;
        } else if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return false;
        } else {
            balance -= amount;
            System.out.println("Successfully withdraw : $"+amount);
            return true;
        }
    }
    public double checkBalance() {
        return balance;
    }
}
class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }
    public void showMenu() {
        int option;
        do{
            System.out.println("\n ATM Menu : ");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Please Choose an Option : ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.println("Thank You for Using the ATM. Goodbye.");
                    break;
                default:
                    System.out.println("Invalid Option . Please try again.");
            }
        } while (option != 4);
    }
    private void checkBalance(){
        System.out.println("Current balance : $"+account.checkBalance());
    }
    private void depositMoney(){
        System.out.println("Enter the amount of deposit : ");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }
    private void withdrawMoney() {
        System.out.print("Enter the amount to withdraw : ");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }
}
public class ATM_Interface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        ATM atm = new ATM(account);
        atm.showMenu();
    }
}