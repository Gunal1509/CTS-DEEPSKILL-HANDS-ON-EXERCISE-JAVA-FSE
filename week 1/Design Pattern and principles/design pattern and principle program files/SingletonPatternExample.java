public class SingletonPatternExample {
    static class Logger {
        private static Logger loggerInstance;
        private Logger() {
            System.out.println("Logger has been initialized.");
        }
        public static Logger getLogger() {
            if (loggerInstance == null) {
                loggerInstance = new Logger();
            }
            return loggerInstance;
        }
        public void writeLog(String message) {
            System.out.println("[LOG] " + message);
        }
    }
    public static void main(String[] args) {

        Logger firstLogger = Logger.getLogger();
        firstLogger.writeLog("Application is starting...");

        Logger secondLogger = Logger.getLogger();
        secondLogger.writeLog("User logged into the system.");

        if (firstLogger == secondLogger) {
            System.out.println("Only one Logger object exists.");
        } else {
            System.out.println("Multiple Logger objects exist.");
        }
    }
}