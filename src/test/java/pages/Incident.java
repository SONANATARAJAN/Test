package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

import static utils.WebDriverManager.driver;

public class Incident {
    private WebDriverWait wait;

    public Incident(WebDriver driver) {
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

    public void partyName(String PartyName) {
        // Open the dropdown to display options
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-chosen-15"))).click();
// Wait for the dropdown options to be visible
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-results-15']/li")));
// Determine the criteria for selection dynamically
        String criteria = PartyName; // Assuming ModeofRequest has the value you want to match
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
    public void circuits(String Circuits){
        // Open the dropdown to display options
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-chosen-16"))).click();
// Wait for the dropdown options to be visible
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-results-16']/li")));
// Determine the criteria for selection dynamically
        String criteria = Circuits; // Assuming ModeofRequest has the value you want to match
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

    public void designation(String Designation) {
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Designation")));
        inputField.clear(); // Clear the field if necessary
        inputField.sendKeys(Designation); // Input the value
        System.out.println("Value inputted: " + Designation);

    }
    public void circuitRate(String CircuitRate){
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("circuitRatetext")));
        inputField.clear(); // Clear the field if necessary
        inputField.sendKeys(CircuitRate); // Input the value
        System.out.println("Value inputted: " + CircuitRate);
    }
    public void aEnd(String AEnd){
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aEndStation")));
        inputField.clear(); // Clear the field if necessary
        inputField.sendKeys(AEnd); // Input the value
        System.out.println("Value inputted: " + AEnd);
    }
    public void zEnd(String ZEnd){
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("zEndStation")));
        inputField.clear(); // Clear the field if necessary
        inputField.sendKeys(ZEnd); // Input the value
        System.out.println("Value inputted: " + ZEnd);
    }
    public void ProtectionStatus() {
        try {
            // Wait for the element to be clickable and then click it
            wait.until(ExpectedConditions.elementToBeClickable(By.id("ProtectionStatus"))).click();
            System.out.println("ProtectionStatus element clicked successfully.");
        } catch (Exception e) {
            // Print error message and stack trace for debugging
            System.err.println("Error clicking on ProtectionStatus element: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void circuitType(String Circuitype){
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("circuitType")));
        inputField.clear(); // Clear the field if necessary
        inputField.sendKeys(Circuitype); // Input the value
        System.out.println("Value inputted: " + Circuitype);
    }

    public void priority(String Priority){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-chosen-19"))).click();
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-results-19']/li")));
        String criteria = Priority; // Assuming ModeofRequest has the value you want to match
        boolean optionFound = false;
        for (WebElement option : options) {
            String optionText = option.getText();
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
    public void severity(String Severity){
        // Open the dropdown to display options
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-chosen-17"))).click();
// Wait for the dropdown options to be visible
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-results-17']/li")));
// Determine the criteria for selection dynamically
        String criteria = Severity; // Assuming ModeofRequest has the value you want to match
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

    public void urgency(String Urgency){
        // Open the dropdown to display options
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-chosen-18"))).click();
// Wait for the dropdown options to be visible
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-results-18']/li")));
// Determine the criteria for selection dynamically
        String criteria = Urgency; // Assuming ModeofRequest has the value you want to match
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
    public void subject(String Subject){
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subject")));
        inputField.clear(); // Clear the field if necessary
        inputField.sendKeys(Subject); // Input the value
        System.out.println("Value inputted: " + Subject);
    }
    public void Attachments(String filePath) {
        WebElement uploadElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("Attachments")));
        uploadElement.sendKeys(filePath);

}
    public void linketTicket(String LinketTicket) {
        try {
            // Wait for the element to be clickable and then click it
            WebElement ticketDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-chosen-8")));
            ticketDropdown.click();

            // Wait for the input field to be visible
            WebElement inputFields = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("s2id_autogen8_search")));
            // Clear the field if necessary (uncomment if needed)
            // inputFields.clear();
            inputFields.sendKeys(LinketTicket); // Input the value

            // Wait for options to be visible
            List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-results-8']//li")));

            // Check if any options were found and select the first
            if (!options.isEmpty()) {
                options.get(0).click(); // Click the first element
                System.out.println("Selected: " + options.get(0).getText()); // Log the selection
            } else {
                System.out.println("No options found in the dropdown.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Operation timed out: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void Submit(){
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("Submit"))).click();
        // Wait until the overlay is no longer visible
        WebElement submitButton = driver.findElement(By.id("Submit")); // Use the actual ID or locator
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", submitButton);

    }
    public void createIncident(String username, String modeOfRequest, String station, String reportedTime,
                               String classification, String SubClassification,String PartyName,String  Circuits,String Designation,String CircuitRate,String AEnd,String ZEnd, String severity, String priority,
                               String urgency,String CircuitType,String Subject,
                               String linketTicket, String filePath) {
        requestGroup(username);
        requesterUser(username);
        modeOfRequest(modeOfRequest);
        station(station);
        reportedTime(reportedTime);
        classification(classification);
        subClassification(SubClassification);
        partyName(PartyName);
        circuits(Circuits);
        designation(Designation);
        circuitRate(CircuitRate);
        aEnd(AEnd);
        zEnd(ZEnd);
        ProtectionStatus();
        circuitType(CircuitType);
        severity(severity);
        priority(priority);
        urgency(urgency);
        subject(Subject);
        linketTicket(linketTicket);
        // Upload the files
        Attachments(filePath);
        Submit();
    }

}

//EndStation

