Feature: feature to test login functionality to Swag Labs
	
	
	Background:
		Given User has opened swag labs browser
	
	@Interface @TC01	
	Scenario: Verify login page
		Then There are fields for inputting username and password that have not been filled in
		And There is a Swag Labs logo name
			
  @TCID01
  Scenario: Verify if login is successful with valid credentials
    When User enter username as "standard_user" and password as "secret_sauce"
    And User click login button
    Then User should be able to see Dashboard Page

  @TCID01
  Scenario Outline: Verify if login is unsuccessful with invalid credentials
    When User enter username as "<username>" and password as "<password>"
    And User click login button
    Then Showing symbol red x in the "<error_field>"
    And Showing Error message "<error_message>"
    And Stay on the login page
    And The label and border in the "<error_field>" field are red

    Examples: 
      | username      | password     | error_message                                              							| error_field | TCID  |
      | standard_user |              |Epic sadface: Password is required                         								| password		| TC012 |
      |               | secret_sauce |Epic sadface: Username is required                         					  		| username	  | TC013 |
      |               |              |Epic sadface: Username is required                     							      | both        | TC014 |
      | standard_user | secret       |Epic sadface: Username and password do not match any user in this service | both        | TC015 |
      | standarda     | secret_user  |Epic sadface: Username and password do not match any user in this service | both        | TC016 |
      | standard      | secret       |Epic sadface: Username and password do not match any user in this service | both        | TC017 |
