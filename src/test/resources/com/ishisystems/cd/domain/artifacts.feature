 Feature: Artifact lifecycle

  @ignore
  Scenario: Addition of an artifact using english
    Given I am on the front page using locale en/US
    When Valid artifact details are submitted
    Then A confirmation page should show the artifact saved with confirmation message - The artifact has been saved.

  Scenario: Addition of an artifact using a different language
      Given I am on the front page using locale no
      When Valid artifact details are submitted
      Then A confirmation page should show the artifact saved with confirmation message - Artefakten er lagret.

  Scenario: Search an artifact
      Given I have saved an artifact
      When I go to the search page
      Then The artifact should get listed on the page
