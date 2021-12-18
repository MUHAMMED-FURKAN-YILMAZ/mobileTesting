package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium {


    @Test
    public void test() throws MalformedURLException, InterruptedException {

// Once Cihaz ayarlamalarini yapiyoruz

        //MobileCapabilityType -> CapabilityType OR "platformName" can be used.

        //desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
        //desiredCapabilities.setCapability("platformName","Android");

        // CapabilityType and "platformName" came from -> Selenium
        // MobileCapabilityType came from -> appium
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\user\\IdeaProjects\\mobileTesting\\src\\apps\\Gesture Tool_v1.3_apkpure.com.apk");

        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        //By using this line, we skip the manuel continue part. Application do not set up every time.


// intellij'de yazdigim kodlari cihaza gondermek icin ayarlama yapiyoruz

        //http://localhost:4723/wd/hub
        AndroidDriver<MobileElement> driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        // URL url = new URL("http://127.0.0.1:4723/wd/hub");
        // AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, desiredCapabilities);

        Thread.sleep(3000);

        // //android.widget.Button
        //[@text='Add gesture']

        // id
        driver.findElementById("com.davemac327.gesture.tool:id/addButton"); // -> appium
        // driver.findElement(By.id("com.davemac327.gesture.tool:id/addButton")); -> selenium


        // xpath by text
        driver.findElementByXPath("//*[@text='Add gesture']");

        // xpath by index
        driver.findElementByXPath("(//android.widget.Button)[1]");
// Selenium'dan farkli olarak index 0'dan degil 1'den baslar

        // xpath attribute
        driver.findElementByXPath("//android.widget.Button[@text='Add gesture']").click();


    }

}
