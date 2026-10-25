package com.servicedesk.tests;

import com.servicedesk.pages.TicketPortalPage;
import com.servicedesk.utils.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WorkflowValidationTest {
    private WebDriver driver;
    private TicketPortalPage ticketPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverSetup.initDriver();
        ticketPage = new TicketPortalPage(driver);
    }

    
    @Test
    public void testTicketSubmissionAndDisclosureWorkflow() {
        // Step 1: Open the mock portal (Update path to where your HTML file is stored)
    	ticketPage.navigateToPortal("file:///C:/Users/ssvaa/Desktop/mock%20portal.html");
        
        System.out.println("Starting End-to-End Ticket Submission Simulation...");
        
        // Step 2: Fill ticket details and submit
        ticketPage.fillTicketDetails("John Doe", "VPN Access Denied - Urgent");
        ticketPage.clickSubmit();
        
        // Step 3: Verify and accept the legal disclosure
        Assert.assertTrue(ticketPage.isDisclosureDisplayed(), "Disclosure pop-up should be visible to client before routing.");
        ticketPage.acceptDisclosure();
        
        // Step 4: Verify ticket creation & department routing
        String successMsg = ticketPage.getSuccessMessage();
        Assert.assertTrue(successMsg.contains("Ticket Created"), "Ticket should be successfully logged in the system.");
        
        String dept = ticketPage.getAssignedRoutingDepartment();
        Assert.assertEquals(dept, "Network Support", "Ticket routing rules failed to assign to correct department.");
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
