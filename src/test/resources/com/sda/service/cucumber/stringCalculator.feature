Feature:

  Scenario: I can calculate single number
    Given I initialise stringCalculator
    And I pass single number value
    When I trigger calculate function
    Then I get 5 as a result

  Scenario: I can calculate null number
    Given I initialise stringCalculator
    And I pass null value
    When I trigger calculate function
    Then I get 0 as a result

  Scenario: I can calculate blank value
    Given I initialise stringCalculator
    And I pass blank value
    When I trigger calculate function
    Then I get 0 as a result

  Scenario: I can calculate multiple numbers
    Given I initialise stringCalculator
    And I pass multiple values
    When I trigger calculate function
    Then I get 34 as a result

  Scenario: I can calculate multiple numbers typed with white spaces
    Given I initialise stringCalculator
    And I pass multiple values with white spaces
    When I trigger calculate function
    Then I get 17 as a result

#  Scenario Outline: I can calculate multiple numbers
#    Given I initialise stringCalculator
#    And I pass multiple values
#    When I trigger calculate function
#    Then I get 34 as a result
#    Examples:
#      | value  | result |
#      |   |  |
#      |   |  |
#      |   |  |
#      |   |  |