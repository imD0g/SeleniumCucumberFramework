Feature: CMS Login and Navigation Functionality

  Scenario: Successful login with valid credentials
    Given I am on the CMS login page
    When I enter valid username "admin"
    And I enter valid password "password123"
    And I click the login button
    Then I should be logged in successfully
    And I should see the navigation bar

  Scenario: Navigate to different pages after login
    Given I am logged in as an admin user
    When I navigate to the Content page
    Then I should see the Content page
    When I navigate to the Users page
    Then I should see the Users page
    When I navigate to the Settings page
    Then I should see the Settings page

  Scenario: Logout functionality
    Given I am logged in as an admin user
    When I click the logout button
    Then I should be redirected to the login page
    And I should not see the navigation bar

  Scenario Outline: Unsuccessful login with invalid credentials
    Given I am on the CMS login page
    When I enter username "<username>"
    And I enter password "<password>"
    And I click the login button
    Then I should see an error message
    And I should not see the navigation bar

    Examples:
      | username  | password    |
      | admin     | wrongpass   |
      | wronguser | password123 |
      |           | password123 |
      | admin     |             |