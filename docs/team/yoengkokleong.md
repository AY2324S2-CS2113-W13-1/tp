## Yoeng Kok Leong's Portfolio Page

### Project AeroCade

AeroCade is an In-Flight Entertainment app designed to keep users entertained during travels,
optimized for use via a Command Line Interface (CLI) while still having the core functionalities and features.

Written below are my contributions to this project.

**Game Class:** 
This class has 4 methods that interacts with the other classes such as HangMan and TicTacToe. 

It is the parent class of HangMan and TicTacToe, and has methods that encapsulates common functionalities such as runGame(), howToPlay() and gameWon(). 
- runGame() is an overridden method that a HangMan class or TicTacToe class uses to start its respective game.
- howToPlay() is called when 'guide' command is called during a game. It prints the rules of the respective game, along with the available commands for the CLI.
- gameWon() sets the int variable 'gameOutcome' to 1, denoting a win for that game.
- gameQuit() sets the int variable 'gameOutcome' to 3, denoting the game was quit before finishing.
- gameDraw() sets the int variable 'gameOutcome' to 2, denoting a draw for the Tic-Tac-Toe game.

**Parser Class:** 
Added some methods to parser class such as ifShowGuide() and ifShowStats
- ifShowGuide() returns true if the input line contains 'guide'. This would then call howToPlay() for the user to learn the game rules
- ifShowStats returns true if the input line contains 'stats'. This would then call ifShowStats() for the user to view his/her games won and statistics.

**Code contributed:** [RepoSense link](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=YoengKokLeong&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2024-02-23&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

**Documentation:**

- User Guide:
  - Added Introduction
  - Added Quick Start
  - Added Features of HangMan and TicTacToe
  - Added content to FAQ
  - Added list of command summary
  
- Developer Guide:
    - Added documentation of Game Class
    - Added implementation of Game Class methods / features.
  
- Community:
    - PRs reviewed (with non-trivial comments): 
    - Reported bugs and suggestions for other teams in the class (example: CS2113-W14-1)
    - [Reported](https://github.com/YoengKokLeong/ped/issues) 8 bugs (above average number) during the PE dry run
