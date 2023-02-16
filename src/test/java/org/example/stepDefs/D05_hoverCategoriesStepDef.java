package org.example.stepDefs;

import com.beust.ah.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class D05_hoverCategoriesStepDef {
    P03_homePage category = new P03_homePage();
    Actions actions=new Actions(Hooks.driver);
    private int selectedCategory;
    private void setSelectedCategory(int selectedCategory){
        this.selectedCategory=2;
    }
    private int getSelectedCategory(){
        return this.selectedCategory;
    }
    private int selectedSubCategory;
    private void setselectedSubCategory(int selectedSubCategory){
        this.selectedSubCategory=selectedSubCategory;
    }
    private int getSelectedSubCategory(){
        return selectedSubCategory;
    }

    @When("Select one of main categories")
    public void select_one_of_main_categories() throws InterruptedException {
        int count = category.mainCategories().size();
        int min = 0;
        int max = count-1;
        int selectedCategory = (int)Math.floor(Math.random()*(max-min+1)+min);
        selectedCategory = selectedCategory+1;
        setSelectedCategory(selectedCategory);
        // minimize implicit wait to not waste time if it's empty

    }

    @And("Hover on the Selected")
    public void hover_on_the_selected() {
        actions.moveToElement(category.mainCategories().get(getSelectedCategory())).perform();
        String selectedCategoryText = category.mainCategories().get(selectedCategory).getText();
        System.out.println("selected Category "+ getSelectedCategory());
        System.out.println("select Category name" + selectedCategoryText);
    }

    @And("Select one of sub-categories & get Text & click on it")
    public void select_one_of_sub_categories_get_text_click_on_it() {
        System.out.println("+++++++++++++++++++++++++++++++++++++");
    List<WebElement>subCategories = category.subCategories((getSelectedCategory()+1));
        Hooks.driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        if(!subCategories.isEmpty()) {
            int Count = subCategories.size();
            int max = Count-1;
            int min = 0;
            System.out.println(subCategories.get(0).getText());
            System.out.println(subCategories.get(1).getText());
            System.out.println(subCategories.get(2).getText());
            System.out.println("profile links " + Count);
            int selectedSubCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
            String randomtxt = subCategories.get(selectedSubCategory).getText().toLowerCase().trim();
            subCategories.get(selectedSubCategory).click();
            System.out.println("random "+ selectedSubCategory);
            String acutaltxt = Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"] h1")).getText();
            //String acutaltxt = "clothes";
            System.out.println("acutaltxt: "+acutaltxt);
            System.out.println("randomtxt: "+randomtxt);

            Assert.assertTrue(acutaltxt.toLowerCase().trim().contains(randomtxt));

        }
        else
        {
            category.mainCategories().get(getSelectedCategory()).click();
            // Do your assertion on selected main category
        }

    }



}
