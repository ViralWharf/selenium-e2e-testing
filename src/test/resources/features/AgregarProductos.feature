Feature: Agregar productos al carrito

  Background:
    Given El usuario ingresa a la pagina

  Scenario: Validar que un producto pueda ser agregado correctamente al carrito de compras.
    Given El usuario inicia sesion
    When Agrega productos al carrito
    Then El producto se muestra correctamente en el carrito
