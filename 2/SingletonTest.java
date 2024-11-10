class Singleton {
    // Private constructor to prevent instantiation
    private Singleton() {
        // Initialization code here
    }

    // Inner static helper class that holds the Singleton instance
    private static class SingletonHelper {
        // This field will be initialized when the class is loaded
        private static final Singleton INSTANCE = new Singleton();
    }

    // Public method to provide access to the Singleton instance
    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    // Example method to demonstrate functionality
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

// Testing the Singleton in a multithreaded environment
public class SingletonTest {
    public static void main(String[] args) {
        // Create multiple threads to test the Singleton
        Runnable task = () -> {
            Singleton instance = Singleton.getInstance();
            instance.showMessage();
        };

        // Creating multiple threads
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

