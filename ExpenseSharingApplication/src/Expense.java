import java.util.List;
import java.util.UUID;

public class Expense {
    private String expenseId;
    private String description;
    private User paidBy;
    private double amount;
    private List<Split> splits;

    public Expense(String description, double amount, User paidBy, List<Split> splits) {
        this.expenseId = UUID.randomUUID().toString();
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public String getDescription() {
        return description;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public List<Split> getSplits() {
        return splits;
    }
}
