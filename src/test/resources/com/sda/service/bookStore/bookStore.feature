Feature: Test cases for bookstore

  Scenario: I can add a book on to the list
    Given I instantiate bookstore
    And I create book
    When I add book to the bookstore
    Then Book is present in bookstore

  Scenario: I can edit a book title from bookstore
    Given I instantiate bookstore
    And I create book
    When I add book to the bookstore
    And I edit title of the book
    Then The book title has been changed