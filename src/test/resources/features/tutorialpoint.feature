Feature: tutorialspoint seach for selenium
  Scenario: user makes a call to tutorialspoint
    When the client calls https://www.tutorialspoint.com/index.htm
    Then the client types Selenium
    And the client validates output