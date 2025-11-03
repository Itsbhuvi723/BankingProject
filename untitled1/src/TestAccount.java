class TestAccount extends Account {
    public TestAccount(int accountNo, Customer customer, double balance) {
        super(accountNo, customer, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: ₹" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if(balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}
