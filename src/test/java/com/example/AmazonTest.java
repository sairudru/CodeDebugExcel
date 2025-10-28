package com.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AmazonTest extends BasePage {

    public void amzonTest(String threadName) {
            try{
            driver.get("https://www.amazon.in/");
            System.out.println("Amazon URL Launched"+" in "+threadName);
            driver.findElement(By.xpath("//span[@id=\"nav-link-accountList-nav-line-1\"]")).click();
            System.out.println("Login Page link Clicked"+" in "+threadName);
            driver.findElement(By.xpath("//input[@id=\"ap_email\"]")).sendKeys("6281839366");
            System.out.println("Username/Mobile Number Entered"+" in "+threadName);
            driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();
            System.out.println("Continue button clicked"+" in "+threadName);
            driver.findElement(By.xpath("//input[@id=\"ap_password\"]")).sendKeys("Siri2909@");
            System.out.println("Password Entered"+" in "+threadName);
            driver.findElement(By.xpath("//input[@id=\"signInSubmit\"]")).click();
            Select s=new Select(driver.findElement(By.id("searchDropdownBox")));
            s.selectByValue("search-alias=beauty");

            System.out.println("Category Type Selected from DropDown"+" in "+threadName);
            driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("Foundation");
            driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]")).click();
            System.out.println("Search Button Clicked"+" in "+threadName);
//            String prodName=driver.findElement(By.xpath("(((//button[text()='Add to Cart'])[1]/ancestor::div)[14]/div)[2]//h2/a/span")).getText();
//            js.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//button[text()='Add to Cart'])[1]")));


            driver.findElement(By.xpath("(//button[text()='Add to Cart'])[1]")).click();
            String prodName=driver.findElement(By.xpath("(((//button[text()='Add to Cart'])[1]/ancestor::div)[14]/div)[2]//h2/a/span")).getText();
            driver.findElement(By.xpath("//div[@id=\"nav-cart-count-container\"]")).click();
            System.out.println("Goto Cart Page Link Clicked"+" in "+threadName);
            List<WebElement> elem= driver.findElements(By.xpath("//div[@class='sc-item-content-group']"));
            elem.stream().map(ele -> ele.toString()
                            .substring(0,ele.toString().length()-1).split("-> xpath: ")[1])
                    .forEach(a-> {
                            String str=a+"//span[@class=\"a-truncate-cut\"]";
                            if(driver.findElements(By.xpath(str)).size()!=0){
                                    if(driver.findElement(By.xpath(str)).getText().contains(prodName)){
                                        driver.findElement(By.xpath(a+"//input[@value='Delete']")).click();
                                        }}
                    });
            driver.findElement(By.xpath("//input[@name=\"proceedToRetailCheckout\"]")).click();
            System.out.println("Proceed to Checkout button clicked"+" in "+threadName);

           }catch (Exception r){
                   r.printStackTrace();
           }finally{
                   TakesScreenshot screenshot = (TakesScreenshot) driver;
                   File SrcFile=screenshot.getScreenshotAs(OutputType.FILE);
                   File DestFile=new File(System.getProperty("user.dir")+"/"+ LocalDateTime.now().toLocalTime().toString()+".png");
                   try{
                   FileUtils.copyFile(SrcFile,DestFile);}
                   catch (Exception e){
                           e.printStackTrace();
                   }
           }


    }
}
