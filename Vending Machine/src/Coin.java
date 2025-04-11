public enum Coin {
    PENNY(0.01),
    QUARTER(0.25),
    DIME(0.1);

    private final double value;

    Coin(double value) {
        this.value = value;
    }

    public double getCoinValue() {
        return value;
    }
}
