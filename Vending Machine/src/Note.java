public enum Note {
    TEN(10),
    TWENTY(20);

    private final double value;

    Note(double value) {
        this.value = value;
    }

    public double getNoteValue() {
        return value;
    }
}
