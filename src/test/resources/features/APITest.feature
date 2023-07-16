@APITest
Feature: API Testing

  This feature is to validate all API of this demo site

  Scenario: Test Registration API in detail
    When I call register API with invalid emails & verify the following details
      | email   | errormessage           | responsecode  | responsetime   |
      | pritam  | email must be an email | 400           | 5000           |
      | pritam@ | email must be an email | 400           | 5000           |
      | pri@tam | email must be an email | 400           | 5000           |
    
    And I call register API with invalid passwords & verify the following details
      | password | errormessage                                          | responsecode  | responsetime   |
      | PRITEST  | password must be longer than or equal to 8 characters | 400           | 5000           |
      | 1234567  | password must be longer than or equal to 8 characters | 400           | 5000           |
      | !@#$%^&  | password must be longer than or equal to 8 characters | 400           | 5000           |
      | [blank]  | password must be longer than or equal to 8 characters | 400           | 5000           |
    
    When I call register API with existing <email> "pritampro.ju@gmail.com"
    Then I verify response code is 400
    And I verify response time is less than 5000
    Then I verify the error <message> "This email is already connected to an account"
    
    When I call register API with a valid name, email & password
    Then I verify response code is 201
    And I verify response time is less than 5000
    Then I verify the response body

  Scenario: Test Login API in detail
    When I call login API with invalid emails & verify the following details
      | email       | errormessage           | responsecode  | responsetime   |
      | pritam      | email must be an email | 400           | 5000           |
      | pritam@     | email must be an email | 400           | 5000           |
      | pri@tam     | email must be an email | 400           | 5000           |

    When I call login API with invalid <email> "pri@tam.com" & valid <password> "Test@1234"
    Then I verify response code is 400
    And I verify response time is less than 5000
    Then I verify the response <message> as "User not found"

    When I call login API with valid <email> "pritampro.ju@gmail.com" & invalid <password> "Test@1"
    Then I verify response code is 400
    And I verify response time is less than 5000
    Then I verify the response <message> as "Wrong password"

    When I call login API with valid <email> "pritampro.ju@gmail.com" & valid <password> "Test@1234"
    Then I verify response code is 201
    And I verify response time is less than 5000
    Then I verify the response body

