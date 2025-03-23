Feature: Login Functionality

  Scenario Outline: User login with valid credentials
    Given user visits the websites
    When user navigates to the login page and enter username "<username>" and password "<password>"
    Then user can view the product store page
    And browser closes
    Examples:
      | username      | password     |
      | test111       | test111        |

  Scenario Outline: User login with invalid credentials
    Given user visits the websites
    When user navigates to the login page and enter username "<username>" and password "<password>"
    Then user can't view the product store page
    And browser closes
    Examples:
      | username      | password     |
      | test111       | bad_password |
      | bad_user      | test111      |

  Scenario: Login with Empty Fields
    Given user visits the websites
    When user navigates to the login page and leave the username and password fields empty
    And user click the LogIn button
    Then user should see an error message "Please fill out Username and Password."
    And browser closes
