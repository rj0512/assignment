package pageobjects;

import base.TestBaseSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.TestUtility;


public class SignUpWeb extends TestBaseSetup {
    @FindBy(xpath = "//*[@formcontrolname='username']")
    public WebElement txtUserName;

    @FindBy(xpath = "//*[@formcontrolname='email']")
    public WebElement txtEmail;

    @FindBy(xpath = "//*[@formcontrolname='password']")
    public WebElement txtPassword;

    @FindBy(xpath = "//button[normalize-space(text()) = 'Sign up']")
    public WebElement btnSubmit;

    @FindBy(xpath = "//a[normalize-space(text()) = 'Sign up']")
    public WebElement linkSignUp;

    @FindBy(xpath = "//*[@class='error-messages']//li")
    public WebElement errorUserName;


    public void clickOnSignUpLink() {
        TestUtility.clickOnElement(linkSignUp, "Sign Up Link",2);
    }

    public void enterUsername(String userName) {
        TestUtility.clearAndEnterText(txtUserName, userName, "UserName",2);
    }

    public void enterEmail(String email) {
        TestUtility.clearAndEnterText(txtEmail, email, "E-mail",2);
    }

    public void enterPassword(String password) {
        TestUtility.clearAndEnterText(txtPassword, password, "Password",2);
    }

    public void clickOnSubmit() {
        TestUtility.clickOnElement(btnSubmit, "Submit Button",2);
    }


    public void signUpUser(String userName, String email, String password) {
        clickOnSignUpLink();
        enterUsername(userName);
        enterEmail(email);
        enterPassword(password);
        clickOnSubmit();

    }

    public void signUpUserwithUsedName(String userName, String email, String password) {
        clickOnSignUpLink();
        enterUsername(userName);
        enterEmail(email);
        enterPassword(password);
        clickOnSubmit();

    }


}

