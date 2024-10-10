package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/* Helper class to manage WebDriver and other settings */
public class HelperClass {
    private static HelperClass helperClass;

    private static WebDriver driver;
    private static JavascriptExecutor js;
    public final static int TIMEOUT = 30; // wait time

    // Initialize Firefox driver
    private HelperClass() {
        // Setup WebDriverManager for Firefox
        WebDriverManager.firefoxdriver().setup();

        // Setup options for Firefox
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");  // Start in fullscreen mode

        // Initialize FirefoxDriver
        driver = new FirefoxDriver(options);
        System.out.println("Firefox browser initialized");

        driver.manage().window().maximize(); // Maximize the window
        driver.manage().deleteAllCookies();  // Delete all cookies
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));  // Set wait time
    }

    public static void openPage(String url) {
        driver.get(url);
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            setUpDriver(); // Initialize the driver if not yet initialized
        }
        return driver;
    }

    // Setup the driver for the first time
    public static void setUpDriver() {
        if (helperClass == null) {
            helperClass = new HelperClass();
        }
    }

    // Close the driver after execution is finished
    public static void tearDown() {
        if (driver != null) {
            try {
                driver.quit();  // Ensure the session is closed and the driver is stopped
                driver = null;  // Set the driver to null after quit
            } catch (Exception e) {
                System.out.println("Error during quitting the browser: " + e.getMessage());
            }
        }

        helperClass = null; // Set helperClass to null to clean up resources
    }
}
