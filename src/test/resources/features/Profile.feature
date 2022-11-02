Feature: Profile page

  Scenario Outline: Login to olx.kz
    When I am on main page
    Then I close the cookies
    And I go to login page
    And I write login "<email>"
    And I write password "<password>"
    Then I click on login button
    Examples:
      | email |password|
      |dmarlambekov@gmail.com |qABVXr@D-*zn78K|