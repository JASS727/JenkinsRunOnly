@RegisterPageTest
Feature: Registration verification and validation

  Background: 
    Given The user opens DS Algo portal link
    When The user clicks the Get Started button

  @tag
  Scenario: To verify Register Form with Empty fields
    Given The user opens Register Page
    When User click Register with all empty field
    Then It should display an error "Please fill out this field." below username textbox

  Scenario: The user is presented with error message for empty fields below password textbox
    Given The user opens Register Page
    When The user clicks Register button after entering username with other fields empty
      | username  |
      | Sdet@1234 |
    Then It should display an error "Please fill out this field." below password textbox

  Scenario Outline: The user is presented with error message for empty fields below username textbox
    Given The user opens Register Page
    When The user clicks Register button after entering password with other fields empty
      | password |
      | Sdet1234 |
    Then It should display an error "Please fill out this field." below username textbox

  Scenario Outline: The user is presented with error message for empty fields above Password Confirmation textbox
    Given The user opens Register Page
    When The user clicks Register button after entering confirmation password with other fields empty
      | confirm password |
      | Sdet1234         |
    Then It should display an error "Please fill out this field." below Password Confirmation textbox

  Scenario Outline: To verify Register Form with username and password only
    Given The user opens Register Page
    When User enters username and password only and click register
      | username | password |
      | Unumpy   | Pnumpy   |
    Then User verify the message at confirmpassword on Register Page as "Please fill out this field."

  Scenario Outline: To verify Register Form with invalid Credentials
    Given The user opens Register Page
    When user enter invalid "<username>","<password>" and "<confirmpassword>"
    Then User verifies for the mismatch error message "password_mismatch:The two password fields didn’t match."

    Examples: 
      | username   | password   | confirmpassword |
      | Nu$$@      | sdet       | sdet1           |
      | Numpy@sdet | password12 | password        |
      | Numpy@sdet | 1010101010 |      1010101010 |
      | Numpy@sdet | Numpy@sdet | Numpy@sdet      |
      | suba       | Numpy@sdet | Numpy@sdet      |
      | Numpy@sdet | asdf       | asdf            |
      | Numpy@sdet | welcome1   | welcome1        |

  Scenario Outline: to register with all the data
    Given The user opens Register Page
    When user enter the sheetname "<sheetname>" and row number <rownum>
    Then User verifies for the successful registration message

    Examples: 
      | sheetname        | rownum |
      #| validcredentials |      0 |
