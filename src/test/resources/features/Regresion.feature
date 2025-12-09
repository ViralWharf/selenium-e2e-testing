@regression
Feature: Pruebas de regresion

  Background:
    Given El usuario ingresa a la pagina
    And El usuario inicia sesion
    And Agrega productos al carrito

  Scenario: Validar el happy path completo
    Given El usuario da click en Checkout
    When Ingresa su informacion personal
    Then Finaliza la compra correctamente

