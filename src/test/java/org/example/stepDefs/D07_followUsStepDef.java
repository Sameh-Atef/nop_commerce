package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Locale;

public class D07_followUsStepDef {
    P03_homePage followUs = new P03_homePage();
    //WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
    SoftAssert soft = new SoftAssert();


    @When("user opens facebook link")
    public void user_opens_facebook_link() {
        followUs.facebookAccount.click();
        //wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        //System.out.println(tabs.size());


    }
    @Then("Facebook is opened in new tab")
    public void facebook_is_opened_in_new_tab() throws InterruptedException {
        handleWindow();
        String actualUrl = getCurrentUrl();
        String expectedUrl = "https://www.facebook.com/nopCommerce";
        System.out.println("Current URL is: "+actualUrl);
        //soft.assertTrue(actualUrl.toLowerCase().contains(expectedUrl.toLowerCase()));
        Assert.assertEquals(actualUrl.toLowerCase(),expectedUrl.toLowerCase());



    }
    @When("user opens twitter link")
    public void user_opens_twitter_link() {
        followUs.twitterAccount.click();

    }
    @Then("Twitter is opened in new tab")
    public void twitter_is_opened_in_new_tab() throws InterruptedException {
    handleWindow();
    String expectedUrl = "https://twitter.com/nopCommerce";
        soft.assertTrue(getCurrentUrl().toLowerCase().contains(expectedUrl.toLowerCase()));

    }
    @When("user opens rss link")
    public void user_opens_rss_link() {
        followUs.rssAccount.click();

    }
    @Then("Store is opened in new tab")
    public void store_is_opened_in_new_tab() throws InterruptedException {
        handleWindow();
        String expectedUrl = "https://demo.nopcommerce.com/new-online-store-is-open";
        soft.assertTrue(getCurrentUrl().toLowerCase().contains(expectedUrl));

    }
    @When("user opens youtube link")
    public void user_opens_youtube_link() {
        followUs.youtubeAccount.click();

    }
    @Then("Youtube is opened in new tab")
    public void youtube_is_opened_in_new_tab() throws InterruptedException {
        handleWindow();
        String expectedUrl = "https://www.youtube.com/user/nopCommerce";
        soft.assertTrue(getCurrentUrl().toLowerCase().contains(expectedUrl));
    }
    private void handleWindow() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //2- get window list inside array

        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        //4- switch from tab 1 to tab 0
        Hooks.driver.switchTo().window(tabs.get(0));
        System.out.println("tab 0:  " + Hooks.driver.getCurrentUrl());
        Thread.sleep(2000);
        //3- switch from tab 0 to tab 1
        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1:  " +Hooks.driver.getCurrentUrl());
        String url = Hooks.driver.getCurrentUrl();
        setcurrentUrl(url);

        //Difference between driver.quit() and driver.close()

        //reload
        tabs = new ArrayList<>(Hooks.driver.getWindowHandles());


    }private String currentUrl;
    private void setcurrentUrl(String url){
        this.currentUrl=url;
    }
    private String getCurrentUrl(){
        return this.currentUrl;
    }

}
