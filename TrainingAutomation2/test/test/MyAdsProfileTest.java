/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import base.BaseTest;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.MyAdsProfilePage;

/**
 *
 * @author jvega-as
 */
public class MyAdsProfileTest extends BaseTest{
    MyAdsProfilePage myAdsProfilePage;
    
    public MyAdsProfileTest() {
    }
    
    private void precondintions(){
       myAdsProfilePage = navigationPage.goToMyAdsProfilePage();
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
       System.out.println("**Executing MyAdsProfileTest**");
    }
    
    @Test
    public void verifyLoadWithUserLogged(){
        precondintions();
        assertTrue(myAdsProfilePage.loadMyAdsProfileUserLogged());
    }
    
    @Test
    public void verifyLoadWithUserNotLogged(){
        precondintions();
        assertTrue(myAdsProfilePage.loadMyAdsProfileUserNotLogged());
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
         System.out.println("**Executing MyAdsProfileTest**");
    }
}
