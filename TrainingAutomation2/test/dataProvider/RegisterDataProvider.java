/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataProvider;

import entities.PersonRegister;
import java.io.IOException;
import utilities.JsonHelper;
import org.testng.annotations.DataProvider;

/**
 *
 * @author jvega-as
 */
public class RegisterDataProvider {
 
    
    @DataProvider(name="CreateValidUserJson")
    public static Object[][] getValidUserJson() throws IOException{
      // PersonRegister[] personList = getDataUser();
      JsonHelper jsonHelper = new JsonHelper();
      PersonRegister[] personList = jsonHelper.getData();
       Object[][] matrixObject = new Object[personList.length][1];
        for (int i = 0; i < personList.length; i++) {
             matrixObject[i][0] = personList[i];   
        }
       return matrixObject;
     } 
}
