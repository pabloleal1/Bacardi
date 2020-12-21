package com.appium.stepdefinitions;

import bean.User;
import com.appium.example.BSAppium;
import com.appium.example.BaseAppium;
import com.utils.PropertyLoader;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class LoginSteps {


    @Given("^verify Freepour APP is pre-installed using <user> role$")
    public void we_enter_to_application() {
        BSAppium baseAppium = new BSAppium();
        try {
            baseAppium.init();
        } catch (Exception e) {
            System.out.println("Error connecting to Appium Service. Error :" + e.getMessage());
        }
    }

    @When("^we make login with user and password$")
    public void we_make_login_with_user_and_password() {
        Login login = new Login();
        login.login();    }


    @After
    public void close() {
        BaseAppium baseAppium = new BaseAppium();
        baseAppium.tearDown();
    }

}
