/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page;

import entities.PersonRegister;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author jvega-as
 */
public class RegisterPage extends base.BasePage{
    @FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstName")
    private WebElement firstNameElement;
    
    @FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastName")
    private WebElement lastNameElement;
    
    @FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Email")
    private WebElement emailElement;
    
    @FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserName")
    private WebElement userNameElement;
    
    @FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Password")
    private WebElement passwordElement;
    
    @FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPassword")
    private WebElement confirmPasswordElement;
    
    @FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Question")
    private WebElement questionElement;
    
    @FindBy(id = "ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Answer")
    private WebElement answerElement;
    
    @FindBy(id = "ctl00_Main_CreateUserWizardControl___CustomNav0_StepNextButtonButton")
    private WebElement submitElement;
    
    public RegisterPage(WebDriver driver) {
        super(driver);
        //setURLToDriver("http://192.168.0.103:86/Register.aspx");
        PageFactory.initElements(driver, this);
    }
    
    public void clickRegisterLink(){
        clickSpecificNodeByID("ctl00_LoginView_RegisterLink");
    }
    
    private PersonRegister createUserInformation(){
        PersonRegister newPerson = new PersonRegister();
        newPerson.setFirstName("Jean Carlo");
        newPerson.setLastName("Vega Bejarano");
        newPerson.setEmail("jean.vega@avantica.net");
        newPerson.setUserName("jeanvega");
        newPerson.setPassword("1234567890AB-");
        newPerson.setConfirmPassword("1234567890AB-");
        newPerson.setSecurityQuestion("What is the name of my first dog?");
        newPerson.setSecurityAnswer("Bruno");
        return newPerson;
    }
    
    public void createValidUser(){
        PersonRegister currentPerson = createUserInformation();
    }
    
    private boolean writeRegisterOnInpust(PersonRegister currentPerson){
        boolean typeOnElementFaild = false;
        
        typeOnElement(firstNameElement, currentPerson.getFirstName());
            
        //set lastName at input
        typeOnElement(lastNameElement, currentPerson.getLastName());
            
        //set email at input
        typeOnElement(emailElement, currentPerson.getEmail());
            
        //set userName at input
        typeOnElement(userNameElement, currentPerson.getUserName());
            
        //set password at input
        typeOnElement(passwordElement, currentPerson.getPassword());
            
        //set repassword at input
        typeOnElement(confirmPasswordElement, currentPerson.getConfirmPassword());
            
        //set question at input
        typeOnElement(questionElement, currentPerson.getSecurityQuestion());
            
        //set answer at input
        typeOnElement(answerElement, currentPerson.getSecurityAnswer());
         
        clickOnElement(submitElement);
        return true;
    }
    
    private PersonRegister createEmpyRegister(){
        PersonRegister newPerson = new PersonRegister();
        newPerson.setFirstName("");
        newPerson.setLastName("");
        newPerson.setEmail("");
        newPerson.setUserName("");
        newPerson.setPassword("");
        newPerson.setConfirmPassword("");
        newPerson.setSecurityQuestion("");
        newPerson.setSecurityAnswer("");
        return newPerson;
    }
    
    public boolean verifyAllErrorMessagesDisplayedByEmptyInputs(){
        if(!writeRegisterOnInpust(createEmpyRegister()))
            return false;
        return locatorsLoadOnPage(getNodeErrorListByID()); //Fix
    }
    
    public boolean verifyErrorByDiferentPasword(){
      PersonRegister personTest = createUserInformation();
      personTest.setConfirmPassword("1234567890ab-"); //set diferentPassword
      if(!writeRegisterOnInpust(personTest))
          return false;
      return visibilityBySpecificLocatorByID("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_PasswordCompare"); 
    }
    
    public boolean  verifyErrorByUserNameTaken(PersonRegister personTest){
        if(!writeRegisterOnInpust(personTest))
            return false;
        return visibilityBySpecificLocatorByID("ctl00_Main_InfoLabel");
    }

    public boolean verifyRegisterLoad(){
        return locatorsLoadOnPage(getLocatorList());
    }

    private ArrayList<String> getLocatorList(){
        ArrayList<String> currentList = new ArrayList<>();
        currentList.add("ctl00_Main_CreateUserWizardControl");
        currentList.add("nav_header");
        currentList.add("footer_nav");
        currentList.add("user_assistance");
        currentList.add("ctl00_Main_CreateUserWizardControl___CustomNav0_StepNextButtonButton");
        return  currentList;
    }
    
    private ArrayList<String> getNodeErrorListByID(){
        ArrayList<String> currentList = new ArrayList<>();
        currentList.add("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstNameRequired");
        currentList.add("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastNameRequired");
        currentList.add("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_EmailRequired");
        currentList.add("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserNameRequired");
        currentList.add("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_PasswordRequired");
        currentList.add("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPasswordRequired");
        currentList.add("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_QuestionRequired");
        currentList.add("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_AnswerRequired");
        return  currentList;
    }
}
