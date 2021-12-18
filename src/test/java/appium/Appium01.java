package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium01 {

    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\user\\IdeaProjects\\mobileTesting\\src\\apps\\Gesture Tool_v1.3_apkpure.com.apk");

        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        //By using this line, we skip the manuel continue part. Application do not set up every time.


// intellij'de yazdigim kodlari cihaza gondermek icin ayarlama yapiyoruz

        //http://localhost:4723/wd/hub
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        if (driver.isDeviceLocked()) {
            driver.unlockDevice();
        }
/*
Eger telefon kullanmak istiyorsaniz developer option aktif hale getirilmeli ve USB Debugging acik olmali
USB vasitasiyla gercek telefonlarda da test yapabiliriz
 */
    }
}

