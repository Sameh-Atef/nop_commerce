package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class P02_Login {
    public P02_Login(){
        PageFactory.initElements(Hooks.driver,this);
    }
    @FindBy(className = "ico-login")
    public WebElement loginBtn;

    @FindBy(id = "Email")
    public WebElement email_add;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(how = How.XPATH,xpath = "//button[@class=\"button-1 login-button\"]")
    public WebElement submit;

    @FindBy(className = "ico-account")
    public WebElement myAccount;

    @FindBy(how = How.XPATH ,xpath = "//div[@class = \"message-error validation-summary-errors\"]")
    public WebElement errormsg;



}
