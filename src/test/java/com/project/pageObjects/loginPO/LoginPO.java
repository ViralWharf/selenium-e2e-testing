package com.project.pageObjects.loginPO;

import com.project.utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPO {
    private final Helper helper;

    public LoginPO(WebDriver webDriver) {
        this.helper = new Helper(webDriver);
    }

    private final By inputUsernameLocator = By.id("user-name");
    private final By inputPasswordLocator = By.id("password");
    private final By btnLoginLocator = By.id("login-button");
    private final By labelTittleLocator = By.className("login_logo");
    private final By labelErrorLoginLocator = By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]");

    public void setUsername(String username){
        WebElement inputUsername = helper.waitAndFindElement(inputUsernameLocator, 20);
        inputUsername.sendKeys(username);
    }

    public void setPassword(String password){
        WebElement inputPassword = helper.waitAndFindElement(inputPasswordLocator, 20);
        inputPassword.sendKeys(password);
    }

    public void clickLogin(){
        WebElement btnLogin = helper.waitAndFindElement(btnLoginLocator, 20);
        btnLogin.click();
    }

    public String getTittle(){
        WebElement labelTittle = helper.waitAndFindElement(labelTittleLocator, 20);
        return labelTittle.getText();
    }

    public String getErrorLogin(){
        WebElement labelErrorLogin = helper.waitAndFindElement(labelErrorLoginLocator, 20);
        return labelErrorLogin.getText();
    }
}
