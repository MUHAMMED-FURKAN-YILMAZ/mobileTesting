package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium03 {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\user\\IdeaProjects\\mobileTesting\\src\\apps\\Gesture Tool_v1.3_apkpure.com.apk");

        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(2500);

        // id ile
       // driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();

        // id bu sekilde de yazilabilir
       // driver.findElementById("addButton").click();

        // xpath by text
       // driver.findElementByXPath("//*[@text='Add gesture']");

        // xpath by index
       // driver.findElementByXPath("(//android.widget.Button)[1]");
// Selenium'dan farkli olarak index 0'dan degil 1'den baslar

        // xpath attribute
       // driver.findElementByXPath("//android.widget.Button[@text='Add gesture']").click();


        /*
        lunch GestureTool app
        click add gesture button
        send "appium" to nameBox
        verify title "Test a gesture"
        close app
         */

        driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
        Thread.sleep(1500);
        driver.findElementById("com.davemac327.gesture.tool:id/gesture_name").sendKeys("appium");
        String expectedText="appium";
        driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay").click();
        driver.findElementById("com.davemac327.gesture.tool:id/done").click();
        Thread.sleep(1500);
        String actualText=driver.findElementById("android:id/text1").getText();

        Assert.assertEquals(actualText,expectedText);

        //session kapat
        driver.quit();

    }
}
