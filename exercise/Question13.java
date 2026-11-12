public class Question13 {
    public static void main(String[] args) {
        TransactionRecord t = new TransactionRecord(101, 2500);
        System.out.println(t.amount());
    }
    
}

record TransactionRecord(int id, double amount) {
    TransactionRecord {
        if(amount <= 0){
            throw new IllegalArgumentException("Amount cannot be zero or negative");
        }
    }
}
