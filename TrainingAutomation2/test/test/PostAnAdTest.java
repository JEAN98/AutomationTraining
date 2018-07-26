/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import base.BaseTest;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.PostAnAdPage;

/**
 *
 * @author jvega-as
 */
public class PostAnAdTest extends BaseTest{
    private PostAnAdPage postAnAdPage; 
    
    public PostAnAdTest() {
    }
    private void preconditions(){
       postAnAdPage = navigationPage.goToPostAnAdPage();
    }
    
    @BeforeClass
    public void setUpClass() {
        System.out.println("**Executing PostAnAdTest**");
    }
    
    @Test
    public void verifyLoadWithUserLogged(){
        preconditions();
        assertTrue(postAnAdPage.loadPostAnAdPageUserLogged());
    }
    
    @Test
    public void verifyLoadWithUserNoLogged(){
        preconditions();
        assertTrue(postAnAdPage.loadPostAnAdPageUserNotLogged());
    }
    
    @AfterClass
    public void tearDownClass() {
        System.out.println("**Completing PostAnAdTest**");
    }
}
