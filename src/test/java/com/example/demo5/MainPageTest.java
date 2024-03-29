package com.example.demo1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.habr.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void changeLogTest() {

        WebElement rulesLink = driver.findElement(By.xpath("//*[contains(text(), 'Как стать автором')]"));
        rulesLink.click();
        WebElement authorsLink = driver.findElement(By.xpath("//*[contains(text(), 'Авторы')]"));
        authorsLink.click();

        assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Статистика')]")).isDisplayed(),"Статистика не найдена");
    }

    @Test
    public void changeTest() {

        WebElement news = driver.findElement(By.xpath("//*[contains(text(), 'Новости')]"));
        news.click();

        WebElement blog = driver.findElement(By.xpath("//*[contains(text(), 'Лучшие блоги')]"));
        blog.click();

        assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Истории')]")).isDisplayed(),"Истории не найдены");
    }
}

