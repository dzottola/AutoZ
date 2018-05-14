package com.zero.autoz;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class Test2 extends StartWebDriver {

    @FindBy(how = How.ID, using = "user")
    static WebElement userTextBox;

    @FindBy(how = How.ID, using = "password")
    static WebElement passwordTextBox;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    static WebElement buttonSubmit;

    @Test
    public void test1() throws InterruptedException {
        System.out.println("chan");
        PageFactory.initElements(driver, this);
        System.out.println(driver.getTitle());
        Thread.sleep(10000);

        //Test
        userTextBox.sendKeys("User");
        passwordTextBox.sendKeys("fakepass");
        buttonSubmit.click();
    }

}
