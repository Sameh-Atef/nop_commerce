package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Locale;

public class D08_WishlistStepDe {

    WebDriverWait wait = new WebDriverWait(Hooks.driver,
            Duration.ofSeconds(4));
    P03_homePage homePage = new P03_homePage();
    SoftAssert soft = new SoftAssert();
    @When("User click wishlist button")
    public void user_click_wishlist_button() throws InterruptedException {
        homePage.wishList().get(2).click();
        System.out.println("withlist button Text:" + homePage.wishList().get(2).getText());
        Thread.sleep(2000);


    }
    @Then("Success msg appear and background is green")
    public void success_msg_appear() {
        String actualmsg=homePage.successmsg.getText();
        String expectmsg = "The product has been added to your wishlist";
        soft.assertTrue(actualmsg.toLowerCase().contains(expectmsg.toLowerCase()));
        //String actualBackgroundcolor = homePage.successmsg.getCssValue("background-color");
        String actualBackgroundcolor = Color.fromString(homePage.successmsg.getCssValue("background-color")).asHex();
        String expectedBackgroundcolor = "#4bb07a";
        soft.assertTrue(actualBackgroundcolor.contains(expectedBackgroundcolor));


    }

    @And("Wait until sccessmsg disappear then click wishListtab")
    public void waitUntilSccessmsgDisappearThenClickWishListtab() {
        wait.until(ExpectedConditions.invisibilityOf(homePage.successmsg));
        homePage.wishlistTab.click();

    }

    @And("Quantity value should be more than one")
    public void quantityValueShouldBeMoreThanOne() {
        String value= Hooks.driver.findElement(By.cssSelector("input[class=\"qty-input\"]")).getAttribute("value");
        soft.assertTrue( Integer.parseInt(value)>0);

    }
}
