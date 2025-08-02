/**
 * Represents how a share of an expense is divided for a single user.
 * This acts as the base for our Strategy Pattern.
 */
abstract class Split {
    private User user;
    private double amount;

    public Split(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
