import java.util.HashMap;
import java.util.Map;

public class BalanceService {
    public static Map<User, Double> calculateBalances(Group group) {
        Map<User, Double> balances = new HashMap<>();

        // Initialize all members with 0 balance
        for(User member: group.getMembers()) {
            balances.put(member, 0.0);
        }

        for(Expense expense: group.getExpenses()) {
            User paidBy = expense.getPaidBy();
            double totalAmount = expense.getAmount();

            // The person who paid is owed the full amount
            balances.put(paidBy, balances.get(paidBy) + totalAmount);

            // Each person in the split owes their share
            for (Split split : expense.getSplits()) {
                User participant = split.getUser();
                double amountOwed = split.getAmount();
                balances.put(participant, balances.get(participant) - amountOwed);
            }
        }

        return balances;
    }
}
