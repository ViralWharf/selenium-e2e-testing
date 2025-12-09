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

public class BuyProductsSteps {
    private WebDriver webDriver;
    private CartPO cartPO;
    private CheckoutStepOnePO checkoutStepOnePO;
    private CheckoutStepTwoPO checkoutStepTwoPO;
    private CheckoutCompletePO checkoutCompletePO;

    @Before
    public void setUp() {
    webDriver = DriverFactory.getDriver();
    cartPO = new CartPO(webDriver);
    checkoutStepOnePO = new CheckoutStepOnePO(webDriver);
    checkoutStepTwoPO = new CheckoutStepTwoPO(webDriver);
    checkoutCompletePO = new CheckoutCompletePO(webDriver);
}

    @When("El usuario da click en Checkout")
    public void el_usuario_da_click_en_checkout(){
        cartPO.clickCheckout();
    }
    @When("Ingresa su informacion personal")
    public void ingresa_su_informacion_personal(){
        checkoutStepOnePO.setFirstName("Nombre Prueba");
        checkoutStepOnePO.setLastName("Apellido Prueba");
        checkoutStepOnePO.setZip("110111");
        checkoutStepOnePO.clickContinue();
    }
    @Then("Finaliza la compra correctamente")
    public void el_producto_se_muestra_correctamente_en_el_carrito(){
        checkoutStepTwoPO.clickFinish();
        Assertions.assertEquals("Thank you for your order!", checkoutCompletePO.getTittleMessage());
        Assertions.assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!", checkoutCompletePO.getCompleteMessage());
    }

    @After
    public void shutDown(){
        DriverFactory.quitDriver();
    }
}
