package com.lambdatest.cucumber.steps;

import com.lambdatest.cucumber.pages.LambdaAutomationDemoCompletionFormPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LambdaAutomationDemoCompletionFormSteps {

    LambdaAutomationDemoCompletionFormPage lambdaAutomationDemoCompletionFormPage;

    @Given("^I type my email \"([^\"]*)\"$")
    public void i_type_my_email(String email) {
        lambdaAutomationDemoCompletionFormPage.typeEmail(email);
    }

    @Given("^I interactive with alert$")
    public void i_interactive_with_alert() {
        lambdaAutomationDemoCompletionFormPage.interactiveWithAlert();
    }


    @Given("^I choose a frequently purchase \"([^\"]*)\"$")
    public void i_choose_a_frequently_purchase(String value) {
        lambdaAutomationDemoCompletionFormPage.completeFrequentlyPurchaseUser(value);
    }

    @Given("^I choose decisive factors options \"([^\"]*)\"$")
    public void i_choose_decisive_factors_options(String value) {
        lambdaAutomationDemoCompletionFormPage.completeDecisiveFactorsUser(value);
    }

    @Given("^I select mode payment \"([^\"]*)\"$")
    public void i_select_mode_payment(String value) {
        lambdaAutomationDemoCompletionFormPage.completeModePayment(value);
    }

    @Given("^I confirm purchase in the last one year$")
    public void i_confirm_purchase_in_the_last_one_year() {
        lambdaAutomationDemoCompletionFormPage.completePurchaseOneYear();
    }

    @Given("^I displace rate option until \"([^\"]*)\"$")
    public void i_displace_rate_option_until(String value) {
        lambdaAutomationDemoCompletionFormPage.selectValueSlide(value);
    }

    @Given("^I type feedback \"([^\"]*)\"$")
    public void i_type_feedback(String value) {
        lambdaAutomationDemoCompletionFormPage.completeFeedbackField(value);
    }


    @When("^I upload image \"([^\"]*)\" in the page$")
    public void i_upload_image_in_the_page(String value) {
        lambdaAutomationDemoCompletionFormPage.uploadImageLogoJenkins(value);
    }

    @Then("^I confirm the image is upload successfully with the alert message \"([^\"]*)\"$")
    public void i_confirm_the_image_is_upload_successfully_with_the_alert_message(String message) {
        lambdaAutomationDemoCompletionFormPage.confirmUploadImage(message);
    }

    @When("^I confirm completion information form$")
    public void i_confirm_completion_information_form() {
        lambdaAutomationDemoCompletionFormPage.confirmCompletionForm();
    }

    @Then("^I should see message \"([^\"]*)\"$")
    public void i_should_see_message(String messageValidation) {
        lambdaAutomationDemoCompletionFormPage.validateCompletionForm(messageValidation);
    }


}
