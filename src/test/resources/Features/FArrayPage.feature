@ArrayTest
Feature: Test Array page

  Background: The user is logged in to DS Algo portal
  	Given The user is logged in with valid user id and password
    #Given The user opens DS Algo portal link
    #When The user clicks the Get Started button
    #And User is on Login page
    #When User enters valid username "sdet" and password "sdet1234"
    #And User clicks on login button

  Scenario Outline: The user is able to navigate to all options in array page
    Given The user is on the "Array" after logged in
    When The user clicks "<options>" button
    Then The user in  "<options>" page

    Examples: 
      | options                   |
      | Arrays in Python          |
      | Arrays Using List         |
      | Basic Operations in Lists |
      | Applications of Array     |

  Scenario Outline: The user is able run code in tryEditor
    Given The user is in a "<options>" page having an tryEditor with a Run button to test
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on run button
    Then The user should be presented with Run result

    Examples: 
      | options                   | Sheetname      | RowNumber |
      | Arrays in Python          | array          |         0 |
      | Arrays Using List         | list           |         0 |
      | Basic Operations in Lists | basicoperation |         0 |
      | Applications of Array     | application    |         0 |

  Scenario Outline: The user is able run code in tryEditor
    Given The user is in a "<options>" page having an tryEditor with a Run button to test
    When The user enter python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on run button
    Then The user should be presented with error message

    Examples: 
      | options                   | Sheetname      | RowNumber |
      | Arrays in Python          | array          |         1 |
      | Arrays Using List         | list           |         1 |
      | Basic Operations in Lists | basicoperation |         1 |
      | Applications of Array     | application    |         1 |

  Scenario: The user is able to navigate to Practice page
    Given The user is on the Arrays in Python after logged in
    When The user clicks Practice Questions link
    Then The user should be redirected to "practice" page

  Scenario Outline: The user is able to navigate to all practice questions
    Given The user is on the Arrays in Python after logged in
    When The user clicks Practice Questions link
    Then The user should be redirected to "practice" page
    And The user should redirect to "<options>" practice question page

    Examples: 
      | options                                 | Sheetname        | RowNumber |
      | Search the array                        | practicequestion |         0 |
      | Max Consecutive Ones                    | practicequestion |         1 |
      | Find Numbers with Even Number of Digits | practicequestion |         2 |
      | Squares of a Sorted Array               | practicequestion |         3 |

  Scenario Outline: The user is able to run code in Practice session of Array in python
    Given The user is in a "<options>"  practice page having an tryEditor with a Run button to test
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on run button
    Then The user should be presented with Run result

    Examples: 
      | options                                 | Sheetname        | RowNumber |
      | Search the array                        | practicequestion |         0 |
      | Max Consecutive Ones                    | practicequestion |         1 |
      | Find Numbers with Even Number of Digits | practicequestion |         2 |
      | Squares of a Sorted Array               | practicequestion |         3 |

  Scenario Outline: The user is able to run code in tryEditor for Practice session of Array in python
    Given The user is in a "<options>"  practice page having an tryEditor with a Run button to test
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on run button
    And The user clicks on submit
    Then The user should be presented with Run result

    Examples: 
      | options                                 | Sheetname        | RowNumber |
      | Search the array                        | practicequestion |         0 |
      | Max Consecutive Ones                    | practicequestion |         1 |
      | Find Numbers with Even Number of Digits | practicequestion |         2 |
      | Squares of a Sorted Array               | practicequestion |         3 |

  Scenario Outline: The user is able to run invald code in tryEditor for Practice session of Array in python
    Given The user is in a "<options>"  practice page having an tryEditor with a Run button to test
    When The user enter python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on run button
    Then The user should be presented with error message

    Examples: 
      | options                                 | Sheetname        | RowNumber |
      | Search the array                        | practicequestion |         4 |
      | Max Consecutive Ones                    | practicequestion |         5 |
      | Find Numbers with Even Number of Digits | practicequestion |         6 |
      | Squares of a Sorted Array               | practicequestion |         7 |
