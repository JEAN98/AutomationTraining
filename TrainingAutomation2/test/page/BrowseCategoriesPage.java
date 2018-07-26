/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page;

import base.BasePage;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author jvega-as
 */
public class BrowseCategoriesPage extends BasePage{
    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl00_TopCategoryButton")
    private WebElement antiquesCollectibles;
    
    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl01_TopCategoryButton")
    private WebElement artsCrafts;
    
    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl02_TopCategoryButton")
    private WebElement auto;
    
    
    public BrowseCategoriesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
     /*Here we can save the main nodes at list*/
    private ArrayList<String> getLocatorListOnEachCategory(){
      ArrayList<String> locatorList = new ArrayList();
      locatorList.add("col_main_right");
      locatorList.add("nav_browse");
      locatorList.add("nav_header");
      locatorList.add("ctl00_Main_CategoryBrowser_TopCategoryList");
      locatorList.add("footer_nav");
      return locatorList; 
    }
    
    private boolean focusOnWithClick(WebElement element){
        if(hoverOver(element)){
            if(!locatorsLoadOnPage(getLocatorListOnEachCategory())){
                return false;
            }
        }
        return true;
    }
    
    public boolean focousOnWithClickAuto(){
       return focusOnWithClick(auto);
    }
    
    public boolean focousOnWithClickArtCrafts(){
       return focusOnWithClick(artsCrafts);
    }
    
    public boolean focousOnWithClickAntiquesCollectibles(){
       return focusOnWithClick(antiquesCollectibles);
    }
     
    private ArrayList<WebElement> getLocatorsOnBrowseCategories(){
       WebElement table = driver.findElement(By.id("ctl00_Main_CategoryBrowser_TopCategoryList"));
       return (ArrayList)table.findElements(By.tagName("a"));
    }
    
    public boolean loadBrowseCategories(){
        return locatorsLoadOnPage(getLocatorListOnEachCategory());
    }
}
