package org.com.frontend.pages;

import org.com.frontend.components.NavBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected NavBar navBar;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.navBar = new NavBar(driver);
    }

    protected WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void clickElement(By locator) {
        waitForElementToBeClickable(locator).click();
    }

    protected void sendKeys(By locator, String text) {
        waitForElementToBeVisible(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForElementToBeVisible(locator).getText();
    }

    public NavBar getNavBar() {
        return navBar;
    }
}