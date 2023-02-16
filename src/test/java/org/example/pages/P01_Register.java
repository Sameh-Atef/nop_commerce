package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class P01_Register {
    public P01_Register(){
        PageFactory.initElements(Hooks.driver,this);
    }
    @FindBy(className = "ico-register")
    public WebElement registerLink;
    @FindBy(id="gender-male")
    public WebElement gender_male;

    @FindBy(id = "FirstName")
    public WebElement firstName;
    @FindBy(id = "LastName")
    public WebElement lastName;
    @FindBy(name = "DateOfBirthDay")
    public WebElement DOB;
    @FindBy(name="DateOfBirthYear")
    public WebElement YOB;
    @FindBy(name = "DateOfBirthMonth")
    public WebElement MOB;
    @FindBy(id = "Email")
    public WebElement email;
    @FindBy(id="Password")
    public WebElement password;
    @FindBy(id= "ConfirmPassword")
    public WebElement confirmPassword;
    @FindAll({
            @FindBy(id = "register-button"),
            @FindBy(name = "register-button")




    })
    public WebElement regButton;
    @FindBy(how = How.CLASS_NAME,className = "result")
    public WebElement result;


}
