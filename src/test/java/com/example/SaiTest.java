package sampleapi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class SaiTest {
    public static void main(String[] args) {

        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","/Users/rudrkrishna/IntelliJ Projects/JavaPractice/src/main/resources/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        driver.findElement(By.xpath("//span[@id=\"nav-link-accountList-nav-line-1\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"ap_email\"]")).sendKeys("6281839366");
        driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"ap_password\"]")).sendKeys("Siri2909@");
        driver.findElement(By.xpath("//input[@id=\"signInSubmit\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("Fridge");
        driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]")).click();

        driver.findElement(By.xpath("//button[text()=\"Add to Cart\"]")).click();
        driver.findElement(By.xpath("//div[@id=\"nav-cart-count-container\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"proceedToRetailCheckout\"]")).click();

        driver.quit();


    }

}
