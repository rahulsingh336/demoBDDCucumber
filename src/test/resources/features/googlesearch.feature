Feature: Google search can be done for rahulsingh336
  Scenario: user makes a call to google search engine
    When the client calls https://www.google.com/
    Then the client types rahulsingh336
    And the client validates output