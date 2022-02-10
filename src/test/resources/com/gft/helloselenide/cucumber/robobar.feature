Feature: Robobar cart
  Scenario: user add one cola
    Given user opens robobar website
    When user adds a cola
    Then total should be €1.25

  Scenario: user add two colas
    Given user opens robobar website
    When user adds a cola
    And user adds a cola
    Then total should be €2.50

  Scenario: underage user adds on beer
    Given user opens robobar website
    When user adds a beer
    And user goes to checkout
    And user puts their age as "17"
    And user confirms the order
    Then alert should be visible