package org.com.frontend.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebDriverConfig {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty("browser", "chrome");
            switch (browser.toLowerCase()) {
                case "firefox":
                    WebDriverManager.firefoxdriver()
                                    .setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                default:
                    WebDriverManager.chromedriver()
                                    .setup();
                    driver = new ChromeDriver();
                    break;
            }
            driver.manage()
                  .timeouts()
                  .implicitlyWait(Duration.ofSeconds(10));
            driver.manage()
                  .window()
                  .maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}