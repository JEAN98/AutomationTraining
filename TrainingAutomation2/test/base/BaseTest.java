/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import utilities.RemoteDriver;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.JsonHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import page.NavigationPage;
import utilities.DriverHelper;

/**
 *
 * @author jvega-as
 */
public class BaseTest {
    public static WebDriver driver;
    protected JsonHelper jsonHelper;
    protected NavigationPage navigationPage;
    
    @BeforeTest
    public void beforeTest(){
       jsonHelper = new JsonHelper();
       System.out.println("BeforeTest");
    }  
     
    @BeforeMethod
    @Parameters({ "browser", "startURL" ,"driverType"})
    public void setUpDriver(String browser, String startURL,String driverType){
      System.out.println("Creating driver");
      driver = createDriver(browser, startURL,driverType);
      navigationPage = new NavigationPage(driver);
    }
     
    private WebDriver createDriver(String browserType, String startURL,String driverType){
        DriverHelper driverHelper = new DriverHelper(startURL, browserType, driverType);
        driverHelper.createDriver();
        return driverHelper.getDriver();
    }
     
    @AfterMethod
    public void tearDown(){
        System.out.println("Closing driver");
        driver.quit();
    }
     
    @AfterMethod
    public void afterTest(){
        System.out.println("AfterTest");
    }
}
