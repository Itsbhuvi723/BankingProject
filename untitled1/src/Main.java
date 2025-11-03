import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n===== Banking System Menu =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: // Create Account
                    System.out.print("Enter Customer ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Customer Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Customer Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter Account Type (savings/current): ");
                    String type = sc.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double deposit = sc.nextDouble();

                    Customer customer = new Customer(id, name, email, phone);
                    int accNo = bank.createAccount(customer, type, deposit);
                    if (accNo != -1) {
                        System.out.println("Your Account Number is: " + accNo);
                    }
                    break;

                case 2: // Deposit
                    System.out.print("Enter Account Number: ");
                    int accNoD = sc.nextInt();
                    System.out.print("Enter Amount to Deposit: ");
                    double depAmt = sc.nextDouble();
                    bank.deposit(accNoD, depAmt);
                    break;

                case 3: // Withdraw
                    System.out.print("Enter Account Number: ");
                    int accNoW = sc.nextInt();
                    System.out.print("Enter Amount to Withdraw: ");
                    double wAmt = sc.nextDouble();
                    bank.withdraw(accNoW, wAmt);
                    break;

                case 4: // Check Balance
                    System.out.print("Enter Account Number: ");
                    int accNoB = sc.nextInt();
                    Account acc = bank.findAccount(accNoB);
                    if (acc != null) {
                        System.out.println("Current Balance: ₹" + acc.getBalance());
                    } else {
                        System.out.println("❌ Account not found!");
                    }
                    break;

                case 5: // Transaction History
                    System.out.print("Enter Account Number: ");
                    int accNoT = sc.nextInt();
                    bank.showTransactions(accNoT);
                    break;

                case 6: // Exit
                    System.out.println("👋 Thank you for using the Banking System!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }
}
