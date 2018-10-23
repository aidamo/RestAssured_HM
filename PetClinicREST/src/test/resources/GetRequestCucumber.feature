Feature: GET request and POST request and PUT request and DELETE request

  Scenario: User calls web services in order to get all pet types
    Given I have acces to perform GET request
    When I perform a GET request to "/pettypes"
    Then I will have status code "200"

    Scenario: User calls web services in order to add new pet type
      Given I have access to perform POST request
      When I perform a POST request to "/pettypes"
      Then I will have status code "201"

Scenario: User calls web services in order to update pet types
Given I have access to perform PUT request
When I perform a PUT request to "/pettypes/{petTypeID}"
Then I will have the status code "204"

Scenario: User calls web services in order to delete pet type
Given I have access to perform DELETE request
When I perform a DELETE request to "/pettypes/{petTypeID}"
Then I will have the status code "204"
