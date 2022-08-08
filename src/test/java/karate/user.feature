Feature: check userLogin API ...

  Background:
    * url 'http://localhost:8080'
    * header Accept = 'application/json'
  Scenario: register user - valid
    Given path '/register'
    And request
    """
      {
          "username":"Michael S",
          "password":"testPwd$1",
          "ipAddress":"142.188.56.66"
      }
    """

    When method post
    Then status 200




