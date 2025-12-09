package com.project.pageObjects.checkoutPO;

import com.project.utils.Constants_Vars;
import com.project.utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStepTwoPO {
    private final Helper helper;

    public CheckoutStepTwoPO(WebDriver webDriver) {
        this.helper = new Helper(webDriver);
    }

    private final By btnFinishLocator = By.id("finish");

    public void clickFinish() {
        WebElement btnFinish = helper.waitAndFindElement(btnFinishLocator, Constants_Vars.DEFAULT_TIMEOUT);
        btnFinish.click();
    }
}
