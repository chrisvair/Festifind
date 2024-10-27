Feature: Search Functionality with three options: by name, by location, by style
  As a user
  I want to search for a festival by its name (correctly spelled) or search for a specific location or search a specific music style
  So that I can find the festival I am looking for
  If I search for a specific festival, I want to see it displayed as first choice and on the map
  If I search for a specific location, I want to see all festivals in that location
  If I search for a specific music style, I want to see all festivals with that music style (with the given limitation of the API)

  Scenario: Search for a specific festival and verify it is displayed on the map
    Given I am on the FEST'IFIND website's festival page
    When I search for "Rock en Seine" with specifying the "nom" option in the search menu
    Then The festival "Rock en Seine" should be displayed on the map as first choice
    And I should see the festival displayed on the map

  Scenario: Search for a specific location and verify all the festivals of that location are displayed on the cards and on the map
    Given I am on the FEST'IFIND website's festival page
    When I search for "Paris" with specifying the "ville" option in the search menu
    Then All the festivals displayed should be in Paris
    And I should see the festivals displayed on the map with an a cluster of markers on Paris

  Scenario: Search for a specific style and verify all the festivals of that style are displayed on the cards and on the map
    Given I am on the FEST'IFIND website's festival page
    When I search for "pop" with specifying the "style" option in the search menu
    Then All the festivals displayed should be with style pop
    And I should see the same festivals displayed on the map