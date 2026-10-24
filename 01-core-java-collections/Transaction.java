public class Transaction {

    private String transactionId;
    private double amount;
    private String type;

    public Transaction(String transactionId, double amount, String type) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.type = type;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

}
