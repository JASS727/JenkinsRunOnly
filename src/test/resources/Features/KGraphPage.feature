@GraphTest
Feature: Graph page validation

    Background: The user is logged in to DS Algo portal
   	When The user is logged in with valid user id and password
    #Given The user opens DS Algo portal link 
    #When The user clicks the Get Started button
    #And  User is on Login page
    #When User enters valid username "Team" and password "Ninjas123"
    #And User clicks on login button

 @Test_G1
  Scenario Outline: User should be able to navigate to all options in graph page
    Given The user is on the Graph page after logged in
    When User clicks "<options>" link for graph
    Then User directed to "<options>" page for graph

    Examples: 
      | options               |
      | Graph                 |
      | Graph Representations |

 @Test_G2
  Scenario Outline: User should be able to test run valid code in tryEditor
    Given The user is in a "<options>" page for graph having an tryEditor with a Run button to test
    When The user enter valid python code in tryEditor for graph from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on run button for graph
    Then The user should be presented with Run result for graph

    Examples: 
      | options               | Sheetname       | RowNumber |
      | Graph                 | ValidPythonCode |         0 |
      | Graph Representations | ValidPythonCode |         0 |
      
 @Test_G3
  Scenario Outline: User should be able to test run invalid code in tryEditor 
    Given The user is in a "<options>" page for graph having an tryEditor with a Run button to test
    When The user enter python code with invalid syntax in tryEditor  for graph from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on run button for graph
    Then The user should be presented with error message for graph

      Examples:

      | options               | Sheetname         | RowNumber |
      | Graph                 | InvalidPythonCode |         0 |
      | Graph Representations | InvalidPythonCode |         0 |

 @Test_G4
  Scenario: User should be able to navigate to Graph Representations page and click on Practice Questions
    Given The user is on Editor page and navigates to Graph Representations page
    When the user will click on Practice Questions for graph
    Then The user will be directed to Practice page for graph
