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
import java.util.Locale;


import static interfaces.ClassObject.*;

public class TestSignUpScenario extends TestBaseSetup {
    String userName = TestUtility.getAlphaNumericString(5).toLowerCase(Locale.ROOT);
    String email = TestUtility.getAlphaNumericString(5) + "@" + TestUtility.getAlphaNumericString(3) + ".com";
    String password = TestUtility.getAlphaNumericString(8);

    @BeforeClass
    public void startLog()
    {
        Log.startLog("Sigm Up");
    }

    @Test
    public void verifySignUpUser() {
        signUp.signUpUser(userName, email, password);
        article.clickNewArticleLink();
        Assert.assertEquals(userName, signIn.linkUser.getText());
        signIn.signOutUser();
    }

    @Test
    public void verifySignUpwithUsedUsername() throws IOException, ParseException {
        userName = (String) readJson.readJsonData("employee.json").get("username");
        String usernameErromsg = (String) readJson.readJsonData("employee.json").get("usernameErrorMsg");
        signUp.signUpUserwithUsedName(userName, email, password);
        TestUtility.elementIsDisplayed(signUp.errorUserName,"Error Message",10);
    }

    @AfterClass
    public void endtLog()
    {
        Log.endLog();
    }
}