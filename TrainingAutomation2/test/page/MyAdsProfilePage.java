/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page;

import base.BasePage;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author jvega-as
 */
public class MyAdsProfilePage extends BasePage{
    @FindBy(id = "ctl00_TopMenuRepeater_ctl02_MenuLink")
    private WebElement myAdsProfile;
     
    public MyAdsProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    private ArrayList<String> getMainLocatorsListUserNotLogged(){
        ArrayList<String> locatorList = new ArrayList<>();
        locatorList.add("ctl00_Main_ProtectedPageRegisterLink");
        locatorList.add("ctl00_Main_LoginConrol_LoginButton");
        locatorList.add("ctl00_Main_AccessNoticePanel");
        locatorList.add("ctl00_Main_RegisterLink");
        locatorList.add("user_assistance");
        return locatorList;
    } 
    
    private ArrayList<String> getMainLocatorsListUserLogged(){
        ArrayList<String> locatorList = new ArrayList<>();
        locatorList.add("search_n_no_browse");
        locatorList.add("content_header");
        locatorList.add("ctl00_Main_CurrentAdsGrid");
        locatorList.add("footer_nav");
        locatorList.add("ctl00_Main_AdvancedSearchLink");
        return locatorList;
    }
    
    public boolean loadMyAdsProfileUserLogged(){
        LoginPage loginPage = new LoginPage(driver);
        boolean loginFailed = false;
        if(loginPage.sendValidCredentials()){
            clickOnElement(myAdsProfile);
            return locatorsLoadOnPage(getMainLocatorsListUserLogged());
        }
        return true;
    }
   
    public boolean loadMyAdsProfileUserNotLogged(){
        clickOnElement(myAdsProfile);
        return locatorsLoadOnPage(getMainLocatorsListUserNotLogged());
    }
    
   
}
