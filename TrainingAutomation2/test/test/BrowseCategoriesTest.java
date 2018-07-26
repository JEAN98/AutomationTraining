/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import base.BaseTest;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.BrowseCategoriesPage;

/**
 *
 * @author jvega-as
 */
public class BrowseCategoriesTest extends BaseTest{
    BrowseCategoriesPage browseCategoriesPage;

    public BrowseCategoriesTest(){
    }
    
    @BeforeClass
    public void setUpClass() {
       System.out.println("**Executing BrowseCategoriesTest**");
    }
    
    private void preconditions(){
       browseCategoriesPage = navigationPage.goToBrowseCategories();
    }
    
    @Test
    public void verifyLoadPage(){
        preconditions();
        assertTrue(browseCategoriesPage.loadBrowseCategories());
    }
            
    @Test
    public void verifyfocousOnWithClickAntiquesCollectibles(){
       preconditions();
       assertTrue(browseCategoriesPage.focousOnWithClickAntiquesCollectibles());
    }
    
    @Test
    public void verifyfocousOnWithClickAuto(){
       preconditions();
       assertTrue(browseCategoriesPage.focousOnWithClickAuto());
    }
    
    @Test
    public void verifyfocousOnWithClickArtCrafts(){
       preconditions();
       assertTrue(browseCategoriesPage.focousOnWithClickArtCrafts());
    } 
    
    @AfterClass
    public void tearDownClass() {
        System.out.println("--Completing execution BrowseCategoriesTest--");
    }
    
}
