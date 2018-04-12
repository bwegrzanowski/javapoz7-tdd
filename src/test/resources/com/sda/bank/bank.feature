Feature: Bank functionality

  Scenario: I can add user to bank
    Given I initialise bank
    And I create user with name 'Adam Abacki' and pesel '1234'
    When I insert user to bank
    Then user is present in bank

  Scenario: I cannot duplicate users in bank
    Given I initialise bank
    And I create user with name 'Adam Abacki' and pesel '1234'
    When I insert user to bank
    And I insert user to bank
    Then user is not present in bank

  Scenario: I can create account for existing user
    Given I initialise bank
    And I create user with name 'Jan Kowalski' and pesel '1224'
    And I create account with name 'konto oszczednosciowe'
    When I insert user to bank
    And I insert user to bank
    And I insert account to bank
    Then account is present in bank

  Scenario: I can create account for existing user
    Given I initialise bank
    And I create user with name 'Jan Kowalski' and pesel '1224'
    And I create account with name 'konto oszczednosciowe'
    When I insert account to bank
    Then account is not present in bank

