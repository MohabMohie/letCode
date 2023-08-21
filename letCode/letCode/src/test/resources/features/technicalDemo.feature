@technical
Feature: Technical Demo

  Background:
    Given I Open the target browser

  # 7. Element visual assertion
  Scenario: Element visual assertion
    When I Navigate to "https://www.google.com/ncr" and get redirected to "https://www.google.com/"
    Then I Assert that the element found by "xpath": "//img[contains(@src,'googlelogo')]", exactly matches with the expected reference image using Artificial Intelligence OpenCV

  # 8. Element attribute assertion
  Scenario: Element attribute assertion
    When I Navigate to "https://www.google.com/ncr" and get redirected to "https://www.google.com/"
    And I Type "SHAFT_Engine" into the element found by "name": "q"
    And I Press the "Enter" key into the element found by "name": "q"
    Then I Assert that the "href" attribute of the element found by "xpath": "(//h3[contains(@class,'LC20lb')])[1]/parent::a", equals "https://github.com/ShaftHQ/SHAFT_ENGINE"

  # 9. Element CSS property assertion
  Scenario: Element CSS property assertion
    When I Navigate to "https://www.google.com/ncr" and get redirected to "https://www.google.com/"
    And I Type "SHAFT_Engine" into the element found by "name": "q"
    Then I Assert that the "appearance" CSS property of the element found by "name": "q", contains "t"

  # 10. Element steps
  Scenario: Element steps
    When I Navigate to "https://www.google.com/ncr" and get redirected to "https://www.google.com/"
    And I Type "SHAFT_Engine" into the element found by "name": "q"
    And I Type "password" securely into the element found by "name": "q"
    And I Append the text "123" to the element found by "name": "q"
    And I Click the element found by "name": "q"
    And I Click and hold the element found by "name": "q"
    And I Double-click the element found by "name": "q"
    And I Hover over the element found by "classname": "gLFyf"
    And I Hover over the element found by "class_name": "gLFyf"
    And I Hover over the element found by "class name": "gLFyf"
    And I Press the "Enter" key into the element found by "name": "q"
    And I Wait for the element found by "xpath": "(//h3[contains(@class,'LC20lb')])[1]/parent::a" to be present
    And I Navigate back
    And I Set the value "SHAFT_Engine" into the element found by "name": "q"
    And I Press the "Enter" key into the element found by "name": "q"
    Then I Assert that the "href" attribute of the element found by "xpath": "(//h3[contains(@class,'LC20lb')])[1]/parent::a", equals "https://github.com/ShaftHQ/SHAFT_ENGINE"