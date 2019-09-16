Feature: Verify employee Edit
@Login
  Scenario Outline: Edit a new employee and verify employee details edited
  Given customer enters username as "Luke" and password as "Skywalker"
  When customer click on Login button in login form
  And customer click on Create button in employee screen
  When customer enters first name as "<FirstName>" last name as "<LastName>" start date as "<StartDate>" and email as "<Email>"
  And customer find the employee first name as "<FirstName>" last name as "<LastName>" from the employee list
  Then customer click on Edit button in employee screen
  When customer updates first name as "Asit Edit1" last name as "Tripathy Edit1" start date as "<StartDate>" and email as "<Email>"
  Then customer verify the new employee first name "Asit Edit1" and last name "Tripathy Edit1" exist in employee list

  Examples:
  |FirstName|LastName|StartDate   |Email|
  |Asit Edit     |Tripathy Edit|2019-01-01  |asit@test.com|


