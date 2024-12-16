package tests;


import base.BaseTest;
import org.testng.annotations.Test;
import pages.Events;
import pages.LoginPage;
import pages.NewTicket;
import tickets.TicketTest;
import utils.XPathProvider;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() throws InterruptedException {
        logger.info("**Starting TestCase 1....**");
        try {
            LoginPage loginPage = new LoginPage(driver);
            logger.trace("Entering username...");
            loginPage.enterUsername("nocop1", XPathProvider.usernameXPath);
            logger.trace("Username entered successfully.");

            logger.trace("Entering password...");
            loginPage.enterPassword("Test@123$", XPathProvider.passwordXPath);
            logger.trace("Password entered successfully.");

            // Uncomment if needed
            // logger.trace("Checking for force logout...");
            // loginPage.forceLogout(XPathProvider.forceLogoutXPath);
            // logger.trace("Force logout completed.");

            logger.trace("Clicking login button...");
            loginPage.clickLogin(XPathProvider.loginButtonXPath);
            logger.trace("Login button clicked successfully.");

            logger.trace("Navigating to Trouble Ticket page...");
            loginPage.troubleTicket(XPathProvider.troubleTicketXPath, XPathProvider.openTicketsXPath);
            logger.trace("Trouble Ticket page opened.");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

            logger.trace("Opening new ticket...");
            NewTicket ticket = new NewTicket(driver);
            ticket.newTicketClick(XPathProvider.newTicketXPath);
            logger.trace("New ticket opened successfully.");
            //{"Event"}{"Incident"}{"Problem"}{"Request Fulfillment"}{"Change"}
            TicketTest ticketTest = new TicketTest(driver);
            String ticketType = "Problem";

            logger.trace("Selecting ticket type: " + ticketType);
            ticketTest.testTicketTypeSelection(ticketType);
            ticketTest.selectDropdownOption(ticketType);
            logger.trace("Ticket type selected successfully: " + ticketType);

            logger.debug("Debug logs - Ticket creation process completed successfully.");

        } catch (Exception e) {
            logger.error("An error occurred during the testValidLogin process.", e);
            throw new RuntimeException("Test case failed due to an exception.", e);
        }
    }
}

