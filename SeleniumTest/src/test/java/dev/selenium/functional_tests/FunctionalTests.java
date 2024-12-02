package dev.selenium.functional_tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

public class FunctionalTests {
    private static WebDriver driver;

    @Test
    public void testHomePageLoads() {
        // Configurar el controlador de Chrome
        System.setProperty("webdriver.chrome.driver", "C:/SeleniumDrivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        try {
            driver.get("http://localhost:8081/");
            WebElement header = driver.findElement(By.tagName("h1"));
            assertTrue(header.getText().contains("BIBLIOHUB"), "La página principal no contiene el texto esperado.");
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testAddBook() {
        // Configurar el controlador de Chrome
        System.setProperty("webdriver.chrome.driver", "C:/SeleniumDrivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        try {
            driver.get("http://localhost:8081/Libros/new");

            // Completar los campos del formulario
            driver.findElement(By.id("title")).sendKeys("Libro Selenium");
            driver.findElement(By.id("description")).sendKeys("Descripción funcional");
            driver.findElement(By.id("level")).sendKeys("5");
            driver.findElement(By.id("published")).click();
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            // Verificar el mensaje de éxito
            WebElement successMessage = driver.findElement(By.className("alert-success"));
            assertTrue(successMessage.getText().contains("guardado"), "El libro no fue agregado correctamente.");
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testViewBookList() {
        // Configurar el controlador de Chrome
        System.setProperty("webdriver.chrome.driver", "C:/SeleniumDrivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        try {
            driver.get("http://localhost:8081/Libros");

            // Esperar a que la tabla sea visible en la página
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table")));

            // Interactuar con la tabla (por ejemplo, verificar que contiene filas)
            assertTrue(table.isDisplayed(), "La tabla no se muestra correctamente.");
        } finally {
            driver.quit();
        }
    }

}
