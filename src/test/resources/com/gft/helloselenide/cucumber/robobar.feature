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

  Scenario: overage user adds on beer
    Given user opens robobar website
    When user adds a beer
    And user goes to checkout
    And user puts their age as "19"
    And user confirms the order
    Then alert should be "Coming right up! ~bzzzt~"

  Scenario: user buys several drinks
    Given user opens robobar website
    Then user adds a cola and a beer
    Then total should be €3.25

  Scenario Outline: user buys several colas
    Given user opens robobar website
    Then user adds <n> colas
    Then total should be €<total>
    Examples:
      | n | total |
      | 1 | 1.25  |
      | 2 | 2.50  |
      | 3 | 3.75  |
      | 4 | 5.00  |

  Scenario Outline: user buys several beers
    Given user opens robobar website
    When user adds <n> beers
    Then total should be €<total>
    Examples:
      | n | total |
      | 1 | 2.00  |
      | 2 | 4.00  |

  Scenario Outline: user buys several wines
    Given user opens robobar website
    When user adds <n> wines
    Then total should be €<total>
    Examples:
      | n | total |
      | 1 | 3.00  |
      | 2 | 6.00  |

  Scenario Outline: user buy several drinks
    Given user opens robobar website
    When user adds <cola> colas
    And user adds <beer> beers
    Then total should be €<total>
    Examples:
      | cola | beer | total |
      | 1    | 0    | 1.25  |
      | 0    | 1    | 2.00  |
      | 1    | 1    | 3.25  |


