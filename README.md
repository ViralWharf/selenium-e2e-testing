# Selenium E2E Testing Framework

Framework de automatización de pruebas End-to-End con **Selenium WebDriver**, **Cucumber BDD** y **Page Object Model**.

---

## Tecnologías

- **Java 17+** - Lenguaje de programación
- **Selenium WebDriver** - Automatización de navegadores
- **Cucumber** - Framework BDD
- **Maven** - Gestión de dependencias
- **JUnit** - Framework de testing

---

## Requisitos

- Java JDK 17+
- Maven 3.x+
- Google Chrome (última versión)

---

## Instalación
```
# Clonar repositorio
git clone https://github.com/ViralWharf/selenium-e2e-testing.git
cd selenium-e2e-testing

# Instalar dependencias
mvn clean install
```

---

## Estructura del Proyecto
```
src/test/
├── java/com/project
│   ├── driver/ 
│   ├── pageObjects/       
│   ├── runner/         
│   ├── StepDefinition/       
│   └── utils/         
│
└── resources/
    ├── config
    └── features/      
```

---

## Ejecución de Pruebas

### Ejecutar todas las pruebas
```
mvn clean test
```

### Ejecutar por tags
```
# Regression tests
mvn test -Dcucumber.filter.tags="@regression"
```

### Ejecutar un feature específico
```
mvn test -Dcucumber.features="src/test/resources/features/Login.feature"
```

---

## 📊 Reportes

Los reportes se generan automáticamente después de cada ejecución:
```
# Reportes HTML
target/cluecumber-report/index.html
```


