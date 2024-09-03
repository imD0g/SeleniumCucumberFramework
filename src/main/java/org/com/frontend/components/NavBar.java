package org.com.frontend.components;

import org.com.frontend.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavBar extends BasePage {
    // Locators for common navigation elements
    private final By dashboardLink = By.id("nav-dashboard");
    private final By contentLink = By.id("nav-content");
    private final By usersLink = By.id("nav-users");
    private final By settingsLink = By.id("nav-settings");
    private final By logoutLink = By.id("nav-logout");

    public NavBar(WebDriver driver) {
        super(driver);
    }

    public void navigateToDashboard() {
        clickElement(dashboardLink);
    }

    public void navigateToContent() {
        clickElement(contentLink);
    }

    public void navigateToUsers() {
        clickElement(usersLink);
    }

    public void navigateToSettings() {
        clickElement(settingsLink);
    }

    public void logout() {
        clickElement(logoutLink);
    }

    public boolean isNavBarVisible() {
        return isElementVisible(dashboardLink) &&
                isElementVisible(contentLink) &&
                isElementVisible(usersLink) &&
                isElementVisible(settingsLink) &&
                isElementVisible(logoutLink);
    }

    private boolean isElementVisible(By locator) {
        try {
            return driver.findElement(locator)
                         .isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}