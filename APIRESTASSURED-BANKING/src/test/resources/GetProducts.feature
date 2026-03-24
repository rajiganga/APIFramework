
Feature: Get all products from the API

Scenario: Verify the GET API for products
    Given the GET products API endpoint is available
    When the request is sent to the endpoint
    Then the response status code should be 200