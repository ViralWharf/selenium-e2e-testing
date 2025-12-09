package com.project.pageObjects.inventoryPO;

import com.project.utils.Constants_Vars;
import com.project.utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPO {
    private final Helper helper;

    public InventoryPO(WebDriver webDriver) {
        this.helper = new Helper(webDriver);
    }

    private final By btnAddBackpackLocator = By.id("add-to-cart-sauce-labs-backpack");
    private final By btnAddBikeLightLocator = By.id("add-to-cart-sauce-labs-bike-light");
    private final By btnCartLocator = By.xpath("//a[@class='shopping_cart_link']");

    private final By labelTittleBackpackLocator = By.xpath("//div[normalize-space()='Sauce Labs Backpack']");
    private final By labelPriceBackpackLocator = By.xpath("//div[normalize-space()='$29.99']");

    public void clickAddBackpack(){
        WebElement btnAddBackpack = helper.waitAndFindElement(btnAddBackpackLocator, Constants_Vars.DEFAULT_TIMEOUT);
        btnAddBackpack.click();
    }

    public String getTittleBackpack(){
        WebElement labelTittleBackpack = helper.waitAndFindElement(labelTittleBackpackLocator, Constants_Vars.DEFAULT_TIMEOUT);
        return labelTittleBackpack.getText();
    }

    public String getPriceBackpack(){
        WebElement labelPriceBackpack = helper.waitAndFindElement(labelPriceBackpackLocator, Constants_Vars.DEFAULT_TIMEOUT);
        return labelPriceBackpack.getText();
    }

    public void clickAddBikeLight(){
        WebElement btnAddBikeLight = helper.waitAndFindElement(btnAddBikeLightLocator, Constants_Vars.DEFAULT_TIMEOUT);
        btnAddBikeLight.click();
    }

    public void clickCart(){
        WebElement btnCart = helper.waitAndFindElement(btnCartLocator, Constants_Vars.DEFAULT_TIMEOUT);
        btnCart.click();
    }
}
