public enum LogLevel {
    DEBUG(1),
    INFO(2),
    ERROR(3);

    private final int levelValue;

    LogLevel(int levelValue) {
        this.levelValue = levelValue;
    }

    public int getLevelValue() {
        return levelValue;
    }
}
