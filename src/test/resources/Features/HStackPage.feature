@StackTest
Feature: Test Stack Page

  Background: The user is logged in to DS Algo portal
   	When The user is logged in with valid user id and password
    #Given The user opens DS Algo portal link
    #When The user clicks the Get Started button
    #And User is on Login page
    #When User enters valid username "Team" and password "Ninjas123"
    #And User clicks on login button

  Scenario Outline: The user is able to navigate to all options in stack page
    Given The user is on the "Stack" page after logged in
    When The user clicks "<options>" button in stack page
    Then The user in  "<options>" page

    Examples: 
      | options             |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  Scenario Outline: The user is able to navigate to all options in stack page
    Given The user is on the "Stack" page after logged in
    When The user clicks "<options>" button in stack page
    And The user clicks tryEditor with a Run button to test on stack page
    Then The user in "tryEditor" page

    Examples: 
      | options             |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  Scenario Outline: The user is able stack run code in tryEditor
    Given The user is in a "<options>" stack page having an tryEditor with a Run button to test
    When The user enter valid python code in stack tryEditor from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on stack run button
    Then The user should be presented with Run result of stack

    Examples: 
      | options             | Sheetname      | RowNumber |
      | Operations in Stack | array          |         0 |
      | Implementation      | list           |         0 |
      | Implementation      | basicoperation |         0 |

  Scenario Outline: The user is able run code in tryEditor
    Given The user is in a "<options>" stack page having an tryEditor with a Run button to test
    When The user enter python code with invalid syntax in stack tryEditor from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on stack run button
    Then The user should be presented with error message in stack page

    Examples: 
      | options             | Sheetname      | RowNumber |
      | Operations in Stack | array          |         1 |
      | Implementation      | list           |         1 |
      | Implementation      | basicoperation |         1 |
