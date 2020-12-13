package com.lambdatest.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

    public static void waitingFor(long length) {
        length = length * 1000;
        try {
            Thread.sleep(length);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void selectElementDynamic(String texts, String valueElementCss, WebDriver driver) {
        List<String> listValues = new ArrayList<>();
        listValues.addAll(Arrays.asList(texts.split(",")));

        List<WebElement> container  = driver.findElements(By.xpath("//div[@class='"+valueElementCss+"']/p"));

        for(int i=0; i<container.size(); i++) {
            for (int k = 0; k<listValues.size(); k++){
                if(container.get(i).getText().trim().equals(listValues.get(k).trim())) {
                    driver.findElement(By.xpath("//div[@class='"+valueElementCss+"']/p["+(i+1)+"]/label/input")).click();
                }
            }
        }
    }

    public static void elementSelectList(String text, WebDriver driver) {
        List<WebElement> container = driver.findElements(By.xpath("//select//option"));
        for(int i=0; i<container.size(); i++) {
            if(container.get(i).getText().trim().equals(text)) {
                container.get(i).click();
                break;
            }
        }
    }

    public static void pageDisplace(WebDriver getDriver, String direction, int moveToPixels) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver;
        switch(direction) {
            case "Horizontal":
                js.executeScript("window.scrollBy("+moveToPixels+",0)");
                break;
            case "Vertical":
                js.executeScript("window.scrollBy(0,"+moveToPixels+")");
                break;
        }
    }

    public static void movedSlideTo(int value, WebElement element, WebDriver driver){
        int x;
        switch (value){

            case 1:
                x = -250;
                break;

            case 2:
                x = -200;
                break;

            case 3:
                x = -150;
                break;

            case 4:
                x = -100;
                break;

            case 5:
                x = -50;
                break;

            case 6:
                x = 50;
                break;

            case 7:
                x = 100;
                break;

            case 8:
                x = 150;
                break;

            case 9:
                x = 200;
                break;

            case 10:
                x = 250;
                break;

            default:
                x = 0;
                break;
        }

        Actions moveSlider = new Actions(driver);
        Action action = moveSlider.dragAndDropBy(element, x, 0).build();
        action.perform();
    }

}
