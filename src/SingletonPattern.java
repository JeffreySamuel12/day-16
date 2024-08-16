// SingletonPatternExample.java

public class SingletonPattern {
    // Static variable to hold the single instance
    private static SingletonPattern instance;

    // Configuration setting
    private String setting;

    // Private constructor to prevent instantiation
    private SingletonPattern() {
        // Initialize the configuration setting
        setting = "Default Setting";
    }

    // Public method to provide access to the instance
    public static SingletonPattern getInstance() {
        if (instance == null) {
            instance = new SingletonPattern();
        }
        return instance;
    }

    // Method to get the configuration setting
    public String getSetting() {
        return setting;
    }

    // Method to set the configuration setting
    public void setSetting(String setting) {
        this.setting = setting;
    }

    // Main method
    public static void main(String[] args) {
        // Get the single instance of SingletonPatternExample
        SingletonPattern config = SingletonPattern.getInstance();

        // Print the default setting
        System.out.println("Initial Setting: " + config.getSetting());

        // Change the setting
        config.setSetting("New Setting");

        // Get the instance again and print the updated setting
        SingletonPattern config2 = SingletonPattern.getInstance();
        System.out.println("Updated Setting: " + config2.getSetting());
    }
}
