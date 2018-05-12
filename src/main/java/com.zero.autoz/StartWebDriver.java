package com.zero.autoz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class StartWebDriver {

    @Test
    public void startWebDriver() {
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://google.com");
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().startsWith("Goo"), "deberia estar en google.");
    }
}
