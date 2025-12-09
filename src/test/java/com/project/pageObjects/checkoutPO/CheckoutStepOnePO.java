package com.project.pageObjects.checkoutPO;

import com.project.utils.Constants_Vars;
import com.project.utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStepOnePO {
    private final Helper helper;

    public CheckoutStepOnePO(WebDriver webDriver) {
        this.helper = new Helper(webDriver);
    }

    private final By labelFirstNameLocator = By.id("first-name");
    private final By labelLastNameLocator = By.id("last-name");
    private final By labelZipLocator = By.id("postal-code");
    private final By btnContinueLocator = By.id("continue");

    private final By labelErrorMessageLocator = By.xpath("//h3[normalize-space()='Error: First Name is required']");


    public void setFirstName(String name) {
        WebElement labelFirstName = helper.waitAndFindElement(labelFirstNameLocator, Constants_Vars.DEFAULT_TIMEOUT);
        labelFirstName.sendKeys(name);
    }

    public void setLastName(String lastName) {
        WebElement labelLastName = helper.waitAndFindElement(labelLastNameLocator, Constants_Vars.DEFAULT_TIMEOUT);
        labelLastName.sendKeys(lastName);
    }

    public void setZip(String zip) {
        WebElement labelZip = helper.waitAndFindElement(labelZipLocator, Constants_Vars.DEFAULT_TIMEOUT);
        labelZip.sendKeys(zip);
    }

    public void clickContinue() {
        WebElement btnContinue = helper.waitAndFindElement(btnContinueLocator, Constants_Vars.DEFAULT_TIMEOUT);
        btnContinue.click();
    }

    public String getErrorMessage() {
        WebElement labelErrorMessage = helper.waitAndFindElement(labelErrorMessageLocator, Constants_Vars.DEFAULT_TIMEOUT);
        return labelErrorMessage.getText();
    }
}
