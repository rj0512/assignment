package tests;

import base.TestBaseSetup;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Log;
import utilities.TestUtility;
import java.io.IOException;
import static interfaces.ClassObject.*;

public class TestSignInScenario extends TestBaseSetup {

    String email, userName, password;

    @BeforeClass
    public void startLog()
    {
        Log.startLog("Sigm In");
    }

    @Test
    public void verifySignIn() throws InterruptedException, IOException, ParseException {
        email = (String) readJson.readJsonData("employee.json").get("email");
        password = (String) readJson.readJsonData("employee.json").get("password");
        userName = (String) readJson.readJsonData("employee.json").get("username");
        signIn.signInUser(email, password);
        article.clickNewArticleLink();
        Assert.assertEquals(userName, signIn.linkUser.getText());
        signIn.signOutUser();
    }

    @Test
    public void verifySignInwithInvalidCredentails() throws InterruptedException, IOException, ParseException {
        String invalidError = (String) readJson.readJsonData("employee.json").get("invalidcredentails");
        email = TestUtility.getAlphaNumericString(6);
        password = TestUtility.getAlphaNumericString(6);
        signIn.signInUser(email, password);
        TestUtility.elementIsDisplayed(signIn.invalidCredentails,"Error Message",10);
    }

    @AfterClass
    public void endtLog()
    {
        Log.endLog();
    }

}