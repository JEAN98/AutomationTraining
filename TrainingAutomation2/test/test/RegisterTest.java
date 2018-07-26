/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dataProvider.RegisterDataProvider;
import entities.PersonRegister;
import java.io.IOException;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.RegisterPage;

/**
 *
 * @author jvega-as
 */
public class RegisterTest extends base.BaseTest{
     RegisterPage registerPage;
    
    public RegisterTest() {
    }
    
    @BeforeClass
    public void setUpClass() {
        System.out.println("**Executing RegisterPage**");
    }
    
    private void preconditionsRegisterPage() {
        //registerPage = new RegisterPage(BaseTest.driver);
        registerPage = navigationPage.goToRegisterPage();
        //PersonRegister[] array = jsonHelper.getData();
        //System.out.println(array.length);       
    }
    
     
    /**
     * Test of verifyErrorMessageOnInputs method, of class RegisterPage.
     */
    @Test
    public void verifyAllErrorMessagesDisplayedByEmptyInputs() {
        preconditionsRegisterPage();
        System.out.println("verifyErrorMessageOnInputs");
        assertTrue(registerPage.verifyAllErrorMessagesDisplayedByEmptyInputs());
    }

    /**
     * Test of verifyErrorbyDiferentPasword method, of class RegisterPage.
     */
    @Test
    public void testVerifyErrorByDiferentPasword() {
        preconditionsRegisterPage();
        System.out.println("verifyErrorByDiferentPaswords");
        assertTrue(registerPage.verifyErrorByDiferentPasword());
    }

  
    //@Test(dataProvider="CreateValidUserJson")
    @Test(dataProvider = "CreateValidUserJson", dataProviderClass = RegisterDataProvider.class)
    public void testVerifyErrorByUserNameTaken(PersonRegister currentUser) {
        preconditionsRegisterPage();
        System.out.println("Test Case with: "+currentUser.getFirstName());
        System.out.println("verifyErrorByUserNameTaken");  
        assertTrue(registerPage.verifyErrorByUserNameTaken(currentUser));
    }
    
    /**
     * Test of verifyRegisterLoad method, of class RegisterPage.
     */
    @Test
    public void testVerifyRegisterLoad() {
        preconditionsRegisterPage();
        System.out.println("verifyRegisterLoad");
        assertTrue(registerPage.verifyRegisterLoad());
    }
    
    @AfterClass
    public void tearDownClass() {
        System.out.println("**Completing RegisterPage**");
    }
}
