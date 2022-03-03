Feature: test registration module
Scenario Outline: to check registration page functionality
Given application is initialized
When open website
Then logo gets verified
Then title gets verified
Then enter "<emailId>" "<parentName>" "<mobileNumber>" "<childName>" details
Then application getting closed
Examples:
| emailId | parentName | mobileNumber | childName |
| kndnbhagat | dinkar | 9966859665 | dhruv |
| sankebhagat | yashoda | 7219544720 | shaurya |
| sayalibhagat | bhushan | 8897432089 | sanksrut |