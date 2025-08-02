/**
 * A simple data class to represent a final, simplified transaction.
 */
class SettlementTransaction {
    public final User from;
    public final User to;
    public final double amount;

    public SettlementTransaction(User from, User to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%s owes %s $%.2f", from.getName(), to.getName(), amount);
    }
}