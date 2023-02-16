package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Register;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_RegStepDefs {
    P01_Register link= new P01_Register();
    @Given("User go to register page")
    public void user_go_to_register_page() {
        link.registerLink.click();

    }

    @When("User select gender")
    public void userSelectGender() {
        link.gender_male.click();
    }

    @And("User Enter {string} & {string}")
    public void userEnter(String firstName, String lastName) {
        link.firstName.sendKeys(firstName);
        link.lastName.sendKeys(lastName);

    }

    @And("User Select BOD")
    public void userSelectBOD() {
        //select day
        Select selectDay = new Select(link.DOB);
        selectDay.selectByValue("5");
        //select month
        Select selectMonth = new Select(link.MOB);
        selectMonth.selectByValue("5");
        //select year
        Select selectYear = new Select(link.YOB);
        selectYear.selectByValue("2000");


    }



    @And("User Enter email {string}")
    public void userEnter(String e_mail) {
        /*Faker fake = new Faker();
        String e_mail=fake.internet().safeEmailAddress();*/
        System.out.println("Email: "+e_mail);
        link.email.sendKeys(e_mail);
    }

    @And("User Enter password and confirm password {string}")
    public void userEnterAndConfirmPassword(String pass) {
       /* Faker fake = new Faker();
        String pass=fake.internet().password();*/
        System.out.println("Password: "+pass);
        link.password.sendKeys(pass);
        link.confirmPassword.sendKeys(pass);
    }

    @And("User click Register button")
    public void userClickRegisterButton() {
        link.regButton.click();
    }

    @Then("Account is created successfully")
    public void accountIsCreatedSuccessfully() {
        SoftAssert soft = new SoftAssert();
        // get text and verify it contains text " Your registration completed"
        String text = link.result.getText();
        soft.assertTrue(text.contains("Your registration completed"));
        // get color and verify it #4cb17c

        String color =link.result.getCssValue("color");
        soft.assertEquals(Color.fromString(color).asHex(),"#4cb17c");;


        soft.assertAll();
    }


}
