package com.zero.autoz;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;


public class StartWebDriver {
    public static WebDriver driver;

    @BeforeSuite
    public static void startWebDriver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("http://192.168.1.137:5000/");
        System.out.println(driver.getTitle());
        driver.close();
    }

}
