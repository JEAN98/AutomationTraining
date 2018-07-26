/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author jvega-as
 */
public class HomePage extends base.BasePage {
    
    @FindBy(id = "ctl00_TopMenuRepeater_ctl00_MenuLink")
    private WebElement navHomeMenu;
    
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public boolean loadPageHome(){
        return locatorsLoadOnPage(getLocatorMainListByID());
    }
    
    /*In this method we can get main tags and then we can save it at list*/
    private ArrayList<String> getLocatorMainListByID(){
        ArrayList<String> currentList = new ArrayList<>();
        currentList.add("ctl00_Main_CategoryBrowser_TopCategoryList_ctl01_NestedSubCategoryRepeater_ctl01_SubCategoryButton");
        currentList.add("nav_header");
        currentList.add("color_bar");
        currentList.add("footer_nav");
        currentList.add("title");
        currentList.add("ctl00_Main_CategoryBrowser_TopCategoryList");
        return  currentList;
    }
    
    public boolean loadPageHomeByClickNavMenu(){
        navHomeMenu.click();
        return loadPageHome();
    }
    
}
