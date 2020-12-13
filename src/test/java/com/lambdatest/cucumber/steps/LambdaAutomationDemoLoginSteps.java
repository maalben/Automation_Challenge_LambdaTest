package com.lambdatest.cucumber.steps;

import com.lambdatest.cucumber.pages.LambdaAutomationDemoLoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class LambdaAutomationDemoLoginSteps {
    LambdaAutomationDemoLoginPage lambdaAutomationDemoLoginPage;

    @Given("^I open page LambdaTest automation demo$")
    public void i_open_page_LambdaTest_automation_demo() {
        lambdaAutomationDemoLoginPage.open();
    }

    @When("^I authenticate me with user \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_authenticate_me_with_user_and_password(String user, String password) {
        lambdaAutomationDemoLoginPage.acceptTermPage();
        lambdaAutomationDemoLoginPage.loginForm(user, password);
    }

    @Then("^I should see the toast text \"([^\"]*)\"$")
    public void i_should_see_the_toast_text(String title) {
        lambdaAutomationDemoLoginPage.verifyLogin(title);
    }
}
