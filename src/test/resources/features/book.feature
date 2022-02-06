Feature: the book can be created
  Scenario Outline: client makes call to GET /book
    Given A book to get
    When the client calls /book <id>
    Then the client receives status code of 200
    Then the client got response <resp>
    Examples:
      | id   | resp |
      | 336  | OK   |
      | 1234 | OK   |