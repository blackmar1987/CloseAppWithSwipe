import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class base {

    public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {

        URL serverURL = new URL("http://127.0.0.1:4723/wd/hub");

        File f = new File ("src");
        File fs = new File (f, "ApiDemos-debug.apk");


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
       // capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_5X_API_28_2");;
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "TestGoogleApi");
        capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

        AndroidDriver<AndroidElement> driver = new AndroidDriver(serverURL, capabilities);

        return driver;


    }

}
