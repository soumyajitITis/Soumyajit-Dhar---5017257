package Q1;
public class SingletonPatternExample {
    static class Logger {
        private static Logger instance;
        private Logger() {
            // Initialize the logger, e.g., setting up a log file
        }


        public static Logger getInstance() {
            if (instance == null) {
                synchronized (Logger.class) {
                    if (instance == null) {
                        instance = new Logger();
                    }
                }
            }
            return instance;
        }


        public void log(String message) {
            // Implementation for logging messages
            System.out.println(message);
        }
    }

    // Test class
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();


        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");


        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 reference the same instance.");
        } else {
            System.out.println("logger1 and logger2 reference different instances.");
        }
    }
}
