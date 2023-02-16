package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_Login;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D02_LoginStepDefs {
    P02_Login login = new P02_Login();
    @Given("user go to login page")
    public void user_go_to_login_page() {
        login.loginBtn.click();


    }
    @When("user login with {string} {string} and {string}")
    public void user_login_with_and( String valid, String email , String password) {
        login.email_add.sendKeys(email);
        login.password.sendKeys(password);


    }
    @And("user press on login button")
    public void user_press_on_login_button() {
        login.submit.click();

    }
    @Then("user login to the system successfully")
    public void user_login_to_the_system_successfully() {
        SoftAssert soft = new SoftAssert();
        String actualUrl = Hooks.driver.getCurrentUrl();
        String expectedUrl = "https://demo.nopcommerce.com/";
        soft.assertEquals(actualUrl,expectedUrl);
        soft.assertTrue(login.myAccount.isDisplayed());
        soft.assertAll();


    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        SoftAssert soft = new SoftAssert();
        String acutalText = login.errormsg.getText();
        String expectedText = "Login was unsuccessful. Please correct the errors and try again.";
        soft.assertTrue(acutalText.contains(expectedText));
        String rgbColor=login.errormsg.getCssValue("color");
        soft.assertTrue(Color.fromString(rgbColor).asHex().contains("#e4434b"));
        soft.assertAll();

    }
}
