@HomePageTest
Feature: Launch Browser and Test Home Page

  Background: 
    When The user clicks the Get Started button

  @scenario1
  Scenario Outline: User is on Home Page and clicks on any dropdown "<value>" without sign in
    Given user is on Home Page
    When The user clicks on data structure dropdown before signin
    Then The user select any dropdown menu "<option>"
    Then The user should get the error message "You are not logged in"

    Examples: 
      | option      |
      | Arrays      |
      | Linked List |
      | Stack       |
      | Queue       |
      | Tree        |
      | Graph       |

  Scenario Outline: User is on Home Page and clicks on any getStarted link "<value>" without sign in
    Given user is on Home Page
    When The user click any of the Get started link before signin "<value>" in home page
    Then The user should get the error message "You are not logged in"

    Examples: 
      | value                        |
      | Data Structures-Introduction |
      | Arrays                       |
      | Linked List                  |
      | Stack                        |
      | Queue                        |
      | Tree                         |
      | Graph                        |

  @Login
  Scenario: User is on Home page and Clicks on Signin
    Given user is on Home Page
    When user clicks on SignIn button he is directed to login page
    Then user validates the login page

  Scenario: User is on Home page and Clicks on Register
    Given user is on Home Page
    When user clicks on Register button he is directed to register page
    Then user validates the register page

  @RegisterUrl
  Scenario Outline: User is on Home Page and clicks on any getStarted link "<value>" with sign in
    Given user is on Home Page
    When The user click any of the Get started link after signin "<value>" in home page
    Then The user should able to goto its respective page

    Examples: 
      | value                        |
      | Data Structures-Introduction |
      | Array                        |
      | Linked List                  |
      | Stack                        |
      | Queue                        |
      | Tree                         |
      | Graph                        |
