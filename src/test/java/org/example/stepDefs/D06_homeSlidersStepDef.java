package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Locale;

public class D06_homeSlidersStepDef {
    P03_homePage slide = new P03_homePage();
    SoftAssert soft = new SoftAssert();
    @When("click on first slider")
    public void click_on_first_slider() throws InterruptedException {
        // get nokia image
        WebElement test =slide.slider().get(1);
        Thread.sleep(1000);
        test.click();
        Thread.sleep(1000);


    }
    @Then("direct user to this NokiaLumia1020 site")
    public void direct_user_to_this_nokia_lumia1020_site() {
        String currentUrl = Hooks.driver.getCurrentUrl();
        String expectedUrl = "https://demo.nopcommerce.com/nokia-lumia-1020";
        soft.assertTrue(currentUrl.toLowerCase().contains(expectedUrl.toLowerCase()));
        soft.assertAll();


    }

    @When("click on Second slider")
    public void clickOnSecondSlider() throws InterruptedException {
        Thread.sleep(1000);
        slide.slider().get(1).click();

    }

    @Then("direct user to iphone site")
    public void directUserToIphoneSite() {
        String currentUrl = Hooks.driver.getCurrentUrl();
        String expectedUrl = "https://demo.nopcommerce.com/iphone-6";
        soft.assertTrue(currentUrl.toLowerCase().contains(expectedUrl.toLowerCase()));
        soft.assertAll();
    }
}
