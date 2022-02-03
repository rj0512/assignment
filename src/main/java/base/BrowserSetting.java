package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestUtility;
import java.io.IOException;
import static base.TestBaseSetup.*;
import static interfaces.ClassObject.readJson;

public class BrowserSetting {


    public WebDriver intializeBrowser() throws IOException, ParseException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getAppURL());
        return driver;

    }

    public void closeBrowser() {
        driver.quit();
    }


    public static void enterValidCredentials() throws IOException, ParseException {
        String username = (String) readJson.readJsonData("main.json").get("username");
        String password = (String) readJson.readJsonData("main.json").get("password");
        String url = (String) readJson.readJsonData("main.json").get("url");
        String finalUrl = "https://" + username + ":" + password + "@" + url;
        TestUtility.enterCredentialInUrl(finalUrl);
    }


    public static String getAppURL() throws IOException, ParseException {
        String username = (String) readJson.readJsonData("main.json").get("username");
        String password = (String) readJson.readJsonData("main.json").get("password");
        String url = (String) readJson.readJsonData("main.json").get("url");
        return "https://" + username + ":" + password + "@" + url;
    }
}
