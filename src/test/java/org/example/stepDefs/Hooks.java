package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver = null;
    @Before
    public static void openBrowser(){
        //Bridge between code and webDriver using maven dependency
        WebDriverManager.chromedriver().setup();
        // create new object from chromedriver
        driver = new ChromeDriver();
        //configuration
        driver.manage().window().maximize();
        // set implicit wati
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //navigate to website: "https://demo.nopcommerce.com/"
        driver.get("https://demo.nopcommerce.com/");



    }
    @After
    public static void quitBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
}
