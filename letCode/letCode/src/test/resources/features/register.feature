@business
Feature: Register

  Background:
    Given The target browser is ready

  # 1. Register User
  Scenario: Given that I'm not registered, when I register using valid and unique data, then I get the relevant success message.
    When I register using valid and unique data
    Then I am logged in successfully

  # 2. Register User with existing email
  Scenario: Given that I'm already registered, when I register using existing data, then I get the relevant error message.
    Given I'm already registered
    When I register using already existing data
    Then I get the error message "Error: The email address is already in use by another account."