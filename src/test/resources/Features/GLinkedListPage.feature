@LinkedListPage
Feature: user validates the Linked List Page

  Background: User  Login with  valid "username" and "password"
    When The user is logged in with valid user id and password

  #When The user clicks the Get Started button
  #And user clicks on SignIn button he is directed to login page
  #When User enters valid username "Team" and password "Ninjas123"
  #And User clicks on login button
  #Then It should navigate to the home page with a message " You are logged in  "
  @pageverification
  Scenario: User selects the Linked List item and verifies the Page Title
    Given user is on Home Page
    And user clicks the Linked List getstart link
    Then user is on the Linked List Page
    And user checks for the title "Linked List" in the Linked List page

  @validpythoncode
  Scenario Outline: User checks each of the topics in Linked List with valid python code
    Given user clicks the Linked List getstart link
    When The user select all option "<option>" and Verifies the tryeditor Page with the valid python code for each option  "<sheetName>" and <Rownumber>
    Then user should be presented with the run result

    Examples: 
      | option                          | sheetName     | Rownumber |
      | Introduction                    | LLCLinkedList |         0 |
      | Creating Linked LIst            | LLCLinkedList |         0 |
      | Types of Linked list            | LLCLinkedList |         0 |
      | Implement Linked List in Python | LLCLinkedList |         0 |
      | Traversal                       | LLCLinkedList |         0 |
      | Insertion                       | LLCLinkedList |         0 |
      | Deletion                        | LLCLinkedList |         0 |

  @invalidpythoncode
  Scenario Outline: User checks each of the topics in Linked List with invalid python code
    Given user clicks the Linked List getstart link
    When The user select all option "<option>" and Verifies the tryeditor Page with the Invalid python code for each option  "<sheetName>" and <Rownumber>
    Then user should get the "<erroroutput>"

    Examples: 
      | option                          | sheetName     | Rownumber | erroroutput                    |
      | Introduction                    | LLCLinkedList |         1 | SyntaxError: bad input on line |
      | Creating Linked LIst            | LLCLinkedList |         1 | SyntaxError: bad input on line |
      | Types of Linked list            | LLCLinkedList |         1 | SyntaxError: bad input on line |
      | Implement Linked List in Python | LLCLinkedList |         1 | SyntaxError: bad input on line |
      | Traversal                       | LLCLinkedList |         1 | SyntaxError: bad input on line |
      | Insertion                       | LLCLinkedList |         1 | SyntaxError: bad input on line |
      | Deletion                        | LLCLinkedList |         1 | SyntaxError: bad input on line |

  @practice
  Scenario Outline: The user is able to navigate to Practice page
    Given user clicks the Linked List getstart link
    Then The user select all option "<option>"
    And The User is on the "<option>" page
    When The user clicks Practice Questions "Practice Questions" link
    Then The user should be redirected to "practice" page and verifies the Url "https://dsportalapp.herokuapp.com/linked-list/practice"

    Examples: 
      | option                          |
      | Introduction                    |
      | Creating Linked LIst            |
      | Types of Linked list            |
      | Implement Linked List in Python |
      | Traversal                       |
      | Insertion                       |
      | Deletion                        |
