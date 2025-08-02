import java.util.List;

public class Main {
    public static void main(String[] args) {
        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");
        User david = new User("David");

        Group trip = new Group("Goa Trip");
        trip.addMember(alice);
        trip.addMember(bob);
        trip.addMember(charlie);
        trip.addMember(david);

        // --- Log Expenses ---
        // Expense 1: Alice pays 1000 for a taxi, split equally
        List<Split> splits1 = List.of(new EqualSplit(alice), new EqualSplit(bob), new EqualSplit(charlie), new EqualSplit(david));
        trip.addExpense(ExpenseService.createExpense("Taxi", 1000, alice, splits1));

        // Expense 2: Bob pays 500 for lunch, split exactly
        List<Split> splits2 = List.of(new ExactSplit(alice, 100), new ExactSplit(bob, 250), new ExactSplit(charlie, 150));
        trip.addExpense(ExpenseService.createExpense("Lunch", 500, bob, splits2));

        // Expense 3: Charlie pays 800 for dinner, split by percentage
        List<Split> splits3 = List.of(
                new PercentSplit(alice, 40), // 320
                new PercentSplit(bob, 20),   // 160
                new PercentSplit(charlie, 20), // 160
                new PercentSplit(david, 20)  // 160
        );
        trip.addExpense(ExpenseService.createExpense("Dinner", 800, charlie, splits3));

        // --- Calculate and Simplify Debts ---
        System.out.println("--- Calculating Simplified Debts for " + trip.getName() + " ---");
        List<SettlementTransaction> finalSettlements = SimplificationService.simplifyDebts(trip);

        if (finalSettlements.isEmpty()) {
            System.out.println("All debts are settled!");
        } else {
            System.out.println("To settle all debts, the following payments should be made:");
            finalSettlements.forEach(System.out::println);
        }
    }
}