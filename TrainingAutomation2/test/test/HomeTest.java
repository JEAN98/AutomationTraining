/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

/**
 *
 * @author jvega-as
 */
public class HomeTest extends base.BaseTest{
    HomePage homePage;
    public HomeTest() {
    }
    
    @BeforeClass
    public void setUpClass() {
        System.out.println("**Executing HomePage**");
    }
    
    private void preconditions(){
        homePage = navigationPage.goToHomePage();
    }
    
    @Test
    public void verifyHomePageLoadWhenAppLoading(){
        homePage = new HomePage(driver);
        System.out.println(" verifyHomePageLoadWhenAppLoading in execution");
        assertTrue(homePage.loadPageHome());
    }
    
    @Test
     public void verifyHomePageLoadWhenClickNavMenu(){
        preconditions();
        System.out.println(" verifyHomePageLoadWhenAppLoading in execution");
        assertTrue(homePage.loadPageHomeByClickNavMenu());
    }
     
    @AfterClass
    public void tearDownClass() {
        System.out.println("--Completing execution HomePage--");
    }
}
