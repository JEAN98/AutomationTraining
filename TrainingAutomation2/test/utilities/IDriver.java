/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author JeanCarlo
 */
public interface IDriver {
    WebDriver getDriver();
    void buildDriver();
}
