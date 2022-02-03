package base;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import java.io.IOException;


public class TestBaseSetup {

    BrowserSetting browserSetting;
    public static WebDriver driver;


    public TestBaseSetup() {
        PageFactory.initElements(driver, this);

    }

    @BeforeSuite

    public void openBrowser() throws IOException, ParseException {

        browserSetting = new BrowserSetting();
        browserSetting.intializeBrowser();
    }


    @AfterSuite
    public void closeBrowser() {
        browserSetting = new BrowserSetting();
        browserSetting.closeBrowser();
    }

}

