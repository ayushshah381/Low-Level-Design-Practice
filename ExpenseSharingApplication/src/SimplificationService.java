import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Contains the algorithm to simplify the debts within a group.
 */
public class SimplificationService {
   public static List<SettlementTransaction> simplifyDebts(Group group) {
       Map<User, Double> balances = BalanceService.calculateBalances(group);

       // Separate users into Creditors (positive balances), and Debtors (negative balances)
       List<Map.Entry<User, Double>> creditors =
               balances.entrySet().stream().filter(entry -> entry.getValue() > 0).collect(Collectors.toList());

       List<Map.Entry<User, Double>> debtors =
               balances.entrySet().stream().filter(entry -> entry.getValue() < 0).collect(Collectors.toList());

       List<SettlementTransaction> transactions = new ArrayList<>();

       // Greedy approach to settle debts
       int creditorIndex = 0;
       int debtorIndex = 0;
       while(creditorIndex < creditors.size() && debtorIndex < debtors.size()) {
           Map.Entry<User, Double> creditor = creditors.get(creditorIndex);
           Map.Entry<User, Double> debtor = debtors.get(debtorIndex);

           double amountToSettle = Math.min(creditor.getValue(), -debtor.getValue());

           // Create a transaction
           transactions.add(new SettlementTransaction(debtor.getKey(), creditor.getKey(), amountToSettle));

           // Update balances
           creditor.setValue(creditor.getValue() - amountToSettle);
           debtor.setValue(debtor.getValue() + amountToSettle);

           // If a balance is settled, move to the next person
           if (Math.abs(creditor.getValue()) < 0.01) {
               creditorIndex++;
           }
           if (Math.abs(debtor.getValue()) < 0.01) {
               debtorIndex++;
           }
       }
       return transactions;
   }
}
