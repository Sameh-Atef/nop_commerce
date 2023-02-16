package org.example.pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P03_homePage {
    public P03_homePage(){
        PageFactory.initElements(Hooks.driver,this);

    }
    @FindBy(id = "customerCurrency")
    public WebElement dropDown;

    public List<WebElement> productPrice(){
        return Hooks.driver.findElements(By.className("actual-price"));
    }
    @FindBy(name = "email")
    public WebElement e_mail;

    @FindBy(name = "pass")
    public WebElement password;

    @FindBy(name = "login")
    public WebElement login;

    @FindBy(id ="small-searchterms")
        public WebElement searchBox;

    public List<WebElement>searchResults(){
        return Hooks.driver.findElements(By.cssSelector("div[class = \"product-item\"]"));
    }

    @FindBy(className = "sku")
    public WebElement item;
    //locate main category tab
    public List<WebElement>mainCategories(){
        return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
    }
    //locate subCategories in each main category
    public List<WebElement>subCategories(int selectedCategory){
        return Hooks.driver.findElements(By.xpath("(//ul[@class=\"top-menu notmobile\"]//ul)["+selectedCategory+"]//li"));
    }
    // How to locate slider
    //
    public List<WebElement>slider(){
        return Hooks.driver.findElements(By.cssSelector("a[class=\"nivo-imageLink\"]"));
    }
    //locate facebook account
    @FindBy(how = How.LINK_TEXT,linkText = "Facebook")
    public WebElement facebookAccount;
    @FindBy(how = How.LINK_TEXT,linkText = "Twitter")
    public WebElement twitterAccount;
    // locate rss
    @FindBy(how = How.LINK_TEXT,linkText = "RSS")
    public WebElement rssAccount;

    // locate youtube link
    @FindBy(how = How.LINK_TEXT,linkText = "YouTube")
    public WebElement youtubeAccount;

    //locate withlist button
    public List<WebElement>wishList(){
        return Hooks.driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"] "));
    }

    //locate success message
@FindBy(how=How.XPATH,xpath = "//div[@class=\"bar-notification success\"]")
    public WebElement successmsg;

    //locate withlist tab
@FindBy(className = "ico-wishlist")
    public WebElement wishlistTab ;

}
