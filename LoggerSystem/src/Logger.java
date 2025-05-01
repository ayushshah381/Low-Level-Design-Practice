public class Logger {
    private static Logger instance;
    private LoggerConfig loggerConfig;

    private Logger() {
        // Private constructor to enforce singleton pattern
        loggerConfig = new LoggerConfig(new ConsoleAppender(), LogLevel.INFO);
    }

    public static synchronized Logger getInstance() {
        if(instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void setLoggerConfig(LoggerConfig loggerConfig) {
        this.loggerConfig = loggerConfig;
    }

    public void log(LogLevel level, String message) {
        if(level.getLevelValue() >= loggerConfig.getLogLevel().getLevelValue()) {
            LogMessage logMessage = new LogMessage(level, message);
            loggerConfig.getLogAppender().append(logMessage);
        }
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
}
