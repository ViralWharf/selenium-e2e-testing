package com.project.stepDefinitions;

import com.project.driver.DriverFactory;
import com.project.pageObjects.loginPO.LoginPO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class InvalidLoginSteps {
    private WebDriver webDriver;
    private LoginPO loginPO;

    @Before
    public void setUp() {
        webDriver = DriverFactory.getDriver();
        loginPO = new LoginPO(webDriver);
    }

    @When("El usuario ingresa unas credenciales incorrectas")
    public void el_usuario_ingresa_unas_credenciales_incorrectas(){
        loginPO.setPassword("invalid_user");
        loginPO.setUsername("invalid_password");
    }
    @Then("Se muestra un mensaje de error indicando credenciales invalidas")
    public void se_muestra_un_mensaje_de_error_indicando_credenciales_invalidas(){
        Assertions.assertEquals("Swag Labs", loginPO.getTittle());
        loginPO.clickLogin();
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", loginPO.getErrorLogin());
    }

    @After
    public void shutDown(){
        DriverFactory.quitDriver();
    }
}
