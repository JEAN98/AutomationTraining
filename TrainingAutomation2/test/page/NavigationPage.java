/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author jvega-as
 */
public class NavigationPage extends base.BasePage{
    @FindBy(id = "ctl00_LoginView_LoginLink")
    private WebElement loginLink;
    
    @FindBy(id = "ctl00_LoginView_RegisterLink")
    private WebElement registerLink;
    
    @FindBy(id = "ctl00_TopMenuRepeater_ctl00_MenuLink")
    private WebElement homeMenu;
    
    @FindBy(id = "ctl00_TopMenuRepeater_ctl01_MenuLink")
    private WebElement postanAdLink;
    
    @FindBy(id = "ctl00_TopMenuRepeater_ctl02_MenuLink")
    private WebElement myAdsProfile;
    
    public NavigationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public LoginPage goToLoginPage(){
        clickOnElement(loginLink);
       return new LoginPage(driver);
    }
    
    public BrowseCategoriesPage goToBrowseCategories(){
        return new BrowseCategoriesPage(driver);
    }
    
    public RegisterPage goToRegisterPage(){
        clickOnElement(registerLink);
        return new RegisterPage(driver);
    }
    
    public HomePage goToHomePage(){
        clickOnElement(homeMenu);
        return new HomePage(driver);
    }
    
    public PostAnAdPage goToPostAnAdPage(){
        clickOnElement(postanAdLink);
        return new PostAnAdPage(driver);
    }
    
    public MyAdsProfilePage goToMyAdsProfilePage(){
        clickOnElement(myAdsProfile);
        return new MyAdsProfilePage(driver);
    }
    
    
    
}
