/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RemoteDriver implements IDriver{
     
    private WebDriver driver;
    private String baseURL;
    private String browser;

    public RemoteDriver(String starURL,String browser){
        this.baseURL = starURL;
        this.browser = browser;
    }
    
    @Override
    public void buildDriver() {
     try{
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        capability.setBrowserName(this.browser.toLowerCase());
        capability.setPlatform(getPlatform()); //get platform according to globla variables
        URL url=new URL(Globals.hubeNode);  //get hubenode according to globla variables
        this.driver =  new RemoteWebDriver(url,capability);
        this.driver.get(this.baseURL);
     }
     catch(Exception ex){
         System.out.println("There are troubles with the hub node");
     }
    }

    @Override
    public WebDriver getDriver() {
        return this.driver;
    }
    
    private Platform getPlatform(){
        if(Globals.platform.toLowerCase().equals("win"))
            return Platform.WINDOWS;
        else if(Globals.platform.toLowerCase().equals("linunx"))
            return Platform.LINUX;
        else if(Globals.platform.toLowerCase().equals("mac"))
                return Platform.MAC;
        else{
            System.out.println(Globals.platform + " does not have validation or it does not exists");
            return Platform.WINDOWS;  //default platform
        }
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }
}
