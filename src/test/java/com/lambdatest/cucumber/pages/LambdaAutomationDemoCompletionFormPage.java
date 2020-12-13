package com.lambdatest.cucumber.pages;

import static com.lambdatest.util.Util.*;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@DefaultUrl("https://www.lambdatest.com/automation-demos/")
public class LambdaAutomationDemoCompletionFormPage extends PageObject {

    @FindBy(name = "email")
    WebElementFacade email;

    @FindBy(id = "populate")
    WebElementFacade btnPopulate;

    @FindBy(id = "tried-ecom")
    WebElementFacade chkPurchaseOneYear;

    @FindBy(id = "comments")
    WebElementFacade txtFieldFeedback;

    @FindBy(id = "submit-button")
    WebElementFacade btnsubmit;

    public void typeEmail(String myEmail){
        email.click();
        email.sendKeys(myEmail);
        btnPopulate.click();
        waitingFor(3);
    }

    public void interactiveWithAlert(){
        Alert alert = this.getDriver().switchTo().alert();
        alert.accept();
    }

    public void completeFrequentlyPurchaseUser(String value){
        selectElementDynamic(value, "radio-button", this.getDriver());
    }

    public void completeDecisiveFactorsUser(String value){
        selectElementDynamic(value, "checkbox", this.getDriver());
    }

    public void completeModePayment(String value){
        elementSelectList(value, this.getDriver());
    }

    public void completePurchaseOneYear(){
        chkPurchaseOneYear.click();
        pageDisplace(this.getDriver(), "Vertical", 200);
    }

    public void selectValueSlide(String value){
        movedSlideTo(9, getDriver().findElement(By.id("slider")), getDriver());
    }

    public void completeFeedbackField(String value){
        txtFieldFeedback.click();
        txtFieldFeedback.sendKeys(value);
    }

    public void uploadImageLogoJenkins(String value){
        WebElement uploadElement = getDriver().findElement(By.id("file"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].removeAttribute('style','style')",uploadElement);

        String directory = System.getProperty("user.dir");
        String filePath = directory + "/src/test/resources/image/"+value;

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'display:none;')",uploadElement);

        uploadElement.sendKeys(filePath);
    }

    public void confirmUploadImage(String messageValidation){
        Alert validationAlertImage = getDriver().switchTo().alert();
        assertEquals(messageValidation, validationAlertImage.getText());
        validationAlertImage.accept();
    }

    public void confirmCompletionForm(){
        btnsubmit.click();
        pageDisplace(getDriver(), "Vertical", -500);
    }

    public void validateCompletionForm(String message){
        WebElement expectedMessage = getDriver().findElement(By.xpath("//div[@id='message']/p"));
        assertEquals(message, expectedMessage.getText());
    }

}
