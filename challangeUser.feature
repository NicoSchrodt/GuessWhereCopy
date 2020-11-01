Feature: Challange User

    A User challanges another User to play a game against each other

Scenario: User Sends Challange Request successful

When User presses "Send Challange Request"
Given Request was send
Then I should see "Success Message"

Scenario: User Sends Challange Request failed

When User presses "Send Challange Request"
Given Request was not send
Then I should see "Fail Message"

Scenario: Accept Incomming Request

Given recieved Request
When User presses "Accept"
Then I should see "Game start"

Scenario: Decline Incomming Request

Given recieved Request
When User presses "Decline"
Then I should see "Decline Message"