package org.com.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        sendKeys(usernameField, username);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void clickLogin() {
        clickElement(loginButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public boolean isNavBarVisible() {
        return getNavBar().isNavBarVisible();
    }

    public void navigateToDashboard() {
        getNavBar().navigateToDashboard();
    }
}