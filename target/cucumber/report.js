$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/login.feature");
formatter.feature({
  "name": "Make login in the mobile application",
  "description": "As a user\nI want to make login in the mobile application",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "we enter to application",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.we_enter_to_application()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Do login in the application",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "we make login with user and password",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.we_make_login_with_user_and_password()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat java.util.Objects.requireNonNull(Objects.java:203)\r\n\tat org.openqa.selenium.support.ui.FluentWait.\u003cinit\u003e(FluentWait.java:106)\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.\u003cinit\u003e(WebDriverWait.java:85)\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.\u003cinit\u003e(WebDriverWait.java:45)\r\n\tat com.appium.stepdefinitions.Login.login(Login.java:21)\r\n\tat com.appium.stepdefinitions.LoginSteps.we_make_login_with_user_and_password(LoginSteps.java:32)\r\n\tat ✽.we make login with user and password(src/test/resources/features/login.feature:9)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "the login is successfull",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.the_login_is_successfull()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});