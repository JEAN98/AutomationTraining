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
public class PostAnAdPage extends BasePage{
    @FindBy(id = "ctl00_TopMenuRepeater_ctl01_MenuLink")
    private WebElement postAndAdElement;
    public PostAnAdPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    private ArrayList<String> getMainLocatorsListUserLogged(){
        ArrayList<String> locatorList = new ArrayList<>();
        locatorList.add("ctl00_Main_PostAdWizard");
        locatorList.add("user_assistance");
        locatorList.add("ctl00_Main_PostAdWizard_StartNavigationTemplateContainerID_StartNextButton");
        locatorList.add("ctl00_Main_PostAdWizard_CategoryPath_AllCategoriesButton");
        locatorList.add("footer_nav");
        return locatorList;
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
    
    public boolean loadPostAnAdPageUserLogged(){
       LoginPage loginPage = new LoginPage(driver);
       boolean loginFailed = false;
       if(loginPage.sendValidCredentials()){
           clickOnElement(postAndAdElement);
           return locatorsLoadOnPage(getMainLocatorsListUserLogged());
        }
       return loginFailed;
    }
    
    public boolean loadPostAnAdPageUserNotLogged(){
       clickOnElement(postAndAdElement);
       return locatorsLoadOnPage(getMainLocatorsListUserNotLogged());
    }
}
