Feature: Catalog page

  Scenario: Search item in Catalog page
    And I choose a category
    And I enter item name "Видеокарта"
    And I enter city name "Нурсултан"
    When I click on search button
    Then Items list should update

  Scenario: Add item to favourite
    And user is authorized
    And I go to main page
    And I choose a category
    And I add to favourites

  Scenario: Filter items in Catalog page
    And I choose a category
    And I enter max sum 5000
    And I enter min sum 100
