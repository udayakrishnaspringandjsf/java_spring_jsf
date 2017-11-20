Project 1:
footyApp-rest-consume-service

1.Simple Spring boot Project using Spring Tool Suite to retrive data from a Rest Service and save it in MY SQL Database .
2.To access the web service ,generate a key by creating an account below :
https://market.mashape.com/sportsop/soccer-sports-open-data.

Once the account is created you will recieve a Key ,use this key in the code(RestClientToGetAllLeagues.java)

3.Import the code into local workspace.
4.Change the application.xml ,update username ,password and port(if required).
5.Run project as Spring boot project.
6.Download Postman REST client for chrome(Did not test with any other client,but should work fine).
7.Enter the URl in POSTMAN:
http://localhost:8301/rest/football/listleagues
8.Verify that table is created(league_from_rest) and data is inserted.
9.Enter the URL POSTMAN:
http://localhost:8301/rest/football/listTeams/premier-league/seasons/17-18/teams
10.Verify that the table is created(team_from_rest) and data is inserted.


----------------------------------------------------------------------------------------------------------------------------------------------
Project 2:
footyApp-eureka-server-service

1.This acts as the eureka server with zool proxy for Project 3 and Project 4.
2.@EnableEurekaServer
  @EnableZuulProxy    annotations enable the Eureka and Zool.
3.Import the code to STS.
4.Ensure the proper port numbers are given ain application.yml file.In our case it is 8095 for EurekaServer.
5.Ensure the mapping is correct for Zool proxy port and URL for Project 3 and Project 4 <See below>.
6.Run project as Spring boot project.
7.Access Eureka console http://localhost:8095/ and check the console is up and running.

Project 3:
footyApp-db-eureka-client-service

1.This exposes the data saved by Project 1 as RESTful web service.
2.Import the project to STS.
3.Ensure that Eureka(Project 2) is running.
4.Run the project as Spring boot.
5.In Postman enter the below URL to display all available leagues:
http://localhost:8905/api/footy-service/football/getAllLeague
6.In postman enter below URL:
http://localhost:8095/api/footy-service/football/getTeamsByLeague/serie-a
Do not forget to add header as "key" as key and "password" as value 
This should retrive teams that belong to a serie-a league.

Project 4:
footyApp-auth-eureka-client-service

1.This project is used to create Role and Users in the system.
2.Import code to STS.
3.Ensure that Eureka (Project 2)is running.
4.Run the project as Spring boot.
5.Use the below URL to create a Role:
http://localhost:8095/api/user-service/football/addrole/superadmin
6.Add below URL to add an user as superadmin
http://localhost:8095/api/user-service/football/adduser/uday/superadmin/maddy.udi@gmail.com
Do not forget to add header "password" as key and "whateverpasswordyouwant" as value.
7.The above steps should create 2 tables Role and User and insert values into it.

ISSUES? Contact me by email: maddy.udi@gmail.com