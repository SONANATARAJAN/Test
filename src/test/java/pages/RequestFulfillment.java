package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RequestFulfillment {
    private WebDriverWait wait;

    public RequestFulfillment(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50)); // Set timeout
    }

    public void requestGroup(String username) {
        // Determine option based on username
        String optionToSelect = username.equals("nocop1") ? "Main Network Operation Center" :
                username.equals("noafna") ? "Network Administrator" : null;

        if (optionToSelect == null) {
            System.out.println("No specific selection for username: " + username);
            return;
        }

        // Attempt to click dropdown and select the option
        for (int i = 0; i < 3; i++) {  // Retry up to 3 times to avoid stale element issues
            try {
                // Click the dropdown to display options
                WebElement dropdownTrigger = wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-chosen-9")));
                dropdownTrigger.click();

                // Find and select the desired option
                List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-results-9']/li")));
                options.stream()
                        .filter(option -> option.getText().equals(optionToSelect))
                        .findFirst()
                        .ifPresent(WebElement::click);

                System.out.println("Selecting: " + optionToSelect);
                break;  // Exit loop if selection is successful
            } catch (StaleElementReferenceException e) {
                System.out.println("Retrying selection due to stale element reference.");
            }
        }
    }


    public void requesterUser(String username) {
        // Determine option based on username
        String optionToSelect = username.equals("nocop1") ? "nocop1" :
                username.equals("noafna") ? "noafna" : null;
        if (optionToSelect == null) {
            System.out.println("No specific selection for username: " + username);
            return; // Exit if no valid option is found for username
        }

        // Click the dropdown and select the option
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-chosen-10"))).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-results-10']/li")))
                .stream()
                .filter(option -> option.getText().equals(optionToSelect))
                .findFirst()
                .ifPresent(WebElement::click);
    }


    public void modeOfRequest(String ModeofRequest) {
        // Open the dropdown to display options
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-chosen-14"))).click();
// Wait for the dropdown options to be visible
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-results-14']/li")));
// Determine the criteria for selection dynamically
        String criteria = ModeofRequest; // Assuming ModeofRequest has the value you want to match
// Flag to check if the option is found
        boolean optionFound = false;
// Iterate through the options to find a match
        for (WebElement option : options) {
            String optionText = option.getText();
            // Check if the option matches the criteria dynamically
            if (optionText.equalsIgnoreCase(criteria)) { // Using equalsIgnoreCase for case-insensitive match
                option.click(); // Click the matching option
                optionFound = true;
                break; // Exit loop once the option is found
            }
        }
        if (!optionFound) {
            System.out.println("Option not found for criteria: " + criteria);
        }
    }

    public void station(String Station) {
        // Open the dropdown to display options
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-chosen-11"))).click();
// Wait for the dropdown options to be visible
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-results-11']/li")));
// Determine the criteria for selection dynamically
        String criteria = Station; // Assuming ModeofRequest has the value you want to match
// Flag to check if the option is found
        boolean optionFound = false;
// Iterate through the options to find a match
        for (WebElement option : options) {
            String optionText = option.getText();
            // Check if the option matches the criteria dynamically
            if (optionText.equalsIgnoreCase(criteria)) { // Using equalsIgnoreCase for case-insensitive match
                option.click(); // Click the matching option
                optionFound = true;
                break; // Exit loop once the option is found
            }
        }
        if (!optionFound) {
            System.out.println("Option not found for criteria: " + criteria);
        }
    }

    public void reportedTime(String ReportedTime) {
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReportedTime")));
        inputField.clear(); // Clear the field if necessary
        inputField.sendKeys(ReportedTime); // Input the value
        System.out.println("Value inputted: " + ReportedTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='drp-buttons']//button[text()='Apply']"))).click();
//    public void classification(){
//
    }

    public void classification(String Classification) {
        // Open the dropdown to display options
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-chosen-12"))).click();
// Wait for the dropdown options to be visible
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-results-12']/li")));
// Determine the criteria for selection dynamically
        String criteria = Classification; // Assuming ModeofRequest has the value you want to match
// Flag to check if the option is found
        boolean optionFound = false;
// Iterate through the options to find a match
        for (WebElement option : options) {
            String optionText = option.getText();
            // Check if the option matches the criteria dynamically
            if (optionText.equalsIgnoreCase(criteria)) { // Using equalsIgnoreCase for case-insensitive match
                option.click(); // Click the matching option
                optionFound = true;
                break; // Exit loop once the option is found
            }
        }
        if (!optionFound) {
            System.out.println("Option not found for criteria: " + criteria);
        }
    }

    public void subClassification(String SubClassification) {
        // Open the dropdown to display options
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-chosen-13"))).click();
// Wait for the dropdown options to be visible
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-results-13']/li")));
// Determine the criteria for selection dynamically
        String criteria = SubClassification; // Assuming ModeofRequest has the value you want to match
// Flag to check if the option is found
        boolean optionFound = false;
// Iterate through the options to find a match
        for (WebElement option : options) {
            String optionText = option.getText();
            // Check if the option matches the criteria dynamically
            if (optionText.equalsIgnoreCase(criteria)) { // Using equalsIgnoreCase for case-insensitive match
                option.click(); // Click the matching option
                optionFound = true;
                break; // Exit loop once the option is found
            }
        }
        if (!optionFound) {
            System.out.println("Option not found for criteria: " + criteria);
        }
    }
}
