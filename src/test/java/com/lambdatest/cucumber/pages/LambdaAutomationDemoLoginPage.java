package com.lambdatest.cucumber.pages;

import static org.assertj.core.api.Assertions.assertThat;

import net.serenitybdd.core.webdriver.driverproviders.ProvidedDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@DefaultUrl("https://www.lambdatest.com/automation-demos/")
public class LambdaAutomationDemoLoginPage extends PageObject {

    @FindBy(xpath = "//div[@class='col-sm-3']/a[@class='cbtn btn_accept_ck']")
    WebElementFacade acceptTerm;

    @FindBy(id = "username")
    WebElementFacade usuario;

    @FindBy(id = "password")
    WebElementFacade password;

    @FindBy(css = ".applynow")
    WebElementFacade buttonLogin;

    @FindBy(xpath = "//div[@class='toast jam']")
    WebElementFacade toastLogin;

    public void acceptTermPage() {
        acceptTerm.click();
    }

    public void loginForm(String user, String pass){
        usuario.click();
        usuario.sendKeys(user);
        password.click();
        password.sendKeys(pass);
        buttonLogin.click();
    }

    public void verifyLogin(String title){
        WebDriverWait myWaitVar = new WebDriverWait(this.getDriver(), 30);
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast jam']")));
        assertThat(toastLogin.getText().trim()).containsIgnoringCase(title);
    }

}
