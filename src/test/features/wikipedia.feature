Feature: Wikipedia Search

  Scenario: User searches for a word on Wikipedia
    Given the user is on the Wikipedia homepage
    When the user searches for Microsoft
    Then the user should see the search results page