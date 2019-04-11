
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;


import java.net.MalformedURLException;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;


public class CloseAppWithSwipe extends  base{

    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = Capabilities();

        Dimension size = driver.manage().window().getSize();
        int anchor, startPoint, endPoint;
        anchor = (int) (size.width * 0.5);
        startPoint = (int) (size.height * 0.6);
        endPoint = (int) (size.height * 0.9);

        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));

        AndroidElement appWindow = driver.findElement(By.id("com.google.android.apps.nexuslauncher:id/snapshot"));
        AndroidElement appIcon = driver.findElement(By.id("com.google.android.apps.nexuslauncher:id/icon"));

        TouchAction t = new TouchAction(driver);
        t.longPress(longPressOptions().withElement(element(appWindow)).withDuration(ofSeconds(0,1))).moveTo(element(appIcon)).release().perform();


         t.longPress(longPressOptions().withElement(element(appWindow)).withDuration(ofSeconds(2))).moveTo(point(anchor,endPoint)).release().perform();
        t.longPress(longPressOptions().withPosition(point(anchor, startPoint)).withDuration(ofSeconds(1))).moveTo(point(anchor,endPoint)).release().perform();


    }
}
