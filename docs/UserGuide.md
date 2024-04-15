# AeroCade User Guide

## Introduction

AeroCade is an In-Flight Entertainment app designed to keep users entertained during travels, 
optimized for use via a Command Line Interface (CLI) while still having the core functionalities and features.

## Table of Contents
* [Quick Start](https://ay2324s2-cs2113-w13-1.github.io/tp/UserGuide.html#quick-start)
* [Features](https://ay2324s2-cs2113-w13-1.github.io/tp/UserGuide.html#features)
   * [Playing a game of TicTacToe](https://ay2324s2-cs2113-w13-1.github.io/tp/UserGuide.html#playing-a-game-of-tictactoe)
   * [Playing a game of Hangman](https://ay2324s2-cs2113-w13-1.github.io/tp/UserGuide.html#playing-a-game-of-hangman)
   * [Viewing of Game statistics](https://ay2324s2-cs2113-w13-1.github.io/tp/UserGuide.html#viewing-of-game-statistics)
   * [In-Game Guides](https://ay2324s2-cs2113-w13-1.github.io/tp/UserGuide.html#in-game-guides) 
* [Command Summary](https://ay2324s2-cs2113-w13-1.github.io/tp/UserGuide.html#command-summary)

## Quick Start

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `AeroCade.jar` from [here](http://link.to/duke).
3. Copy the file to the folder you want to use as the home folder for your (name).
4. Open a command terminal, cd into the folder you put the jar file in, and use the java -jar (name).jar command to run the application.
5. Type commands in the CLI and press Enter to execute it. (E.g. type and enter 'help' for a list of available commands)
6. Refer to the Features below for details of each command.

## Features


### Playing a game of TicTacToe

1. Entering `tutorial` mode: type `TTT tutorial`
   * Detailed tutorial showing the gameplay mechanics of how to win TicTacToe.
   * Timed aspect of 4 seconds per frame.

   Start of TicTacToe tutorial:
   
   ```
   _________________________________________________________________
   [Tutorial Mode is playing, do not input any commands!]
   Tutorial Pilot: Good day! this is Tutorial Pilot and I will demonstrate
                   a stellar gameplay of TTT for you!
   
       |   |    
   -------------
       |   |    
   -------------
       |   |    
   
   Tutorial Pilot: This is a TTT board which I'll be placing an 'X' depending on
                   the number I put, here is the numbered layout!
   _________________________________________________________________
   ```

   * At any point, if you want to quit `tutorial` mode., type `quit`.
   
   ```
   quit
   TTT Tutorial exited! Returning back to the Main Menu...
   _________________________________________________________________
   ```

2. Entering the real Tic-Tac-Toe game: 
   * To start a game, type `TTT`.
   * Choose your difficulty, either `easy` or `hard`, and type it in.
   * Pick a box in the grid to occupy by choosing number `1/2/3/4/5/6/7/8/9`.
   * At any point, if you want to quit, simply type `quit`

   ```
     1 | 2 | 3
   -------------
     4 | 5 | 6    
   -------------
     7 | 8 | 9    
   ```
   ```
   Which opponent do you desire, challenger?
   easy
       |   |    
   -------------
       |   |    
   -------------
       |   |    
   _________________________________________________________________
   ```
   
   ```
   _________________________________________________________________
   Make your move, challenger.
   7
     X | O |    
   -------------
     X |   | O  
   -------------
     X |   | O  
   _________________________________________________________________
   You have claimed victory over the skies. Godspeed, champion.
   _________________________________________________________________
   Now what would you like to do?
   ```

### Playing a game of Hangman

1. Entering `tutorial` mode: type `hangman tutorial`
   * Detailed tutorial showing the ideal thought process of playing while showing
   the number of mistakes allowed
   * Timed aspect of 4 seconds per frame.

   Start of Hangman tutorial: 

   ```
   _________________________________________________________________
   [Tutorial Mode is playing, do not input any commands!]
   Tutorial Pilot: Good day! this is Tutorial Pilot and I will demonstrate
                   a stellar gameplay of Hangman for you! 
   _______        
   |     |        
   |              
   |              
   |              
   |              
   ============== 
   _ _ _ _ _
   Tutorial Pilot: This is the start of the game, for this tutorial, I'll need to
                   guess a 5-letter word before the 'hangman' is drawn out, which
                   means I can only make 5 wrong guesses! Let's try the letter 'a'
   _________________________________________________________________
   ```

   * At any point, if you want to quit `tutorial` mode., type `quit`.
   
   ```
   quit
   Hangman Tutorial exited! Returning back to the Main Menu...
   _________________________________________________________________
   ```

2. Entering the real Hangman game:
   * To start a game, type `hangman`.
   * You will be prompted to choose a category between `animals`, `fruits`, `countries` & `sports`
   * Type in one of the 4 categories
   * Guess a letter in the secret word by typing in the letter or if you are confident
   * Guess the whole secret word.

   ```
   _______
   |     |
   |
   |
   |
   |
   ==============
   These are the guesses you have made so far:
   
    _ _ _
   ```
   ```
   _________________________________________________________________
   These are the guesses you have made so far:
   a  o  i  u  e  b  r  h  
    _ _ o r _
   give me your next guess
   _________________________________________________________________
     _______
     |     |
     |     @
     |    /|\
     |     |
     |    / \
   ==============
   
   Oh noo!! It seems you have lost   :( 
   The correct answer is [stork]
   Now what would you like to do?
   ```

### Viewing of Game statistics
In the main menu, users can view their total game statistics.
This can be done so through the `stats` command input into the CLI.

```
Type 'help' for a list of available commands!                  
_________________________________________________________________
stats

Total games played: 0
Your victories thus far, player: 0
Your Defeats, player: 0
Your Draws, player: 0
Number of times you fled: 0
```

The `stats` command will display:
* Total number of games played
* Total number of games won (Tic-Tac-Toe and Hangman inclusive)
* Total number of games lost (Tic-Tac-Toe and Hangman inclusive)
* Total number of Tic-Tac-Toe games tied
* Total number of games users have quit and left without finishing

### In-Game Guides

**Q**: Where can I find a guide on understanding the game rules? 

**A**: Open a game with `TTT` or `hangman` and open the game guide with `guide`. Below is an example when opening
`guide` while playing `hangman`.

```
Now what is your first guess? ('guide' for a guide on how to play Hangman!)
_________________________________________________________________
guide
_________________________________________________________________
Let me explain the rules of this game:
	- Hangman is a word guessing game played by yourself.
	- There is a SECRET word which you would have to guess.
	- You will have to guess letter by letter within 7 tries. Else, you lose!!

Commands for the game:
	- To guess a letter, simply type in an alphabet.
	- If it is correct, the letter will be shown.
	- A list of guessed letters will be indicated at the top as well.

Lets put your english to the test! Best of luck :D
_________________________________________________________________
```

And while playing Tic-Tac-Toe as shown below.

```
_________________________________________________________________
TTT

Choose: 'easy', our first champion, is a benchmark 
for all challengers to test their mettle against, 
or 'hard', our second champion, is an Elder of the clouds. 
Which opponent do you desire, challenger?

guide
_________________________________________________________________
Let me explain the rules of this game:
_________________________________________________________________
	- The ancient game of Tic-Tac-Toe, as foretold by our forefathers, is a trial
 by single combat.
	- A grid, numbering three across and three lengthwise. Each space represents a
 spot you can occupy.
	- You and your opponent will take turns making your moves. The first to complete a line, either horizontally, diagonally or vertically, will emerge the
 victorious, and give rightful justification to their place in the skies.
_________________________________________________________________
Commands for the game:
	- To mark a box, simply key in the box's number.
	- The grid is marked from left to right, top to bottom, from 1 to 9.
_________________________________________________________________
```

**Q**: Where can I learn how to play the game?

**A**: In the main menu on the CLI, start a tutorial with either `TTT tutorial` or `hangman tutorial`. Below is an 
example of the start of a tutorial (frame 1 only) when calling `TTT tutorial`.

```
TTT tutorial
_________________________________________________________________
[Tutorial Mode is playing, do not input any commands!]
Tutorial Pilot: Good day! this is Tutorial Pilot and I will demonstrate
                a stellar gameplay of TTT for you!

    |   |    
-------------
    |   |    
-------------
    |   |    

Tutorial Pilot: This is a TTT board which I'll be placing an 'X' depending on
                the number I put, here is the numbered layout!
_________________________________________________________________
(... More Frames to be shown)
```

## Command Summary

| Commands                 | Description                    |
|--------------------------|--------------------------------|
| `help`                   | See list of commands in menu   |
| `TTT tutorial`           | View Tic-tac-toe tutorial      |
| `TTT`                    | Start a game of Tic-tac-toe    |
| `hangman tutorial`       | View Hangman tutorial          |
| `hangman`                | Start a game of Hangman        |
| `guide` _(only in-game)_ | View guide while in-game       |
| `stats`                  | View game statistics           |
| `quit`                   | Ends the game/tutorial/program |
