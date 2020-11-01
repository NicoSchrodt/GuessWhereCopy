Feature: Start Game

    User Presses Button "Play", selects the Gamemode and the Game starts

Scenario: Start Game logged in

Given User is logged in
When User presses "Play" Button
Then I should see "Gamemode"

Scenario: Start Game logged in

Given User is not logged in
When User presses "Play" Button
Then I should see "Please enter Username"


Scenario: Select Gamemode

Given "Gamemode" is shown
When User selects "Gamemode"
Then I should see "Game Start"