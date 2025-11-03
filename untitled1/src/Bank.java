import java.util.*;

public class Bank {
    private HashMap<Integer, Account> accounts = new HashMap<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private int nextAccountNo = 1001;
    private int nextTransactionId = 1;

    // ✅ Create Account
    public int createAccount(Customer customer, String type, double initialDeposit) {
        Account acc = null;

        if (type.equalsIgnoreCase("savings")) {
            acc = new SavingsAccount(nextAccountNo, customer, initialDeposit);
        } else if (type.equalsIgnoreCase("current")) {
            acc = new CurrentAccount(nextAccountNo, customer, initialDeposit, 5000); // overdraft = ₹5000
        } else {
            System.out.println("❌ Invalid account type!");
            return -1;
        }

        accounts.put(nextAccountNo, acc);
        System.out.println("✅ Account created successfully. Account No: " + nextAccountNo);
        return nextAccountNo++;
    }

    // ✅ Find account
    public Account findAccount(int accountNo) {
        return accounts.get(accountNo);
    }

    // ✅ Deposit
    public void deposit(int accountNo, double amount) {
        Account acc = findAccount(accountNo);
        if (acc != null) {
            acc.deposit(amount);
            transactions.add(new Transaction(nextTransactionId++, accountNo, "Deposit", amount));
        } else {
            System.out.println("❌ Account not found!");
        }
    }

    // ✅ Withdraw
    public void withdraw(int accountNo, double amount) {
        Account acc = findAccount(accountNo);
        if (acc != null) {
            double oldBalance = acc.getBalance();
            acc.withdraw(amount);
            if (acc.getBalance() != oldBalance) { // Only add transaction if successful
                transactions.add(new Transaction(nextTransactionId++, accountNo, "Withdraw", amount));
            }
        } else {
            System.out.println("❌ Account not found!");
        }
    }

    // ✅ Show Transactions
    public void showTransactions(int accountNo) {
        System.out.println("📜 Transaction History for Account " + accountNo + ":");
        for (Transaction t : transactions) {
            if (t.getAccountNo() == accountNo) {
                System.out.println(t);
            }
        }
    }
}
