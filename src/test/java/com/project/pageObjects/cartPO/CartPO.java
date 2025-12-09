package com.project.pageObjects.cartPO;

import com.project.utils.Constants_Vars;
import com.project.utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPO {
    private final Helper helper;

    public CartPO(WebDriver webDriver) {
        this.helper = new Helper(webDriver);
    }

    private final By btnCheckoutLocator = By.id("checkout");


    public void clickCheckout() {
        WebElement btnCheckout = helper.waitAndFindElement(btnCheckoutLocator, Constants_Vars.DEFAULT_TIMEOUT);
        btnCheckout.click();
    }
}
