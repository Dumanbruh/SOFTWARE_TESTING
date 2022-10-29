Feature: Profile page

  Scenario: Login to olx.kz
    When I am on main page
    Then I close the cookies
    And I go to login page
    And I write login "dmarlambekov@gmail.com"
    And I write password "qABVXr@D-*zn78K"
    Then I click on login button