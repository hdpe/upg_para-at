Some tests.

Lifecycle:
Before:
Given an existing taxi company "company1"
And the following existing taxi "taxi1" for company1:
	| registration |
	| B AB 1234 |

Scenario: I can log a short journey
When I log a journey for taxi1 of 5 minutes
Then taxi1 has the following log entries:
	| registration | journeyLength |
	| B AB 1234 | 5 |
