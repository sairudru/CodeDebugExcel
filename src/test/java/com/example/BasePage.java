package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {

    WebDriver driver;
    JavascriptExecutor js;

    public WebDriver setUp(String browser){
        WebDriverManager.chromedriver().setup();
           // System.setProperty("webdriver.chrome.driver","/Users/rudrkrishna/IntelliJ Projects/JavaPractice/src/main/resources/chromedriver");
        driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
         js = (JavascriptExecutor) driver;
         return driver;
    }

    public void tearDown(){
        driver.quit();
    }
}
