Feature: Verify employee creation
@Login
  Scenario Outline: Create a new employee and verify employee is created
  Given customer enters username as "Luke" and password as "Skywalker"
  When customer click on Login button in login form
  And customer click on Create button in employee screen
  When customer enters first name as "<FirstName>" last name as "<LastName>" start date as "<StartDate>" and email as "<Email>"
  Then customer verify the new employee first name "<FirstName>" and last name "<LastName>" exist in employee list

  Examples:
  |FirstName|LastName|StartDate   |Email|
  |Asit     |Tripathy|2019-01-01  |asit@test.com|


