package com.project.pageObjects.checkoutPO;

import com.project.utils.Constants_Vars;
import com.project.utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePO {
    private final Helper helper;

    public CheckoutCompletePO(WebDriver webDriver) {
        this.helper = new Helper(webDriver);
    }

    private final By labelTittleMessageLocator = By.xpath("//h2[normalize-space()='Thank you for your order!']");
    private final By labelCompleteMessageLocator = By.xpath("//div[@class='complete-text']");


    public String getTittleMessage() {
        WebElement labelTittleMessage = helper.waitAndFindElement(labelTittleMessageLocator, Constants_Vars.DEFAULT_TIMEOUT);
        return labelTittleMessage.getText();
    }
    public String getCompleteMessage() {
        WebElement labelCompleteMessage = helper.waitAndFindElement(labelCompleteMessageLocator, Constants_Vars.DEFAULT_TIMEOUT);
        return labelCompleteMessage.getText();
    }
}
