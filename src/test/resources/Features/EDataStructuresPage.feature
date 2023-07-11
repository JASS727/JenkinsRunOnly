@dataStructurePage
Feature: Data Structure page validation dsalgo

  Background: User  Login with  valid "username" and "password"
  	When The user is logged in with valid user id and password
    #When The user clicks the Get Started button
    #And user clicks on SignIn button he is directed to login page
    #When User enters valid username "Team" and password "Ninjas123"
    #And User clicks on login button
    #Then It should navigate to the home page with a message " You are logged in  "

  Scenario: User clicks on datastructure page and checks with valid python code
    Given user is on Home Page
    When user clicks on datastructure getstarted
    Then user redirected to page with title "Data Structures-Introduction"
    When user click on Time Complexity
    Then It should navigate to corresponding page with title "Time Complexity"
    When user click on Try here
    Then It should navigate to corresponding page with title "Assessment"
    When user enter the Python code
      | print"DataStructure Introduction" |
    When user clicks run button and goes to home page

  Scenario: User clicks on datastructure page and checks with invalid python code
    Given user is on Home Page
    When user clicks on datastructure getstarted
    Then user redirected to page with title "Data Structures-Introduction"
    When user click on Time Complexity
    Then It should navigate to corresponding page with title "Time Complexity"
    When user click on Try here
    Then It should navigate to corresponding page with title "Assessment"
    When user enter the invalid Python code
      | println"DataStructure Introduction" |
    When user clicks run button
    Then user should get the alert message with text "SyntaxError: bad input on line 1"
    And user accepts the error
