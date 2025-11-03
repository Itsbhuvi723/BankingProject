import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private int transactionId;
    private int accountNo;
    private String type;  // Deposit / Withdraw
    private double amount;
    private String date;

    // ✅ Constructor
    public Transaction(int transactionId, int accountNo, String type, double amount) {
        this.transactionId = transactionId;
        this.accountNo = accountNo;
        this.type = type;
        this.amount = amount;

        // Automatically set current date & time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.date = dtf.format(LocalDateTime.now());
    }

    // ✅ Getters
    public int getTransactionId() {
        return transactionId;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    // ✅ Display transaction details
    @Override
    public String toString() {
        return "Transaction [ID=" + transactionId +
                ", Account=" + accountNo +
                ", Type=" + type +
                ", Amount=₹" + amount +
                ", Date=" + date + "]";
    }
}
