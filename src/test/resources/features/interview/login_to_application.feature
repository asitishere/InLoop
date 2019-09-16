Feature: User Login verification
  @Login
  Scenario Outline: Verify customer successfully login after submitting valid user name and password
    Given customer enters username as "<Username>" and password as "<Password>"
    When customer click on Login button in login form
    Then verify customer successfully login to the application

  Examples:
  |Username|Password|
  |Luke     |Skywalker|