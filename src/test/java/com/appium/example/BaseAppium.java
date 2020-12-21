package com.appium.example;

import com.utils.PropertyLoader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.After;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.Map;

public class BaseAppium{


    //private Logger logger = Logger.getLogger(BaseAppium.class.getName());
    public static AppiumDriverLocalService service;
    public static AndroidDriver<WebElement> driver;
    private DesiredCapabilities configCapabilities = new DesiredCapabilities();
    public String type;



    public void init() {

        // Carga del fichero de propiedades
        PropertyLoader loadproperty = new PropertyLoader();
        type = loadproperty.loadProperties().getProperty("platformName");

        //System.out.println(loadproperty.loadProperties());
        // Recuperación del fichero de propiedades de la ruta y nombre de la aplicación móvil
        String appiumON = System.getProperty("appiumON");
        String device = System.getProperty("device");

        // Generación de las capabilites a nivel del servicio de Appium
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);

        // Generación de las capabilites a nivel de driver
        DesiredCapabilities clientCapabilities = new DesiredCapabilities();
        clientCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        clientCapabilities.setCapability(MobileCapabilityType.UDID, device);
        clientCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        //clientCapabilities.setCapability(MobileCapabilityType. "Android Device");


        File app = new File(loadproperty.loadProperties().getProperty("apkDir"), loadproperty.loadProperties().getProperty("apkName"));

        desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        // Appium service
        AppiumServiceBuilder builder = new AppiumServiceBuilder().withCapabilities(desiredCapabilities)
                .withIPAddress(loadproperty.loadProperties().getProperty("AppiumServerIP"))
                .usingPort(Integer.valueOf(loadproperty.loadProperties().getProperty("AppiumServerPort")).intValue());
        System.out.println("EEOOOO "+builder);

        service = builder.build();
        service.start();
        driver = new AndroidDriver(service.getUrl(), clientCapabilities);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

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

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
