package com.example.phanthao.myapplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;


public class ExampleUnitTest {
    AndroidDriver driver;
    @Before
    public void init() throws MalformedURLException {
        System.out.println("Start Test");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName","Android");
        cap.setCapability("deviceName","192.168.73.101:5555");
        cap.setCapability("appPackage","vn.rure");
        cap.setCapability("appActivity","vn.rure.MainActivity");
        cap.setCapability("noReset",true);
        cap.setCapability("resetKeyboard", true);
        cap.setCapability("unicodeKeyboard", true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    }
    @Test
    public void runTest(){
        System.out.println("Run Test");
        AndroidTouchAction touchAction = new AndroidTouchAction(driver);

        MobileElement btnFilter = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.support.v4.view.ViewPager/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.ImageView");
        if(btnFilter.isDisplayed()) {
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(btnFilter))).perform();
            MobileElement txtDiemDi = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText");
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(txtDiemDi))).perform();
            txtDiemDi.clear();
            txtDiemDi.setValue("Ha Noi");

            MobileElement txtDiemDen = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText");
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(txtDiemDen))).perform();
            txtDiemDen.clear();
            txtDiemDen.setValue("TP HCM");

            driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[10]/android.view.ViewGroup[2]/android.view.View").click();


            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @After
    public void after(){
        System.out.println("End Test");
        driver.quit();
    }

}
