package pageobjects;

import base.TestBaseSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.TestUtility;


public class SignInWeb extends TestBaseSetup {

    @FindBy(xpath = "//*[@formcontrolname='email']")
    public WebElement txtEmail;

    @FindBy(xpath = "//*[@formcontrolname='password']")
    public WebElement txtPassword;

    @FindBy(xpath = "//button[normalize-space(text()) = 'Sign in']")
    public WebElement btnSubmit;

    @FindBy(xpath = "//a[normalize-space(text()) = 'Sign in']")
    public WebElement linkSignIn;

    @FindBy(xpath = "(//*[@routerlinkactive='active'])[last()]")
    public WebElement linkUser;

    @FindBy(xpath = "//*[normalize-space(text()) = 'Edit Profile Settings']")
    public WebElement linkEditProfileSetting;

    @FindBy(xpath = "//*[normalize-space(text()) = 'Or click here to logout.']")
    public WebElement linkLogOut;

    @FindBy(xpath = "//*[@class='error-messages']//li")
    public WebElement invalidCredentails;

    @FindBy(xpath = "//*[@class='ion-gear-a']")
    public WebElement linkSetting;


    public void clickSignInLink() {
        TestUtility.clickOnElement(linkSignIn, "SignIn Link",2);
    }

    public void enterEmailAddress(String email) {
        TestUtility.clearAndEnterText(txtEmail, email, "Email",2);
    }

    public void enterPassword(String password) {
        TestUtility.clearAndEnterText(txtPassword, password, "Password",2);
    }

    public void clickOnSubmit() {
        TestUtility.clickOnElement(btnSubmit, "Submit Button",2);
    }

    public void clickOnUserName() {
        TestUtility.clickOnElement(linkUser, "User Name",2);
    }

    public void clickOnSettig() {
        TestUtility.clickOnElement(linkSetting, "User Name",2);
    }


    public void clickOnLogout() {
        TestUtility.clickOnElement(linkLogOut, "Logout",2);
    }


    public void signInUser(String email, String password) {
        clickSignInLink();
        enterEmailAddress(email);
        enterPassword(password);
        clickOnSubmit();
    }

    public void signOutUser() {
        clickOnSettig();
        clickOnLogout();

    }


}


