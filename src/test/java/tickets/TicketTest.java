package tickets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Events;
import pages.Incident;

import java.time.Duration;
import java.util.List;

import static utils.WebDriverManager.driver;
import static utils.XPathProvider.dropdownXPath;

public class TicketTest {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Constructor to initialize WebDriver and WebDriverWait
    public TicketTest(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void selectDropdownOption(String ticketType) {
        // Locate and click on the dropdown
        WebElement selectDropDown = driver.findElement(By.xpath(dropdownXPath));
        selectDropDown.click();

        // Wait for dropdown options to be visible and find matching option
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-results-1']/li")));
        boolean optionFound = false;

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(ticketType)) {
                option.click();
                optionFound = true;
                break;
            }
        }

        if (!optionFound) {
            System.out.println("Option not found for ticket type: " + ticketType);
        }
    }

    public void testTicketTypeSelection(String ticketType) {
        // First, select the ticket type from the dropdown
        selectDropdownOption(ticketType);

        // Use switch-case to create specific ticket types based on ticketType
        switch (ticketType) {
            case "Event":
                Events eventsTicket = new Events(driver);
                eventsTicket.createEvent(
                        "noafna", "Email", "London", "25-10-2024 15:02",
                        "Business Continuity Plan", "Disaster Recovery", "S1", "P1",
                        "High", "Service Affecting", "Warning", "Demo", "E-2",
                        "/home/nms/EIG/Selenium/src/test/resources/upload_files/empty.xls"
                );
                break;

            case "Incident":
                Incident incidentTicket = new Incident(driver);
                incidentTicket.createIncident(
                        "nocop1", "Email", "London", "25-10-2024 15:02",
                        "Circuit", "Loop", "BSNL", "EIG/FUJ/MRS/VC4/A1931", "Demo", "Demo", "Demo", "Demo",
                        "S1", "P1", "High", "Demo", "Demo", "I-2",
                        "/home/nms/EIG/Selenium/src/test/resources/upload_files/empty.xls"
                );
                break;

            default:
                System.out.println("Invalid ticket type: " + ticketType);
                break;
        }
    }


}
