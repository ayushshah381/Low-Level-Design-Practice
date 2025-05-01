public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        // Logging
        logger.info("This is an information message");
        logger.debug("This is a debug message");
        logger.error("This is an error message");

        // Changing log level and appender
        LoggerConfig config = new LoggerConfig(new FileAppender("app.log"), LogLevel.DEBUG);
        logger.setLoggerConfig(config);

        // Creates a file called app.log in the same directory as src, and logs the message

        logger.debug("This is a debug message");
        logger.info("This is an information message");
    }
}