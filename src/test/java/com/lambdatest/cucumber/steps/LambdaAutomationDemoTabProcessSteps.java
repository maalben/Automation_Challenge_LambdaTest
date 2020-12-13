package com.lambdatest.cucumber.steps;

import com.lambdatest.cucumber.pages.LambdaAutomationDemoTabProcessPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.io.IOException;

public class LambdaAutomationDemoTabProcessSteps {

    LambdaAutomationDemoTabProcessPage lambdaAutomationDemoTabProcessPage;

    @Given("^I open tab with the url \"([^\"]*)\" waiting load elements page$")
    public void i_open_tab_with_the_url_waiting_load_elements_page(String page) {
        lambdaAutomationDemoTabProcessPage.openTab(page);
    }

    @Given("^I search logo jenkins in the title \"([^\"]*)\"$")
    public void i_search_logo_jenkins_in_the_title(String value) {
        lambdaAutomationDemoTabProcessPage.searchInformationJenkins(value);
    }

    @Given("^I download logo jenkins with the name file \"([^\"]*)\"$")
    public void i_download_logo_jenkins_with_the_name_file(String fileName) throws IOException {
        lambdaAutomationDemoTabProcessPage.downloadLogoJenkins(fileName);
    }

    @Given("^I return previous tab$")
    public void i_return_previous_tab() {
        lambdaAutomationDemoTabProcessPage.returnTabMain();
    }

    @Then("^I close tab$")
    public void i_close_tab() {
        lambdaAutomationDemoTabProcessPage.closeSecondTab();
    }

}
