## Tahsin Tasnim's Portfolio Page

### Project:  AeroCade

AeroCade is an In-Flight Entertainment app designed to keep users entertained during travels,
optimized for use via a Command Line Interface (CLI) while still having the core functionalities and features.

Given below are my contributions to the project.

**Parser Class**: the parser class has 13 methods that work with other classes in the project to
validate user input and help direct exception handling. ifQuit(), ifHelp(), readTTMove(), readLine(), and validHMCategory() are all written by me. Method readGame() was written
collaboratively with JackieNeoCEG
  * ifQuit() and ifHelp() returns true if the given user input matches the 'quit' or 'help' commands, respectively.
  * readTTMove() throws an exception if the given user input does not match necessary parameters for TicTacToe.
  * readLine() reads a single line of user input, validates it, and returns it
  * validHMCategory() ensures that the given user input for the question of HM category is, in fact, a valid hangman category.
  * my contribution to readGame was screening for the possibility that the user input was not a valid game name, not 'quit', and not 'help'

**Storage Class**: this class is intended to load and save statistics, such as player name and number of wins, to a data file.
* Currently, this is unimplemented for its purpose. It may be further completed in a later version. 

**Code contributed**: [RepoSense link](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=ttasnim5&breakdown=true)

**Enhancements to existing features:**
* revised fields of HangMan class to allow for multiple hangman games in a single player session without dealing with old fields and variables
* updated while loop of TicTacToe.runGame() to prevent game from hanging after giving the guide tutorial
* updated while loop of TicTacToe.runGame() to continually reprompt user for a valid difficulty level if an invalid game difficulty is given by user input
* updated while loop of HangMan.runGame() to reprompt an answer from user if user input is an empty line
* updated while loop of HangMan.runGame() to continually reprompt user for a valid category if an invalid hangman category is given by user input
* updated code in Duke, HangMan, and TicTacToe to delete trailing whitespaces in user input

**Contributions to Developer Guide:**
* added the Parser implementation section to UG
  * added and updated a Parser class diagram 
  * added a sequence diagram showing interaction between classes in the main Duke class

**Contributions to team-based tasks:**
* Prioritized adding comprehensive UML diagrams to the team's documentation
* Verified and cleaned up issues from PE-D in GitHub, making sure the issues were solved first by the team if the issue was not discarded as irrelevant.
