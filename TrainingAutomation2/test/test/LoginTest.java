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
import page.LoginPage;

/**
 *
 * @author jvega-as
 */
public class LoginTest extends base.BaseTest{
    LoginPage loginPage;
    public LoginTest() {
    }
    
    @BeforeClass
    public void setUpClass() {
        System.out.println("**Executing LoginPage**");
    }
    
    private void preconditionsLoginPage(){
       //loginPage = new LoginPage(BaseTest.driver);
       loginPage = navigationPage.goToLoginPage();
    }
    
    /**
     * Test of verifyPageLoadLogin method, of class LoginPage.
     */
    @Test
    public void testVerifyPageLoadLogin() {
        preconditionsLoginPage();
        System.out.println("verifyPageLoadLogin");
        assertTrue(loginPage.verifyPageLoadLogin());
    }

    /**
     * Test of sendValidCredentials method, of class LoginPage.
     */
    @Test       
    public void testSendValidCredentials(){
        preconditionsLoginPage();
        System.out.println("sendValidCredentials");
        assertTrue(loginPage.sendValidCredentials());
    }
    
     /**
     * Test of sendValidCredentials method, of class LoginPage.
     */
    @Test
    public void testSendInValidCredentials() {
        preconditionsLoginPage();
        System.out.println("SendInValidCredentials");
        assertTrue(loginPage.sendInValidCredentials());
    }
    
    @AfterClass
    public void tearDownClass() {
        System.out.println("--Completing execution LoginPage--");
    }
}
