Feature: Upload file Functionality LambdaTest

    Background: Completion login form successfully
        Given I open page LambdaTest automation demo
        When I authenticate me with user "lambda" and password "lambda123"
        Then I should see the toast text "Thank You Successully Login!!"


    @UserStory:US0001
    Scenario: Completion information form successfully
        Given I type my email "maalben@gmail.com"
        And I interactive with alert
        And I choose a frequently purchase "Once in 6 months"
        And I choose decisive factors options "Discounts, Delivery time"
        And I select mode payment "Wallets"
        And I confirm purchase in the last one year
        And I displace rate option until "9"
        And I type feedback "This is a test"
        And I open tab with the url "https://www.lambdatest.com/selenium-automation" waiting load elements page
        And I search logo jenkins in the title "Integrations With CI/CD Tools"
        And I download logo jenkins with the name file "jenkins.svg"
        And I return previous tab
        When I upload image "jenkins.svg" in the page
        Then I confirm the image is upload successfully with the alert message "your image upload sucessfully!!"
        When I confirm completion information form
        Then I should see message "You have successfully submitted the form."
        And I close tab