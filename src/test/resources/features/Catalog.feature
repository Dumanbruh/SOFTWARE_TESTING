Feature: Catalog page
  @AddCatalog

  Scenario Outline: Search item in Catalog page
    And I choose a category
    And I enter item name "<itemName>"
    And I enter city name "<cityName>"
    Then I click on search button
    Examples:
      |itemName|cityName|
      |Видеокарта|Нур-Султан|
      |Клавиатура|Шымкент|


  Scenario: Add item to favourite
    And user is authorized
    And I go to main page
    And I choose a category
    And I add to favourites

  Scenario Outline: Filter items in Catalog page
    And I choose a category
    And I enter max sum <maxSum>
    And I enter min sum <minSum>
    Examples:
      |maxSum|minSum|
      |5000  |100|

  Scenario: Redirect to Olx for Business page
    When I click the business button

  Scenario: Get Olx app from Google Play
    When I click the google play button

  Scenario: Get Olx app from App Store
    When I click the app store button


