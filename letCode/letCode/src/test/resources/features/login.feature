Feature: Login

  Background:
    Given The target browser is ready

  # 3. Login User with correct email and password
  Scenario: Given that I'm already registered, when I login using valid credentials, then I get the relevant success message.
    Given I'm already registered
    When I login using valid credentials
    Then I am logged in successfully

  # 4. Login User with incorrect email and password
  Scenario: Given that I'm already registered, when I login using incorrect credentials, then I get the relevant error message.
    Given I'm already registered
    When I login using incorrect credentials
    Then I get the error message "Error: There is no user record corresponding to this identifier. The user may have been deleted."

  # 5. Login User with invalid email
  Scenario: Given that I'm already registered, when I login using an invalid email, then I get the relevant error message.
    Given I'm already registered
    When I login using invalid email
    Then I get the error message "Error: The email address is badly formatted."

  # 6. Logout User
  Scenario: Given that I'm already registered, and I'm already logged in, when I log out, then I get the relevant success message.
    Given I'm already registered
    And I login using valid credentials
    When I Sign out
    Then I am logged out successfully