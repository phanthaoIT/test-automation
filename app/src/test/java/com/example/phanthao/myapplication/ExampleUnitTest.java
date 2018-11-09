package com.example.phanthao.myapplication;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

import static org.junit.Assert.assertEquals;


public class ExampleUnitTest {
    AndroidDriver driver;
    @BeforeTest
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
    @Test(dataProvider = "DataTest")
    public void testRun(String sDiemDi, String sDiemDen, String ngayDi, String ngayVe) {
        System.out.println("testrun");

        AndroidTouchAction touchAction = new AndroidTouchAction(driver);
//        Bấm vào nút thêm mới
        MobileElement btnAdd = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.support.v4.view.ViewPager/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.ImageView");
        if(btnAdd.isDisplayed()) {
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(btnAdd))).perform();
            MobileElement txtDiemDi = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText");
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(txtDiemDi))).perform();
            txtDiemDi.clear();
            txtDiemDi.setValue(sDiemDi);

            MobileElement txtDiemDen = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText");
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(txtDiemDen))).perform();
            txtDiemDen.clear();
            txtDiemDen.setValue(sDiemDen);

            MobileElement txtNgayDi = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.TextView");
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(txtNgayDi))).perform();
            txtNgayDi.clear();
            txtNgayDi.setValue(ngayDi);

            MobileElement txtNgayVe = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[7]/android.widget.TextView");
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(txtNgayVe))).perform();
            txtNgayVe.clear();
            txtNgayVe.setValue(ngayVe);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MobileElement btnok = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[10]/android.view.ViewGroup[2]/android.view.View");
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(btnok))).perform();

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

    @DataProvider(name = "DataTest")
    public static Object[][] datas() {
        return new Object[][] {
                {"","","",""}
        };
    }

    @AfterTest
    public void after(){
        System.out.println("End Test");
        driver.quit();
    }

}
