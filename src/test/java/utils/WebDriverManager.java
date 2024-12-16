package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverManager {
    public static WebDriver driver;
        public static WebDriver getDriver() {
            return driver;  // Replace with actual WebDriver instance management logic
        
    }
    // Overloaded method to wait for visibility of an element
    public static WebElement waitForElementVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    // New method to wait for elements
    public static WebElement waitForElementToBeClickable(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    // Method to explicitly wait for a page to load
//    public static void waitForPageLoad(By progressPopupLocator, int timeout) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(progressPopupLocator));
//    }
    public static void waitForPageLoad() {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("super-ac-wrapper")));
        }
}
