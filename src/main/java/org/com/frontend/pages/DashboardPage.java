package org.com.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    private final By welcomeMessage = By.id("welcome-message");
    private final By recentActivitySection = By.id("recent-activity");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeMessage() {
        return getText(welcomeMessage);
    }

    public boolean isRecentActivityVisible() {
        return waitForElementToBeVisible(recentActivitySection).isDisplayed();
    }

    public void navigateToContent() {
        getNavBar().navigateToContent();
    }

    public void navigateToUsers() {
        getNavBar().navigateToUsers();
    }

    public void navigateToSettings() {
        getNavBar().navigateToSettings();
    }

    public void logout() {
        getNavBar().logout();
    }
}