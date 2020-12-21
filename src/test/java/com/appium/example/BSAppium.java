package com.appium.example;

import com.utils.PropertyLoader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import java.io.File;
import java.util.Map;

public class BSAppium {


    //private Logger logger = Logger.getLogger(BaseAppium.class.getName());
    public static AppiumDriverLocalService service;
    public static AndroidDriver<WebElement> driver;
    private DesiredCapabilities configCapabilities = new DesiredCapabilities();
    public String type;


    public void init() {

        DesiredCapabilities caps = new DesiredCapabilities();
        // Carga del fichero de propiedades
        PropertyLoader loadproperty = new PropertyLoader();
        type = loadproperty.loadProperties().getProperty("platformName");

        // Set your access credentials
        caps.setCapability("browserstack.user", "rocioseron1");
        caps.setCapability("browserstack.key", "LYKU1xhmKqJpsCeXMyRz");

        // Set URL of the application under test
        caps.setCapability("app", "bs://80a6017b2dcdba74b9757567ff5f200359415969");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "Java Android");
        caps.setCapability("name", "first_test");


        try {
            driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        //driver.quit();


    }



    public static AndroidDriver<WebElement> getDriver() {
        return driver;
    }

    @After
    public void removeApp() throws Exception {


        String bundleID = null;
        if (driver == null) {
            return;
        }

        Map<String, ?> cap = driver.getCapabilities().asMap();

        switch (type) {
            case "Android":
                bundleID = (String) cap.get("appPackage");
                break;
            case "IOS":
                bundleID = (String) cap.get("bundleId");
                break;
        }
        if (bundleID != null) {
            driver.removeApp(bundleID);
            System.out.println("[Driver] Remove APP Appium");
        }

            Runtime.getRuntime().exec("adb kill-server");
            Runtime.getRuntime().exec("taskkill /F /IM adb.exe");

    }


    public void quit()  {
        if (driver != null) {
            driver.quit();
            System.out.println("[Driver] Quit driver Appium");
        }
        if (service.isRunning()) {
            service.stop();
            System.out.println("[Service] Stop service Appium");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
