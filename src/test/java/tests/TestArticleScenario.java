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

public class TestArticleScenario extends TestBaseSetup {

    String email, userName, password;

    @BeforeClass

    public void intialzeLoginData() throws IOException, ParseException {
        Log.startLog("Article");
        email = (String) readJson.readJsonData("employee.json").get("email");
        password = (String) readJson.readJsonData("employee.json").get("password");
        userName = (String) readJson.readJsonData("employee.json").get("username");
    }

   @Test
    public void verifyAddArticle() throws InterruptedException {
        signIn.signInUser(email, password);
        article.addArticle();
        TestUtility.elementIsDisplayed(article.editArticle,"Edit Article",10);
        Assert.assertTrue(article.editArticle.isDisplayed());
        signIn.signOutUser();
    }



    @Test
    public void verifyEditArticle() throws InterruptedException {
        signIn.signInUser(email, password);
        article.addArticle();
        TestUtility.elementIsDisplayed(article.editArticle,"Edit Article",10);
        article.editArticle();
        TestUtility.elementIsDisplayed(article.editArticle,"Edit Article",10);
        Assert.assertTrue(article.editArticle.isDisplayed());
        signIn.signOutUser();
    }

   @Test
    public void verifyDeleteArticle() throws InterruptedException {
        signIn.signInUser(email, password);
        article.addArticle();
        TestUtility.elementIsDisplayed(article.editArticle,"Edit Article",10);
        article.deleteArticle();
        TestUtility.elementIsDisplayed(article.yourFeed,"Your Feed",10);
        Assert.assertTrue(article.yourFeed.isDisplayed());
        signIn.signOutUser();
    }

   @Test
    public void verifyAddComment() {
        String comment = TestUtility.getAlphaNumericString(15);
        signIn.signInUser(email, password);
        article.addArticle();
       TestUtility.elementIsDisplayed(article.editArticle,"Edit Article",10);
        article.postComment(comment);
       TestUtility.elementIsDisplayed(article.addcomment,"Add Comment",10);
        Assert.assertEquals(comment, article.addcomment.getText());
        signIn.signOutUser();
    }

    @AfterClass
    public void endtLog()
    {
        Log.endLog();
    }


}