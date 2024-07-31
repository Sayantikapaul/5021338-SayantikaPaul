public class Logger {

    private static Logger instance;

    // Private constructor 
    private Logger() {
    }

    public static Logger getInstance() {
        
        return new Logger();
    }

    // Example method to demonstrate logging
    public void log(String message) {
        System.out.println(message);
    }
}
