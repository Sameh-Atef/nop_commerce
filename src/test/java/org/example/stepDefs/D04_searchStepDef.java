package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D04_searchStepDef {
    P03_homePage facebookLogin = new P03_homePage();
    @Given("user navigates to Facebook")
    public void user_navigates_to_facebook() {
        Hooks.driver.navigate().to("https://www.facebook.com/");

    }
    @When("I enter Username as {string} and Password as {string}")
    public void i_enter_username_as_and_password_as(String string, String string2) {
        facebookLogin.e_mail.sendKeys(string);
        facebookLogin.password.sendKeys(string2);
        facebookLogin.login.click();


    }
    @Then("login should be unsuccessful")
    public void login_should_be_unsuccessful() {
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://www.facebook.com/login/"));

    }

P03_homePage SearchFeature = new P03_homePage();
    @When("User select search & write {string}")
    public void userSelectSearchWrite(String arg0) {
        SearchFeature.searchBox.sendKeys(arg0);
        SearchFeature.searchBox.sendKeys(Keys.ENTER);

    }


    @Then("URL change")
    public void urlChange() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().toLowerCase().contains("https://demo.nopcommerce.com/search?q"));
        soft.assertAll();
    }

    @And("Search Show relevents results for {string}")
    public void searchShowReleventsResults(String productName) {

        SoftAssert soft = new SoftAssert();
        List<WebElement> resutl = SearchFeature.searchResults();
        System.out.println("size of resutl "+resutl.size());

        for (WebElement product : resutl){
            soft.assertTrue(product.getText().toLowerCase().contains(productName));
            System.out.println("product title "+ product.getText());
        }
        soft.assertAll();


    }

    @And("click in each relative result {string} verify that sku is the same")
    public void clickInEachRelativeResult(String suk) {
        List<WebElement> result = SearchFeature.searchResults();
        SoftAssert soft = new SoftAssert();
        for(WebElement ignored :result){
            ignored.click();
            System.out.println("sku: "+SearchFeature.item.getText());
            soft.assertTrue(SearchFeature.item.getText().contains(suk));
            Hooks.driver.navigate().back();
        }
        soft.assertAll();


    }


}
