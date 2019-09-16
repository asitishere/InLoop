Feature: Verify employee deletion
@Login
  Scenario Outline: Delete a new employee and verify employee not present in employee list
  Given customer enters username as "Luke" and password as "Skywalker"
  When customer click on Login button in login form
  And customer click on Create button in employee screen
  When customer enters first name as "<FirstName>" last name as "<LastName>" start date as "<StartDate>" and email as "<Email>"
  And customer find the employee first name as "<FirstName>" last name as "<LastName>" from the employee list
  And customer click on Delete button in employee screen
  Then customer verify the new employee first name "<FirstName>" and last name "<LastName>" does not exist in employee list

  Examples:
  |FirstName|LastName|StartDate   |Email|
  |Asit Old     |Tripathy Old|2019-01-01  |asit@test.com|


