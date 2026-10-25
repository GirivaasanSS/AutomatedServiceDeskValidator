package com.servicedesk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TicketPortalPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By clientNameInput = By.id("clientName");
    private By issueDescriptionInput = By.id("issueDescription");
    private By departmentDropdown = By.id("deptSelect");
    private By submitButton = By.id("submitTicketBtn");
    private By disclosurePopup = By.id("legalDisclosureModal");
    private By acceptDisclosureBtn = By.id("acceptDisclosure");
    private By successMessage = By.cssSelector(".alert-success");
    private By routingLabel = By.id("assignedDepartment");

    public TicketPortalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToPortal(String url) {
        driver.get(url);
    }

    public void fillTicketDetails(String name, String description) {
        driver.findElement(clientNameInput).sendKeys(name);
        driver.findElement(issueDescriptionInput).sendKeys(description);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public boolean isDisclosureDisplayed() {
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(disclosurePopup));
        return popup.isDisplayed();
    }

    public void acceptDisclosure() {
        driver.findElement(acceptDisclosureBtn).click();
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }

    public String getAssignedRoutingDepartment() {
        return driver.findElement(routingLabel).getText();
    }
}
