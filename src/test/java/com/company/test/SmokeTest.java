package com.company.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmokeTest {
    WebDriver driver;

    @Test
    public void SmokeTest1(){
        Boolean bool = false;
        WebElement submit = driver.findElement(By.xpath(""));
        submit.getText();

       By submit1 =  By.id("login");

    }
}
