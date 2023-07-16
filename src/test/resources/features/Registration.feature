Feature: Registration Functionality for a Demo Site
  
  I want to register into this demo wesite

@SmokeTest
  Scenario: Successful Registration with multiple validations
    Given I am on Fego Home Page
    When I click on the login button
    Then I should be navigated to authentication page
    And I navigate to registration tab
    When I navigate to privacy policy page 
    And I verify privacy policy page header "PRIVATE POLICY"
    Then I navigate to previous page
    When I navigate to terms page 
    And I verify terms page header "Terms and Conditions"
    Then I navigate to previous page
    Then I verify loyalty card
    And I verify page <header> "Create your account"
    And I validate blank name error <message> as "Please add your name"
    Then I validate emailerror for followings
      | email           | emailerror      |
      |	[blank]					| Required field. |
      | hello           | Invalid email.  |
      | hellogmail.com  | Invalid email.  |
    And I validate passworderror for followings
      | password | passworderror                                                 |
      | [blank]  | Password is required. This field should contain 8 characters. |
      | abcdefg  | This field should contain 8 characters.                       |
      | abcdefg  | This field should contain 8 characters.                       |
      | ABCDEFG  | This field should contain 8 characters.                       |
    When I enter an existing <email> "pritampro.ju@gmail.com" and <name> "Existing User"
    Then I verify the alert <message> "This email is already connected to an account."
    And I register a user with random email, name and password
    Then I should be logged in and verify username
