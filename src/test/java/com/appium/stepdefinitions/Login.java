package com.appium.stepdefinitions;

import com.appium.Utilities;
import com.appium.example.BSAppium;
import com.appium.example.BaseAppium;
import com.appium.example.Screen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BSAppium {


    Screen screen = new Screen();
    public Login() {
        PageFactory.initElements(new AppiumFieldDecorator(BSAppium.getDriver()), this);
    }

    @iOSXCUITFindBy(xpath = "(//")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.EditText")
    public MobileElement verificationCodeField;

    @iOSXCUITFindBy(xpath = "(//")
    @AndroidFindBy(xpath = "//*[contains(@text, 'USA')]")
    public MobileElement country_DropDownMenu;



    public void login() {

        Utilities.sleep(5000);
        verificationCodeField.click();
        Utilities.sleep(5000);
        screen.sendKeys(verificationCodeField,"DemoTest");
        //country_DropDownMenu.click();

    }
}
