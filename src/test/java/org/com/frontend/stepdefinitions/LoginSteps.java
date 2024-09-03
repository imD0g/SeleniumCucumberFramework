package org.com.frontend.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.com.frontend.config.WebDriverConfig;
import org.com.frontend.pages.DashboardPage;
import org.com.frontend.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Before
    public void setup() {
        driver = WebDriverConfig.getDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @After
    public void tearDown() {
        WebDriverConfig.quitDriver();
    }

    @Given("I am on the CMS login page")
    public void i_am_on_the_cms_login_page() {
        driver.get("https://your-cms-url.com/login");
    }

    @When("I enter valid username {string}")
    public void i_enter_valid_username(String username) {
        loginPage.enterUsername(username);
    }

    @When("I enter valid password {string}")
    public void i_enter_valid_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        assertTrue(driver.getCurrentUrl()
                         .contains("/dashboard"));
    }

    @Then("I should see the navigation bar")
    public void i_should_see_the_navigation_bar() {
        assertTrue(loginPage.isNavBarVisible());
    }

    @Given("I am logged in as an admin user")
    public void i_am_logged_in_as_an_admin_user() {
        i_am_on_the_cms_login_page();
        i_enter_valid_username("admin");
        i_enter_valid_password("password123");
        i_click_the_login_button();
        i_should_be_logged_in_successfully();
    }

    @When("I navigate to the Content page")
    public void i_navigate_to_the_content_page() {
        dashboardPage.navigateToContent();
    }

    @Then("I should see the Content page")
    public void i_should_see_the_content_page() {
        assertTrue(driver.getCurrentUrl()
                         .contains("/content"));
    }

    @When("I navigate to the Users page")
    public void i_navigate_to_the_users_page() {
        dashboardPage.navigateToUsers();
    }

    @Then("I should see the Users page")
    public void i_should_see_the_users_page() {
        assertTrue(driver.getCurrentUrl()
                         .contains("/users"));
    }

    @When("I navigate to the Settings page")
    public void i_navigate_to_the_settings_page() {
        dashboardPage.navigateToSettings();
    }

    @Then("I should see the Settings page")
    public void i_should_see_the_settings_page() {
        assertTrue(driver.getCurrentUrl()
                         .contains("/settings"));
    }

    @When("I click the logout button")
    public void i_click_the_logout_button() {
        dashboardPage.logout();
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        assertTrue(driver.getCurrentUrl()
                         .contains("/login"));
    }

    @Then("I should not see the navigation bar")
    public void i_should_not_see_the_navigation_bar() {
        assertFalse(loginPage.isNavBarVisible());
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        loginPage.enterUsername(username);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        loginPage.enterPassword(password);
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        WebElement errorMessage = driver.findElement(By.id("error-message"));
        assertTrue(errorMessage.isDisplayed(), "Error message should be displayed");
        assertTrue(errorMessage.getText()
                               .contains("Invalid username or password"), "Error message should indicate invalid credentials");
    }
}
