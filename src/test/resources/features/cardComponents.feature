Feature: Verify Festival Card Components

  As a user
  I want to ensure that the festival cards display all the necessary components correctly
  So that I can easily access the information about each festival

  Scenario: Festival card displays festival name, date, location and style, and "Voir plus" button
    Given I am on the FEST'IFIND website's festival page
    When I view the festival card for "Festival du jeune art russe"
    Then I should see the festival name "FESTIVAL DU JEUNE ART RUSSE"
    And I should see the festival date "Saison (21 juin - 5 septembre)"
    And I should see the festival location "Cannes"
    And I should see the festival music style "Musique traditionnelle"
    And I should see the "Voir plus" button