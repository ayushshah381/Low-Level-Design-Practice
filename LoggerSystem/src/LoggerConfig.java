public class LoggerConfig {
    private LogAppender logAppender;
    private LogLevel logLevel;

    public LoggerConfig(LogAppender logAppender, LogLevel logLevel) {
        this.logAppender = logAppender;
        this.logLevel = logLevel;
    }

    public LogAppender getLogAppender() {
        return logAppender;
    }

    public void setLogAppender(LogAppender logAppender) {
        this.logAppender = logAppender;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
}
