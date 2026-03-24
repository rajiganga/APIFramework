
Feature: Add all products from the API

Scenario Outline: Verify the Add products API
    Given hit the url of the add product api endpoint
    When add products url is passed in the request
    When pass the request body with product Title "<ProductTitle>"
    Then verify whether the response status code is 201
    
    Example:
  |ProductTitle|
      Shoes
    