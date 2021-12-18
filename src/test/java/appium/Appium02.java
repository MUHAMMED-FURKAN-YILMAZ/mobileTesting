package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium02 {
    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

    // eger appActivity ve appPackage kullanacaksak .APP path kullanmaya ihtiyac yok
        //desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\user\\IdeaProjects\\mobileTesting\\src\\apps\\API Demos for Android_v1.9.0_apkpure.com.apk");

    //app yerine appPackage ve appActivity yazilirsa izin kismini manuel gecmedigimiz icin test fail vermez
        desiredCapabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
        desiredCapabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");



     /* bu kismi yazabilmek icin ise oncelikle device'ta application'in ana sayfasi acik olmali,
        bu sayfanin detaylarini almak icin ise terminal yada CMD prompt acip su komutlar ile aliyoruz (appiumun hatada onerdigi siteden)
         1- adb shell (Android Debugging Build=adb)
         2- dumpsys window | grep -E "mCurrentFocus"
                "/"'in solu appPackage
                "/"'in sagi appActivity
         */


    //bu kismi aktive edince 1 kez izin verdiysem bir daha izin istemez ve gecer
        // desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
//com.touchboarder.android.api.demos/com.touchboarder.androidapidemos.MainActivity






    }
}
