Feature: Login Feature

  Scenario: Login Success
    Given I open Login page
    When I enter email "elliott.nance@testpro.io"
    And I enter password "HondaAccord2024$"
    And I submit
    Then I am logged in
