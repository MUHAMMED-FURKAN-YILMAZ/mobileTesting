package appiumClasses;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BC_Exercise {
    /*
    lunch the gesture app
    click add gesture button
    send text "testing" and click done
    verify testing gesture created
     */

    @Test
    public void test () throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
        //desiredCapabilities.setCapability("platformName","Android");

        //MobileCapabilityType -> CapabilityType OR "platformName" can be used.

        // CapabilityType and "platformName" came from -> Selenium
        // MobileCapabilityType came from -> appium

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); // XCUITest -> iOS
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\user\\IdeaProjects\\mobileTesting\\src\\apps\\Gesture Tool_v1.3_apkpure.com.apk");

        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
        //By using this line, we skip the manuel continue part. Application do not set up every time.

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, desiredCapabilities);

        //AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);
        //AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);
        //->(WebElement,AndroidElement,MobileElement) --> Whichever you used, you should always continue to use it.
        //-> This is another way that you do not have to set the URL separately

        Thread.sleep(3000);

        //id
        driver.findElement(By.id("com.davemac327.gesture.tool:id/addButton"));
        driver.findElementById("com.davemac327.gesture.tool:id/addButton");
        //xpath
        driver.findElementByXPath("//*[@text='Add gesture']");
        //xpath index
        driver.findElementByXPath("(//android.widget.Button)[1]");
        //xpath attribute
        driver.findElementByXPath("//android.widget.Button[@text='Add gesture']").click();

    }
}
//AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http:127.0.0.1:4723/wd/hub"), desiredCapabilities);
//->(WebElement,AndroidElement,MobileElement) --> Whichever you used, you should always continue to use it.