Feature: Login Functionality for a Demo Site
  
  I want to login into this demo wesite

@SmokeTest
  Scenario: Successful login with valid credentials
    Given I am on Fego Home Page
    When I click on the login button
    Then I should be navigated to authentication page
    When I navigate to forgot password page
    Then I verify header "Forgot Password?"
    And I verify message "Enter the email address you registered with and we will send you a link to reset your password."
    Then I validate emailerror for followings
      | email       | emailerror      |
      | [blank]     | Required field. |
      | hello@gmail | Invalid email.  |
    And I verify reset link button & text "Send reset link"
    Then I navigate to previous page
    When I am on Fego Login Page
    Then I validate emailerror for followings
      | email       | emailerror      |
      | [blank]     | Required field. |
      | hello@gmail | Invalid email.  |
    And I validate passworderror for followings
      | password | passworderror   |
      | [blank]  | Required field. |
    And I validate alert for following details
      | email                   | password  | alert          |
      | pritampro.ju@gmail.com  | Test@12   | Wrong password |
      | pritampro.ju@gmail.comm | Test@1234 | User not found |
    When I fill in <email> with "pritampro.ju@gmail.com"
    And I fill in <password> with "Test@1234"
    And I click on login button
    Then I should be logged in with <username> "Pritam"
