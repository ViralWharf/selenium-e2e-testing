package com.project.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.project.utils.Config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    private static void createDriver() {
        String browser = Config.get("browser");

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = getChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                break;

            default:
                throw new IllegalArgumentException("Navegador no soportado: " + browser);
        }
    }

    private static ChromeOptions getChromeOptions() {
        final Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        chromePrefs.put("profile.password_manager_leak_detection", false);

        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePrefs);

        return chromeOptions;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
