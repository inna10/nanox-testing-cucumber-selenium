Feature: Login Functionality

  Scenario Outline: User login with valid credentials
    Given user visits the websites
    When user navigates to the login page and enter username "<username>" and password "<password>"
    Then user can view the product store page
    And browser closes
    Examples:
      | username      | password     |
      | test111       | test111        |

