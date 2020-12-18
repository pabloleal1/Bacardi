$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/login.feature");
formatter.feature({
  "line": 1,
  "name": "Make login in the mobile application",
  "description": "As a user\r\nI want to make login in the mobile application",
  "id": "make-login-in-the-mobile-application",
  "keyword": "Feature"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "we are a user",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "we enter to application",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.we_are_a_user()"
});
formatter.result({
  "duration": 138199200,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.we_enter_to_application()"
});
formatter.result({
  "duration": 9287800,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Do login in the application",
  "description": "",
  "id": "make-login-in-the-mobile-application;do-login-in-the-application",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "we make login with user and password",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the login is successfull",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.we_make_login_with_user_and_password()"
});
formatter.result({
  "duration": 220967800,
  "error_message": "java.lang.NullPointerException\r\n\tat com.google.common.base.Preconditions.checkNotNull(Preconditions.java:787)\r\n\tat org.openqa.selenium.support.ui.FluentWait.\u003cinit\u003e(FluentWait.java:96)\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.\u003cinit\u003e(WebDriverWait.java:72)\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.\u003cinit\u003e(WebDriverWait.java:46)\r\n\tat com.appium.example.Login.login(Login.java:12)\r\n\tat com.appium.stepdefinitions.LoginSteps.we_make_login_with_user_and_password(LoginSteps.java:37)\r\n\tat ✽.When we make login with user and password(features/login.feature:10)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "LoginSteps.the_login_is_successfull()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 80700,
  "status": "passed"
});
});