package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_currenciesStepDef {
    P03_homePage homepage = new P03_homePage();
    @When("User Select Eru")
    public void user_select_eru() {
        Select dropdown = new Select(homepage.dropDown);
        dropdown.selectByVisibleText("Euro");
    }
    @Then("All currencies change to ERU")
    public void all_currencies_change_to_eru() {
        for(WebElement product: homepage.productPrice()){
            Assert.assertTrue(product.getText().contains("€"));
        }


    }
}
