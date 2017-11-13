1.Simple Spring boot Project used to retrive data from a Rest Service and save it in MY SQL Database .
2.To access the web service ,generate a key by creating an account below :
https://market.mashape.com/sportsop/soccer-sports-open-data.

Once the account is created you will recieve a Key ,use this key in the code(RestClientToGetAllLeagues.java)

3.Import the code into local workspace.
4.Change the application.xml ,update username ,password and port(if required).
5.Run project as Spring boot project.
6.Download Postman REST client for chrome(Did not test with any other client,but should work fine).
7.Enter the URl:
http://localhost:8301/rest/football/listleagues
8.Verify that table is created(league_from_rest) and data is inserted.
9.Enter the URL:
http://localhost:8301/rest/football/listTeams/premier-league/seasons/17-18/teams
10.Verify that the table is created(team_from_rest) and data is inserted.
