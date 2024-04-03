@test
Feature: End to End Test of the GoRest API
  
  This is a demo endpoint use to practice the API Automation

  Scenario: Validate POST API status code and ID
    Given I hit the url of POST API endpoint
    When I pass the POST url in the request with token
    And I pass the request body with POST method
    And I receive the response code as 201
    Then I receive the response body with ID
    
    Scenario: Validate GET API status code and response body
    Given I hit the url of the GET API endpoint
    When I pass the GET url in the request with ID and token
    And I receive the response code as 200
    Then I receive the response body with the response

  Scenario: Validate PUT API status code and response body
    Given I hit the url of the PUT API endpoint
    When I pass the PUT url in the request with ID and token
    And I pass the request body with PUT method
    And I receive the response code as 200
    Then I receive the response body with updated details

  Scenario Outline: Validate GET API status code and response body
    Given I hit the url of the GET API endpoint
    When I pass the GET url in the request with ID and token
    And I receive the response code as 200
    Then I receive the response body with updated details
    
  Scenario: Validate DELETE API status code and response body
    Given I hit the url of the DELETE API endpoint
    When I pass the DELETE url in the request with ID and token
    Then I receive the response code as 204