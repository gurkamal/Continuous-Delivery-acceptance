 Feature: Artifact lifecycle

  Scenario: Addition of an artifact
    Given I am on the front page
    When Valid artifact details are submitted
    Then A confirmation page should show the artifact saved
