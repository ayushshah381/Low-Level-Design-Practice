import java.util.List;

public class ExpenseService {
    public static Expense createExpense(String description, double amount, User paidBy, List<Split> splits) {
        // Validate the splits based on their types
        switch(splits.get(0).getClass().getSimpleName()) {
            case "EqualSplit":
                int totalUsers = splits.size();
                double equalAmount = Math.round((amount / totalUsers) * 100.0) / 100.0;
                for(Split split: splits) {
                    split.setAmount(equalAmount);
                }
                break;

            case "ExactSplit":
                double totalExactAmount = 0;
                for(Split split: splits) {
                    totalExactAmount += split.getAmount();
                }
                if (totalExactAmount != amount) {
                    throw new IllegalArgumentException("Sum of exact splits must equal total expense amount.");
                }
                break;
            case "PercentSplit":
                double totalPercent = 0;
                for (Split split : splits) {
                    PercentSplit pSplit = (PercentSplit) split;
                    totalPercent += pSplit.getPercent();
                }
                if (totalPercent != 100) {
                    throw new IllegalArgumentException("Sum of percentages must be 100.");
                }
                for (Split split : splits) {
                    PercentSplit pSplit = (PercentSplit) split;
                    double splitAmount = (amount * pSplit.getPercent()) / 100.0;
                    pSplit.setAmount(Math.round(splitAmount * 100.0) / 100.0);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid split type provided.");
        }
        return new Expense(description, amount, paidBy, splits);
    }
}
