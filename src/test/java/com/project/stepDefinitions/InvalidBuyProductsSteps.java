package com.project.stepDefinitions;

import com.project.driver.DriverFactory;
import com.project.pageObjects.cartPO.CartPO;
import com.project.pageObjects.checkoutPO.CheckoutCompletePO;
import com.project.pageObjects.checkoutPO.CheckoutStepOnePO;
import com.project.pageObjects.checkoutPO.CheckoutStepTwoPO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class InvalidBuyProductsSteps {
    private WebDriver webDriver;
    private CheckoutStepOnePO checkoutStepOnePO;

    @Before
    public void setUp() {
        webDriver = DriverFactory.getDriver();
        checkoutStepOnePO = new CheckoutStepOnePO(webDriver);
    }

    @When("Deja la informacion personal en blanco")
    public void deja_la_informacion_personal_en_blanco(){
        checkoutStepOnePO.setFirstName("");
        checkoutStepOnePO.setLastName("");
        checkoutStepOnePO.setZip("");
        checkoutStepOnePO.clickContinue();
    }
    @Then("Se muestra un mensaje de error indicando que los campos deben ser completados")
    public void se_muestra_un_mensaje_de_error_indicando_que_los_campos_deben_ser_completados(){
        Assertions.assertEquals("Error: First Name is required", checkoutStepOnePO.getErrorMessage());
    }

    @After
    public void shutDown(){
        DriverFactory.quitDriver();
    }
}
