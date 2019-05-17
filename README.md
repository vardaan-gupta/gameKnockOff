# Project Knock off

This is a command line game.
Player can create characters in the game.
Player has the opportunity to Explore areas around the game.
The Player can pick a fight to earn rewards in terms of coins.
Player can save the game and reload it later to resume it.



##1. Requirements for this project

- JDK 8
- MariaDB or Mysql 
      (Assumption default port 3306, username : root , password : root)
	  If you want you can change these details at src/main/resources/application-dev.properties
- Maven

##2. Packaging Jar File

Go to the project root folder (where the pom.xml is) and execute the following commad:

`mvn package -Dmaven.test.skip=true`

A new file named knock-off-0.0.1-SNAPSHOT should be created at `knock-off/target`.


##3. Running the Game

Go to the `knock-off/target` and execute:

`java -jar knock-off-0.0.1-SNAPSHOT.jar`


The game will start.



##4. Running tests


Go to the project root folder (where the pom.xml is) and execute the following command:

`mvn test`

##5. Code Coverage Report

Go to the project root folder (where the pom.xml is) and execute the following command:
`jacoco:report`
Report is created at  /knock-off/target/site/jacoco/index.html