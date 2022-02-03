package pageobjects;

import base.TestBaseSetup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.TestUtility;

import java.util.List;

public class ArticleWeb extends TestBaseSetup {

    @FindBy(xpath = "//*[@class='ion-compose']")
    public WebElement linkNewArticle;

    @FindBy(xpath = "//*[@placeholder='Article Title']")
    public WebElement txtArticleTitle;

    @FindBy(xpath = "//*[@formcontrolname='description']")
    public WebElement txtArticleAbt;

    @FindBy(xpath = "//*[@formcontrolname='body']")
    public WebElement txtArticleBody;

    @FindBy(xpath = "//*[@placeholder='Enter tags']")
    public WebElement txtEnterTags;

    @FindBy(xpath = "//button[normalize-space(text()) = 'Publish Article']")
    public WebElement btnPublishArticle;

    @FindBy(xpath = "//*[normalize-space(text()) = 'Edit Article']")
    public WebElement btnEditArticle;

    @FindBy(xpath = "//*[normalize-space(text()) = 'Delete Article']")
    public WebElement btnDeleteArticle;

    @FindBy(xpath = "//app-favorite-button/button")
    public WebElement btnLikeArticle;

    @FindBy(xpath = "//*[@class='card-block']//textarea")
    public WebElement txtComment;

    @FindBy(xpath = "//*[normalize-space(text()) = 'Post Comment']")
    public WebElement btnPostComment;

    @FindBy(xpath = "//*[@class='tag-default tag-pill']//i")
    public List<WebElement> listTags;

    @FindBy(xpath = "//*[@class='card-text']")
    public WebElement addcomment;

    @FindBy(xpath = "//*[normalize-space(text()) = 'Edit Article']")
    public WebElement editArticle;

    @FindBy(xpath = "(//*[@class='app-article-preview'])[last()]")
    public WebElement yourFeed;

    @FindBy(xpath = "//*[normalize-space(text()) = 'Global Feed']")
    public WebElement globalFeed;


    public void clickOncomment() {
        TestUtility.clickOnElement(txtComment, "Comment Text Area",2);
    }

    public void gotoGlobalFeed() {
        TestUtility.clickOnElement(globalFeed, "Global Feed",2);
    }

    public void enterComment(String comment) {
        TestUtility.clearAndEnterText(txtComment, comment, "Text Area",2);
    }

    public void postcomment() {
        TestUtility.clickOnElement(btnPostComment, "Post comment",2);
    }

    public void enterArticleTitle() {
        TestUtility.clearAndEnterText(txtArticleTitle, TestUtility.getAlphaNumericString(6), "Article title text box",2);
    }

    public void enterArticleAbout() {
        TestUtility.clearAndEnterText(txtArticleAbt, TestUtility.getAlphaNumericString(6), "Article About text box",2);
    }

    public void enterArticleDescription() {
        TestUtility.clearAndEnterText(txtArticleBody, TestUtility.getAlphaNumericString(6), "Article Description text Area",2);
    }

    public void enterArticleTags() {
        TestUtility.clearAndEnterText(txtEnterTags, TestUtility.getAlphaNumericString(3) + Keys.ENTER, "Article Tag",2);
    }

    public void clickPublishArticle() {
        TestUtility.clickOnElement(btnPublishArticle, "Article Publishbtn",2);
    }

    public void clickNewArticleLink() {
        TestUtility.clickOnElement(linkNewArticle, "New Article",2);
    }


    public void clickEditArticleLink() {
        TestUtility.clickOnElement(btnEditArticle, "Edit Article",2);
    }

    public void clickDeleteArticle() {
        TestUtility.clickOnElement(btnDeleteArticle, "Delete Article",2);
    }



    public void addArticle() {
        clickNewArticleLink();
        enterArticleTitle();
        enterArticleAbout();
        enterArticleDescription();
        enterArticleTags();
        clickPublishArticle();
    }

    public void editArticle() {
        clickEditArticleLink();
        enterArticleTitle();
        enterArticleAbout();
        enterArticleDescription();
        for (WebElement removetag : listTags) {
            removetag.click();
        }
        enterArticleTags();
        clickPublishArticle();

    }

    public void deleteArticle() throws InterruptedException {
        clickDeleteArticle();
        Thread.sleep(5000);
    }

    public void postComment(String comment) {
        clickOncomment();
        enterComment(comment);
        postcomment();

    }


}


