public class CurrentAccount extends Account {
    private double overdraftLimit;

    // ✅ Constructor
    public CurrentAccount(int accountNo, Customer customer, double balance, double overdraftLimit) {
        super(accountNo, customer, balance);
        this.overdraftLimit = overdraftLimit;
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

    // ✅ Withdraw implementation (Overdraft allowed)
    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance - amount >= -overdraftLimit) {
                balance -= amount;
                System.out.println("Withdrawn: ₹" + amount);
            } else {
                System.out.println("❌ Withdrawal exceeds overdraft limit!");
            }
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    // ✅ Display account details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type: Current");
        System.out.println("Overdraft Limit: ₹" + overdraftLimit);
    }
}
