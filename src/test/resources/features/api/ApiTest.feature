Feature: CMS API Functionality

  Scenario: Retrieve user information
    Given I am authenticated as an admin user
    When I send a GET request to "/api/users/{userId}"
    Then the response status code should be 200
    And the response should contain the user's information

  Scenario: Create a new content item
    Given I am authenticated as a content creator
    When I send a POST request to "/api/content" with the following data:
      | title       | Content API Test            |
      | description | This is a test content item |
      | status      | draft                       |
    Then the response status code should be 201
    And the response should contain the created content item's ID

  Scenario: Update an existing content item
    Given I am authenticated as a content editor
    And there is an existing content item with ID "12345"
    When I send a PUT request to "/api/content/12345" with the following data:
      | title       | Updated Content API Test      |
      | description | This content item was updated |
      | status      | published                     |
    Then the response status code should be 200
    And the response should contain the updated content information

  Scenario: Delete a content item
    Given I am authenticated as an admin user
    And there is an existing content item with ID "12345"
    When I send a DELETE request to "/api/content/12345"
    Then the response status code should be 204

  Scenario: Attempt to access unauthorized resource
    Given I am authenticated as a regular user
    When I send a GET request to "/api/admin/settings"
    Then the response status code should be 403