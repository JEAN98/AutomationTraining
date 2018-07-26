/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author jvega-as
 */
public class BasePage {
    protected WebDriver driver;
    protected String currentUrl;
 
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    
    public void setURLToDriver(String url){
        this.driver.get(url);
        this.currentUrl = url;
   }
    
   /*In this method we can verify if button has focus*/
   public boolean hoverOver(WebElement element)
   { 
     try{
           new WebDriverWait(driver, 45).until(ExpectedConditions.visibilityOf(element));
           Actions action = new Actions(driver);
           action.moveToElement(element);
           action.perform();
       }
       catch(Exception ex){
          return false;
       }
        return true;                                                                                                    
    }
  
    /*Here we can click on any tag by id */
    public boolean clickSpecificNodeByID(String idSelected){
        //driver.get(currentUrl);
        WebElement element = driver.findElement(By.id(idSelected));
        if( element != null){
            element.click();
           return true;
        }
         return false;
    }
    
     /*Here we can verify if the main tags appear at the page*/
    public boolean locatorsLoadOnPage(ArrayList<String> locators){
        boolean isElementVisiable = false;
        boolean isElementExisting = true;
        for (String locator : locators){
            if(driver.findElements(By.id(locator)).size() > 0){
                if(!waitForElementVisible(driver.findElement(By.id(locator)))){
                    return isElementVisiable;
                }
            }
            else{
                 isElementExisting = false;
                 return isElementExisting;
            }
        }
        return  isElementExisting;
    }
    
   public boolean visibilityBySpecificLocatorByID(String locatorID){
        if(driver.findElements(By.id(locatorID)).size() > 0){
            if(!waitForElementVisible(driver.findElement(By.id(locatorID))))
                return false;
        }
        return true;
   }

    /*In this method we can verify if the tag is visible or not*/
    private boolean waitForElementVisible(WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean typeOnElement(WebElement element, String text){
        try{
            if(waitForElementVisible(element)){
                element.sendKeys(text);
                return true;
            }
        }
        catch(Exception e){
            System.out.println("The web Element does not exist!");
        }
        return false;
    }
    
    public boolean clickOnElement(WebElement element)
    {
        if(waitForElementVisible(element)){
            element.click();
            return true;
        }
        return false;
    }
    
    public String getTextFromElement(WebElement element)
    {
        String result ="";
        if(waitForElementVisible(element)){
             result = element.getText();
        }
        return result;
    }
    
    public boolean waitForElementEnabled(WebElement element)
    {
        return element.isEnabled();
    }
}
