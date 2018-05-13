package com.zero.autoz;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class StartWebDriver {
    static WebDriver driver;

    @FindBy(how = How.ID, using = "user")
    static WebElement userTextBox;

    @FindBy(how = How.ID, using = "password")
    static WebElement passwordTextBox;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    static WebElement buttonSubmit;

    @Test
    public void startWebDriver() throws InterruptedException {


        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("http://localhost:8000/#!/login");
        PageFactory.initElements(driver, this);

        System.out.println(driver.getTitle());
        Thread.sleep(10000);

        //Test
        userTextBox.sendKeys("User");
        passwordTextBox.sendKeys("fakepass");
        buttonSubmit.click();
    }

    @AfterMethod
    public void endTests() {
        try {
            driver.close();
            driver.quit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
