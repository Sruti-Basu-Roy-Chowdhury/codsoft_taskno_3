import java.util.Scanner;

      class BankAccount{
          private double balance;

          public BankAccount(double initialBalance) {
              this. balance = initialBalance;
          }
          public double getBalance(){
              return balance;
          }
          public void deposit(double amount){
              if(amount > 0){
                  balance += amount;
                  System.out.println("Deposit successful."+ '\n' + "New balance: " + balance);
              } else {
                  System.out.println("Invalid amount for deposit.");
              }
          }
          public void withdraw(double amount){
              if(amount > 0 && amount<=balance){
                  balance -= amount;
                  System.out.println("Withdrawal successful." + '\n' +  "New balance: " + balance);
              } else{
                  System.out.println("Inefficient Funds Or Invalid Amount For Withdrawal.");

              }
          }
      }
      class ATM {
          private final BankAccount account;
          private final Scanner scanner;
          public ATM(BankAccount account){
              this.account = account;
              this.scanner = new Scanner(System.in);
          }
          public void showMenu(){
              System.out.println("1. Check Balance");
              System.out.println("2. Deposit");
              System.out.println("3. Withdraw");
              System.out.println("4. Exit");
          }
          public void run() {
              int choice;
              do{
                  showMenu();
                  System.out.print("Enter Your Choice: ");
                  choice = scanner .nextInt();
                  switch (choice) {
                      case 1:
                          checkBalance();
                          break;
                      case 2:
                          deposit();
                          break;
                      case 3:
                           withdraw();
                           break;
                      case 4:
                          System.out.println("Thank You For Using The ATM!");
                          break;
                      default:
                          System.out.println("Invalid choice please select a valid option.");
                  }
              } while (choice != 4);
          }
          private void checkBalance() {
              System.out.println("Your Current Balance Is: " + account.getBalance());
          }
          private void deposit() {
              System.out.print("Enter The Amount To Deposit : ");
              double amount = scanner.nextDouble();
              account.deposit(amount);
          }
          private void withdraw(){
              System.out.print("Enter The Amount To Withdraw: ");
              double amount = scanner.nextDouble();
              account.withdraw(amount);
          }
      }
      public class Main {
          public static void main(String[] args ){
              System.out.println("Welcome To The ATM!");
              Scanner scan = new Scanner(System.in);
              System.out.print("Enter Your Four Digit PIN: ");
              int enteredPin = scan.nextInt();
              BankAccount userAccount = new BankAccount(1000.0);
              ATM atm = new ATM(userAccount);
              atm.run();
          }
}