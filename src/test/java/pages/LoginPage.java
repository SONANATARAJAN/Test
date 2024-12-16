package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverManager;

import java.time.Duration;

public class LoginPage {
    public WebDriver driver;
    public WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.driver = driver;
    }

    // Method to enter username
    public void enterUsername(String username, String usernameXPath) {
        WebElement usernameField = driver.findElement(By.xpath(usernameXPath));
        usernameField.sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password, String passwordXPath) {
        WebElement passwordField = driver.findElement(By.xpath(passwordXPath));
        passwordField.sendKeys(password);
    }

    // Method to click on "Force Logout"
    public void forceLogout(String forceLogoutXPath) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(forceLogoutXPath))).click();
        try {
            // Wait for the checkbox to be visible
            WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(forceLogoutXPath)));
            checkbox.click();
            // Interact with the checkbox
            if (!checkbox.isSelected()) {  // Check if it is not already selected
                checkbox.click();  // Click to select the checkbox
            }
        } catch (Exception e) {
            System.out.println("Checkbox was not found or could not be interacted with: " + e.getMessage());
        }

    }

    // Method to click on login button
    public void clickLogin(String loginButtonXPath) {
        long startTime = System.currentTimeMillis();
        WebElement loginButton = driver.findElement(By.xpath(loginButtonXPath));
        loginButton.click();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to find the login button: " + (endTime - startTime) + " ms");
    }

    // Method to handle trouble ticket
    public void troubleTicket(String troubleTicketXPath, String openTicketsXPath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        Actions act = new Actions(driver);

        // Hover over the "Trouble Ticket" element
        WebElement hoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(troubleTicketXPath)));
        act.moveToElement(hoverElement).build().perform();

        long startTime = System.currentTimeMillis();

        // Click on "Open Tickets"
        WebElement openTicketsElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(openTicketsXPath)));
        act.moveToElement(openTicketsElement).click().build().perform();

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to find and click Trouble Ticket: " + (endTime - startTime) + " ms");
    }
}