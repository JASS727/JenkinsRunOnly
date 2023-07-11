@TreeTest
Feature: Test Tree Page

  Background: The user is logged in to DS Algo portal
   	When The user is logged in with valid user id and password
    #Given The user opens DS Algo portal link
    #When The user clicks the Get Started button
    #And User is on Login page
    #When User enters valid username "Team" and password "Ninjas123"
    #And User clicks on login button

  Scenario Outline: The user is able to navigate to all options in tree page
    Given The user is on the "Tree" tree page after logged in
    When The user clicks "<options>" button in tree page
    Then The user in  "<options>" page

    Examples: 
      | options                        |
      | Overview of Trees              |
      | Terminologies                  |
      | Types of Trees                 |
      | Tree Traversals                |
      | Traversals-Illustration        |
      | Binary Trees                   |
      | Types of Binary Trees          |
      | Implementation in Python       |
      | Binary Tree Traversals         |
      | Implementation of Binary Trees |
      | Applications of Binary trees   |
      | Binary Search Trees            |
      | Implementation Of BST          |

  Scenario Outline: The user is able to navigate to all options in tree page
    Given The user is on the "Tree" tree page after logged in
    When The user clicks "<options>" button in tree page
    And The user clicks tryEditor with a Run button to test on tree page
    Then The user in "tryEditor" page

    Examples: 
      | options                        |
      | Overview of Trees              |
      | Terminologies                  |
      | Types of Trees                 |
      | Tree Traversals                |
      | Traversals-Illustration        |
      | Binary Trees                   |
      | Types of Binary Trees          |
      | Implementation in Python       |
      | Binary Tree Traversals         |
      | Implementation of Binary Trees |
      | Applications of Binary trees   |
      | Binary Search Trees            |
      | Implementation Of BST          |

  Scenario Outline: The user is able tree run code in tryEditor
    Given The user is in a "<options>" tree page having an tryEditor with a Run button to test
    When The user enter valid python code in tree tryEditor from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on tree run button
    Then The user should be presented with Run result of tree

    Examples: 
      | options                        | Sheetname | RowNumber |
      | Overview of Trees              | array     |         0 |
      | Terminologies                  | array     |         0 |
      | Types of Trees                 | array     |         0 |
      | Tree Traversals                | array     |         0 |
      | Traversals-Illustration        | array     |         0 |
      | Binary Trees                   | array     |         0 |
      | Types of Binary Trees          | array     |         0 |
      | Implementation in Python       | array     |         0 |
      | Binary Tree Traversals         | array     |         0 |
      | Implementation of Binary Trees | array     |         0 |
      | Applications of Binary trees   | array     |         0 |
      | Binary Search Trees            | array     |         0 |
      | Implementation Of BST          | array     |         0 |

  @Test01
  Scenario Outline: The user is able run code in tryEditor
    Given The user is in a "<options>" tree page having an tryEditor with a Run button to test
    When The user enter python code with invalid syntax in tree tryEditor from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on tree run button
    Then The user should be presented with error message in tree page

    Examples: 
      | options                        | Sheetname | RowNumber |
      | Overview of Trees              | array     |         1 |
      | Terminologies                  | array     |         1 |
      | Types of Trees                 | array     |         1 |
      | Tree Traversals                | array     |         1 |
      | Traversals-Illustration        | array     |         1 |
      | Binary Trees                   | array     |         1 |
      | Types of Binary Trees          | array     |         1 |
      | Implementation in Python       | array     |         1 |
      | Binary Tree Traversals         | array     |         1 |
      | Implementation of Binary Trees | array     |         1 |
      | Applications of Binary trees   | array     |         1 |
      | Binary Search Trees            | array     |         1 |
      | Implementation Of BST          | array     |         1 |

  Scenario: The user is able to navigate to Practice page
    Given The user is on the type of tree after logged in
    When The user clicks tree Practice Questions link
    Then The user should be redirected to "practice" page in tree
