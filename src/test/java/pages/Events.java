package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utils.WebDriverManager.driver;

public class Events {

    private WebDriverWait wait;

    public Events(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set timeout
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
    public void station(String Station){
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
    public void reportedTime(String ReportedTime){
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReportedTime")));
        inputField.clear(); // Clear the field if necessary
        inputField.sendKeys(ReportedTime); // Input the value
        System.out.println("Value inputted: " + ReportedTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='drp-buttons']//button[text()='Apply']"))).click();
//    public void classification(){
//
    }
    public void classification(String Classification){
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
    public void subClassification(String SubClassification){
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
public void severity(String Severity){
    // Open the dropdown to display options
    wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-chosen-15"))).click();
// Wait for the dropdown options to be visible
    List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-results-15']/li")));
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
    public void periority(String Periority){
        // Open the dropdown to display options
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-chosen-18"))).click();
// Wait for the dropdown options to be visible
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-results-18']/li")));
// Determine the criteria for selection dynamically
        String criteria = Periority; // Assuming ModeofRequest has the value you want to match
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
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-chosen-16"))).click();
// Wait for the dropdown options to be visible
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-results-16']/li")));
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
    public void eventType(String EventType){
        // Open the dropdown to display options
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-chosen-19"))).click();
// Wait for the dropdown options to be visible
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-results-19']/li")));
// Determine the criteria for selection dynamically
        String criteria = EventType; // Assuming ModeofRequest has the value you want to match
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
    public void categoryInput(String Category){
        // Open the dropdown to display options
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-chosen-17"))).click();
// Wait for the dropdown options to be visible
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-results-17']/li")));
// Determine the criteria for selection dynamically
        String criteria = Category; // Assuming ModeofRequest has the value you want to match
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
    public void subjectInput(String SubjectInput){
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subject")));
        inputField.clear(); // Clear the field if necessary
        inputField.sendKeys(SubjectInput); // Input the value
        System.out.println("Value inputted: " + SubjectInput);

    }
    public void notifyToIRU(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='NotifyToIRU']//a[@name='Yes' and text()='Yes']"))).click();
    }
    public void linketTicket(String LinketTicket){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-chosen-8"))).click();
        WebElement inputFields = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("s2id_autogen8_search")));
       // inputField.clear(); // Clear the field if necessary
        inputFields.sendKeys(LinketTicket); // Input the value
        System.out.println("Value inputted: " + LinketTicket);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-result-label-138"))).click();


    }
    public void NotifyToIRUwithAttachment(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='NotifyToIRUwithAttachment']//a[@name='Yes' and text()='Yes']"))).click();

    }
   // private By fileInput = By.id("Attachments");

    // Method to upload a file by sending the file path
    public void Attachments(String filePath) {
        WebElement uploadElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("Attachments")));
        uploadElement.sendKeys(filePath);
    }
    public void ImpactedCircuitAttachment(String filePath){
        WebElement uploadElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ImpactedCircuit\"]/div[2]/div/div[2]/input")));
        uploadElement.sendKeys(filePath);

    }
    public void Submit(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("Submit"))).click();
    }
    public void createEvent(String username, String modeOfRequest, String station, String reportedTime,
                               String classification, String subClassification, String severity, String priority,
                               String urgency, String eventType, String category, String subjectInput,
                               String linketTicket, String filePath) {
        requestGroup(username);
        requesterUser(username);
        modeOfRequest(modeOfRequest);
        station(station);
        reportedTime(reportedTime);
        classification(classification);
        subClassification(subClassification);
        severity(severity);
        periority(priority);
        urgency(urgency);
        eventType(eventType);
        categoryInput(category);
        subjectInput(subjectInput);
        notifyToIRU();
        linketTicket(linketTicket);
        NotifyToIRUwithAttachment();

        // Upload the files
        Attachments(filePath);
        ImpactedCircuitAttachment(filePath);
        Submit();
    }

}




