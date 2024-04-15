## Heng Teng Feng Nigel's Portfolio Page

### Project AeroCade

AeroCade is an In-Flight Entertainment app designed to keep users entertained during travels,
optimized for use via a Command Line Interface (CLI) while still having the core functionalities and features.

Written below are my contributions to this project.

**HangMan Class:**
This class extends from the parent `Game` class. HangMan consists of 2 methods overwritten from `Game`.
The HangMan class also consists of 4 methods that work with other classes in the project to help validate user input and direct exception handling.
runGame(), printLettersGuessed(), addGuess() & howToPlay().

* printLettersGuessed() iterates through and prints each element of the allLettersGuessed array.
* addGuess() is called for every valid input when the HangMan game is running, to check if the guess is correct or wrong.
* howToPlay() is called when the user inputs `guide` and prints a help guide for the HangMan game.
* runGame() is overwritten from the `game` class and starts the game of HangMan by asking what category of words to guess from, followed by asking for a user input till game completion.


**Enhancements to existing features:**
* updated code in Duke to ensure the main loop continues to request input when a game ends.
* added category choosing capability to HangMan for users to pick between 4 categories of words to guess from
* added full word guessing capability to HangMan in addition to just letters.



**Code contributed:** [RepoSense link](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=nigelheng&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2024-02-23&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

**Documentation:**

- User Guide:
  - Added Features of HangMan
  - Added content to FAQ
  - Added command summary

- Developer Guide:
  - Added documentation of HangMan Class
  - Added implementation of HangMan Class methods / features.

- Community:
  - PRs reviewed (with non-trivial comments):
  - Reported bugs and suggestions for other teams in the class (example: CS2113-T15-3)
