public class SavingsAccount extends Account {
    private double interestRate = 3.5; // default interest rate %

    // ✅ Constructor
    public SavingsAccount(int accountNo, Customer customer, double balance) {
        super(accountNo, customer, balance);
    }

    // ✅ Deposit implementation
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // ✅ Withdraw implementation (minimum balance rule: ₹1000)
    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance - amount >= 1000) {
                balance -= amount;
                System.out.println("Withdrawn: ₹" + amount);
            } else {
                System.out.println("❌ Insufficient balance (Min ₹1000 required).");
            }
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    // ✅ Method to calculate interest
    public void addInterest() {
        double interest = (balance * interestRate) / 100;
        balance += interest;
        System.out.println("Interest added: ₹" + interest);
    }

    // ✅ Display account details (override for extra info)
    @Override
    public void displayDetails() {
        super.displayDetails(); // call parent method
        System.out.println("Account Type: Savings");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
