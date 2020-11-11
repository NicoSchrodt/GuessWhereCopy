Feature: Challange User

    A User challanges another User to play a game against each other

Scenario: User Sends Challange Request successful

Given Request was send
When User presses "Send Challange Request"
Then I should see "Success Message"

Scenario: User Sends Challange Request failed

Given Request was not send
When User presses "Send Challange Request"
Then I should see "Fail Message"

Scenario: Accept Incomming Request

Given recieved Request
When User presses "Accept"
Then I should see "Game start"

Scenario: Decline Incomming Request

Given recieved Request
When User presses "Decline"
Then I should see "Decline Message"
