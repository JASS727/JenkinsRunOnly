@QueueTest
Feature: Queue page Validation

  Background: User  Login with  valid "username" and "password"
   	When The user is logged in with valid user id and password
    #When The user clicks the Get Started button
    #And user clicks on SignIn button he is directed to login page
    #When User enters valid username "Team" and password "Ninjas123"
    #And User clicks on login button
    #Then It should navigate to the home page with a message " You are logged in  "
    
@Test_queue_01
  Scenario: The user is able to navigate to Queue Data Structure Page
    Given The user is on homepage
    When The user clicks the queue item from the drop down menu
    Then The user be directed to Queue Data Structure Page

@Test_queue_02
  Scenario Outline: The user is able to navigate to all options in queue page
    Given The user is on the Queue page after logged in
    When The user clicks "<options>" link
    Then The user directed to "<options>" page 

    Examples: 
      | options                                |
      | Implementation of Queue in Python      |
      | Implementation using collections.deque |
      | Implementation using array             |
      | Queue Operations                       |


  @Test_queue_03
  Scenario Outline: The user is able to test run valid code in tryEditor
    Given The user is in a "<options>" page for queue having an tryEditor with a Run button to test
    When The user enter valid python code in tryEditor for queue from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on run button for queue
    Then The user should be presented with Run result for queue

    Examples: 
      | options                                | Sheetname       | RowNumber |
      | Implementation of Queue in Python      | ValidPythonCode |         0 |
      | Implementation using collections.deque | ValidPythonCode |         0 |
      | Implementation using array             | ValidPythonCode |         0 |
      | Queue Operations                       | ValidPythonCode |         0 |

  @Test_queue_04
  Scenario Outline: The user is able to test run invlid code in tryEditor
    Given The user is in a "<options>" page for queue having an tryEditor with a Run button to test
    When The user enter python code with invalid syntax in tryEditor  for queue from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on run button for queue
    Then The user should be presented with error message for queue

    Examples: 
      | options                                | Sheetname         | RowNumber |
      | Implementation of Queue in Python      | InvalidPythonCode |         0 |
      | Implementation using collections.deque | InvalidPythonCode |         0 |
      | Implementation using array             | InvalidPythonCode |         0 |
      | Queue Operations                       | InvalidPythonCode |         0 |

  @Test_queue_05
  Scenario: The user is able to navigate to QueueOp page and click on Practice Questions
    Given The user is on Editor page and navigates to QueueOp page
    When the user clicks on Practice Questions
    Then The user is directed to Practice page
