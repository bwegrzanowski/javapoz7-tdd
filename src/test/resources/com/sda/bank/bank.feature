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

  Scenario: I can not create account for non existing user in bank
    Given I initialise bank
    And I create user with name 'Jan Kowalski' and pesel '1224'
    And I create account with name 'konto oszczednosciowe'
    When I insert account to bank
    Then account is not present in bank

  Scenario: I cannot create accounts with existing account's name for existing user
    Given I initialise bank
    And I create user with name 'Arnold Schwarzenegger' and pesel '3224'
    And I create account with name 'konto oszczednosciowe'
    When I insert user to bank
    And I insert account to bank
    And I insert account to bank
    Then User has only '1' account in bank

  Scenario: I can deposit some money on existing account
    Given I mock bank database for this case
    And I initialise bank
    And I create user with name 'Arnold Schwarzenegger' and pesel '3224'
    And I create account with name 'testowe konto'
    When I insert user to bank
    And I insert account to bank
    And I deposit '1000' to account with name 'testowe konto'
    Then Account with name 'testowe konto' has amount of '1000'
