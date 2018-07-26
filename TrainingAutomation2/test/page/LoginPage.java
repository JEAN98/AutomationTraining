/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page;

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
public class LoginPage extends base.BasePage{
    @FindBy(id = "ctl00_Main_LoginConrol_UserName")
    private WebElement userNameElement;
    
    @FindBy(id = "ctl00_Main_LoginConrol_Password")
    private WebElement userPasswordElement;
    
    @FindBy(id = "ctl00_Main_LoginConrol_LoginButton")
    private WebElement userLoginBtnElement;
            
    
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    

     private ArrayList<String> getLocatorList(){
        ArrayList<String> tagList = new ArrayList<>();
        tagList.add("ctl00_Main_LoginConrol");
        tagList.add("user_assistance");
        tagList.add("color_bar");
        tagList.add("ctl00_Main_LoginConrol_LoginButton");
        tagList.add("ctl00_Main_LoginConrol_RememberMe");
        tagList.add("ctl00_Main_ForgotPasswordButton");
        tagList.add("footer_nav");
        return tagList;
    }
    
    public void clickNodeLogin(){
       clickSpecificNodeByID("ctl00_LoginView_LoginLink");
    }
    
    public boolean verifyPageLoadLogin(){
        return locatorsLoadOnPage(getLocatorList());
    }
    
    public void clickNodeLogout(){
        clickSpecificNodeByID("ctl00_LoginView_MemberLoginStatus");
    }
    
    public boolean  sendValidCredentials(){
        String userName = "jeanvega";
        boolean typeOnElementFaild = false;
        if(!typeOnElement(userNameElement, userName))
            return typeOnElementFaild;
        if(!typeOnElement(userPasswordElement, "1234567890AB-"))
            return typeOnElementFaild;
        
        if(clickOnElement(userLoginBtnElement)){
             return driver.findElement(By.id("ctl00_LoginView_MemberName")).getText().equals(userName);
        }
        return false;
    }
    
    public boolean sendCredentials(String username, String password){
        typeOnElement(userNameElement, username);
        typeOnElement(userPasswordElement, password);
        
        if(clickOnElement(userLoginBtnElement)){
             return driver.findElement(By.id("ctl00_LoginView_MemberName")).getText().equals(username);
        }
        return false;
    }
    
    public boolean sendInValidCredentials() {
        String userName = "123123123";
        typeOnElement(userNameElement, userName);
        typeOnElement(userPasswordElement, "1234567890AB-");
        userLoginBtnElement.click();
        try {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"ctl00_Main_LoginConrol\"]/tbody/tr/td/table/tbody/tr[4]/td"));
            if (element != null) {
                return true;
            }
        } catch (Exception ex) {
            return false;
        }
        return false;
    }
}
