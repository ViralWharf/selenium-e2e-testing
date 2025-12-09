Feature: Login

  Scenario: Validar que un usuario pueda iniciar sesión correctamente con credenciales validas.
    Given El usuario ingresa a la pagina
    When El usuario ingresa sus credenciales
    Then El usuario hace login correctamente


  Scenario: Validar que el sistema muestre un mensaje de error cuando se ingresan credenciales incorrectas.
    Given El usuario ingresa a la pagina
    When El usuario ingresa unas credenciales incorrectas
    Then Se muestra un mensaje de error indicando credenciales invalidas
