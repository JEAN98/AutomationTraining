/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import static base.BaseTest.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author JeanCarlo
 */
public class LocalDriver implements IDriver {
    private WebDriver driver;  
    private String baseURL;
    private String browserType;
    
    public LocalDriver(String startURL, String browserType){
        this.baseURL     = startURL;
        this.browserType = browserType;
    }

    @Override
    public void buildDriver() {
        try{
           if(this.browserType.toLowerCase().equals("firefox")){
              System.setProperty("webdriver.gecko.driver", "test\\driver\\geckodriver.exe");
              this.driver = new FirefoxDriver();
            }
           else if(browserType.toLowerCase().equals("chrome")){
              System.setProperty("webdriver.chrome.driver", "test\\driver\\chromedriver.exe");  
              this.driver = new ChromeDriver();
           }
           this.driver.get(this.baseURL);
       }catch(Exception ex){
           System.out.println(ex.getMessage());
       }
    }
    
    @Override
    public WebDriver getDriver() {
        return this.driver;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    
}
