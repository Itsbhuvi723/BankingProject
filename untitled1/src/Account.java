public abstract class Account {
    // ✅ Attributes
    protected int accountNo;
    protected Customer customer;
    protected double balance;

    // ✅ Constructor
    public Account(int accountNo, Customer customer, double balance) {
        this.accountNo = accountNo;
        this.customer = customer;
        this.balance = balance;
    }

    // ✅ Abstract Methods (must be implemented by child classes)
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    // ✅ Concrete Method: Get balance
    public double getBalance() {
        return balance;
    }

    // ✅ Concrete Method: Display account details
    public void displayDetails() {
        System.out.println("Account No: " + accountNo);
        System.out.println("Customer: " + customer);
        System.out.println("Balance: ₹" + balance);
    }
}
