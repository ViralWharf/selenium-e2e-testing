Feature: Comprar Productos

  Background:
    Given El usuario ingresa a la pagina
    And El usuario inicia sesion
    And Agrega productos al carrito

  Scenario: Validar que un producto pueda ser agregado correctamente al carrito de compras.
    Given El usuario da click en Checkout
    When Ingresa su informacion personal
    Then Finaliza la compra correctamente

  Scenario: Validar que el sistema no permita continuar con el proceso de compra cuando no se ingresan los datos obligatorios del formulario de checkout.
    Given El usuario da click en Checkout
    When Deja la informacion personal en blanco
    Then Se muestra un mensaje de error indicando que los campos deben ser completados

