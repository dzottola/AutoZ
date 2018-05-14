package com.zero.autoz;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test1 extends StartWebDriver{

    @FindBy(how = How.ID, using = "a")
    static WebElement catsButton;

    @FindBy(how = How.ID, using = "hostname")
    static WebElement hostnameText;



    @Test
    public void test1() throws InterruptedException {
        System.out.println("chan");
        PageFactory.initElements(driver, this);
        System.out.println(driver.getTitle());
        Thread.sleep(10000);

        //Test
        catsButton.click();
        driver.getCurrentUrl();
        driver.getTitle();
        Assert.assertTrue(hostnameText.isDisplayed());

    }

}
