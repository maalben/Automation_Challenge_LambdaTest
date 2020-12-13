package com.lambdatest.cucumber.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static com.lambdatest.util.Util.*;

@DefaultUrl("https://www.lambdatest.com/automation-demos/")
public class LambdaAutomationDemoTabProcessPage extends PageObject {

    public void openTab(String page){
        ((JavascriptExecutor) getDriver()).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        getDriver().get(page);
    }

    public void searchInformationJenkins(String value){
        WebDriverWait myWaitVar = new WebDriverWait(getDriver(), 30);
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='LambdaTest Jenkins integration']")));
        pageDisplace(getDriver(), "Vertical", 3000);
        Actions actions = new Actions(getDriver());
        WebElement titleIntegrations = getDriver().findElement(By.xpath("//h2[text()='"+value+"']"));
        actions.moveToElement(titleIntegrations).build().perform();
        pageDisplace(getDriver(), "Vertical", 500);
    }

    public void downloadLogoJenkins(String value) throws IOException {
        String directory = System.getProperty("user.dir");
        WebElement logo = getDriver().findElement(By.xpath("//img[@alt='LambdaTest Jenkins integration']"));
        File f = logo.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f, new File(directory + "/src/test/resources/image/"+value));
    }

    public void returnTabMain(){
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(0));
        pageDisplace(getDriver(), "Vertical", 500);
    }

    public void closeSecondTab(){
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(0));
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));
    }

}
