package com.project.stepDefinitions;

import com.project.pageObjects.loginPO.LoginPO;
import com.project.utils.Config;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.project.driver.DriverFactory;
import com.project.utils.Constants_Vars;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class LoginSteps {
    private WebDriver webDriver;
    private LoginPO loginPO;

    @Before
    public void setUp() {
        webDriver = DriverFactory.getDriver();
        loginPO = new LoginPO(webDriver);
    }

    @Given("El usuario ingresa a la pagina")
    public void el_usuario_ingresa_a_la_pagina() {
        webDriver.get(Config.get("base.url"));
        Assertions.assertEquals("Swag Labs", loginPO.getTittle());
    }
    @When("El usuario ingresa sus credenciales")
    public void el_usuario_ingresa_sus_credenciales(){
        loginPO.setPassword(Constants_Vars.PASSWORD);
        loginPO.setUsername(Constants_Vars.USER);
    }
    @Then("El usuario hace login correctamente")
    public void el_usuario_hace_login_correctamente(){
        loginPO.clickLogin();
    }

    @After
    public void shutDown(){
        DriverFactory.quitDriver();
    }
}
