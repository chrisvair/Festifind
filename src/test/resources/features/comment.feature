Feature: Search for a Specific Festival and Interact with Comments

  As a user
  I want to search for a festival by its name and click on the "voir plus" button
  So I can see the comments and the link that redirects me to the specific festival page
  I also want to be able to add a comment by filling in my name and comment in two fields and cliking the "Ajouter" button

  Scenario: Be redirected to the festival details page
    Given the festival "Rock en Seine" is displayed in the card list
    When I click on the button "Voir plus" to be redirected to the specific festival page "festival-details"
    Then I should be redirected to the festival details page for "Rock en Seine"
    And I should see the festival card with a clickable link to the festival page
    And I should see the festival comments
    And I should see the "Votre nom" and  "Commentaire" fields and the "Ajouter un commentaire" button

  Scenario: Add comment to the festival
    Given I am on the festival details page for "Rock en Seine"
    When I write my name and comment in the two fields and click on the button "Ajouter"
    Then my comment should be displayed in the comments section
