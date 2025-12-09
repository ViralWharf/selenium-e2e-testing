package com.project.stepDefinitions;

import com.project.driver.DriverFactory;
import com.project.pageObjects.inventoryPO.InventoryPO;
import com.project.pageObjects.loginPO.LoginPO;
import com.project.utils.Constants_Vars;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AddProductsSteps {
    private WebDriver webDriver;
    private LoginPO loginPO;
    private InventoryPO inventoryPO;

    @Before
    public void setUp() {
        webDriver = DriverFactory.getDriver();
        loginPO = new LoginPO(webDriver);
        inventoryPO = new InventoryPO(webDriver);
    }

    @Given("El usuario inicia sesion")
    public void el_usuario_inicia_sesion(){
        loginPO.setPassword(Constants_Vars.PASSWORD);
        loginPO.setUsername(Constants_Vars.USER);
        loginPO.clickLogin();
    }
    @When("Agrega productos al carrito")
    public void agrega_productos_al_carrito(){
        inventoryPO.clickAddBackpack();
        inventoryPO.clickAddBikeLight();
        Assertions.assertEquals("Sauce Labs Backpack", inventoryPO.getTittleBackpack());
        Assertions.assertEquals("$29.99", inventoryPO.getPriceBackpack());
        inventoryPO.clickCart();
    }
    @Then("El producto se muestra correctamente en el carrito")
    public void el_producto_se_muestra_correctamente_en_el_carrito(){
        Assertions.assertEquals("Sauce Labs Backpack", inventoryPO.getTittleBackpack());
        Assertions.assertEquals("$29.99", inventoryPO.getPriceBackpack());
    }

    @After
    public void shutDown(){
        DriverFactory.quitDriver();
    }
}
