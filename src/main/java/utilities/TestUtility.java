package utilities;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentLogger;
import java.time.Duration;

import static base.TestBaseSetup.driver;
import static listners.ListnerClass.getBase64Image;

public class TestUtility {

    /**
     * Enter Text in textfield
     *
     * @param element
     * @param textToEnter
     * @param elementName
     */

    public static void enterText(WebElement element, String textToEnter, String elementName) {
        try {
            Log.info("Entering text : " + textToEnter + " in " + elementName);
            element.sendKeys(textToEnter);
            ExtentLogger.log(Status.PASS, "Entered " + textToEnter + " in " + elementName, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());

        } catch (Exception e2) {
            Log.error("Failed to enter text : " + textToEnter + " in " + elementName);
            ExtentLogger.log(Status.FAIL, e2.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }

    }

   /**
     *To validate element is displayed on the screen
     * @param element
     * @param elementName
     */

    public static void elementIsDisplayed(WebElement element, String elementName, int time) {
        waitTillElementIsDisplayed(element, Duration.ofSeconds(time));
        try {

            if (element.isDisplayed()) {
                Log.info(elementName + " is Displayed");
                ExtentLogger.log(Status.PASS, elementName + " is Displayed", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
            }
        } catch (NoSuchElementException e) {
            Log.error(e.getMessage());
            ExtentLogger.log(Status.FAIL, e.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
    }

    /**
     * Click on element
     *
     * @param element
     * @param elementName
     */

    public static void clickOnElement(WebElement element, String elementName,int time) {
        waitTillElementIsDisplayed(element, Duration.ofSeconds(time));
        try {
            element.click();
            Log.info("Tap on " + elementName);
            ExtentLogger.log(Status.PASS, "Tap on " + elementName);
        } catch (Exception e) {
            try {
                if (driver != null) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                    Log.info("Tap on " + elementName);
                    ExtentLogger.log(Status.PASS, "Tap on " + elementName);
                }
            } catch (Exception e2) {
                Log.error(e2.getMessage());
                ExtentLogger.log(Status.FAIL, e2.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
            }
        }
    }

    public static void enterCredentialInUrl(String url) {
        try {
            driver.get(url);
            Log.info("page is loaded with " + url);
        } catch (Exception e) {
            Log.error("page is loaded with " + url);

        }
    }


    public static void waitTillElementIsDisplayed(WebElement element, Duration timeout) {
        if (driver != null) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        }
    }



    public static void wait(int time) throws InterruptedException {
        Thread.sleep(time * 1000);


    }



    /**
     * Clear Textfield and enter text
     *
     * @param element
     * @param textToEnter
     * @param elementName
     */
    public static void clearAndEnterText(WebElement element, String textToEnter, String elementName, int time) {
        waitTillElementIsDisplayed(element, Duration.ofSeconds(time));
        try {
            Log.info("Clearing text from " + elementName);
            element.clear();
            Log.info("Entering text : " + textToEnter + " in " + elementName);
            element.sendKeys(textToEnter);
            ExtentLogger.log(Status.PASS, "Entered " + textToEnter + " in " + elementName, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());

        } catch (Exception e2) {
            Log.error("Failed to enter text : " + textToEnter + " in " + elementName);
            ExtentLogger.log(Status.FAIL, e2.getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
    }




    public static String getAlphaNumericString(int n) {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();

    }


}
