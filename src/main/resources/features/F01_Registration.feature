@smoke
Feature: F01 Registration | guest user create new accounts
  #positive scenario
  Scenario: User could create new account with valid data
    Given User go to register page
    When User select gender
    And User Enter "automation" & "Tester"
    And User Select BOD
    And User Enter email "test@example.com"
    And User Enter password and confirm password "P@ssw0rd"
    And User click Register button
    #began Assertion
    Then Account is created successfully