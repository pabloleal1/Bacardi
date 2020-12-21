$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/login.feature");
formatter.feature({
  "name": "illegal age",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "creation account with illegal age",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "verify Freepour APP is pre-installed using \u003cuser\u003e role",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.we_enter_to_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we make login with user and password",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.we_make_login_with_user_and_password()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});