package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium07ChromeNativeApp {

    @Test
    public void test() throws InterruptedException, MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

       // desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome"); -> Native'de buna gerek yok
        desiredCapabilities.setCapability("chromedriverExecutable", "C:\\Users\\user\\IdeaProjects\\mobileTesting\\src\\Driver\\chromedriver.exe");

        desiredCapabilities.setCapability("appPackage","com.android.chrome");
        desiredCapabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");

        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(2500);

    }
}
