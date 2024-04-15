package seedu.duke;

import seedu.duke.exceptions.InvalidGameException;
import seedu.duke.exceptions.InvalidTTMoveException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;


/**
 * read user input and call other functions accordingly
 */
public class Parser {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static boolean ifQuit(String input) {
        if (input != null && input.equals("quit")) {
            return true;
        }
        return false;
    }

    public static boolean ifTestQuit(String input) {
        if (input != null && input.equals("testquit")) {
            return true;
        }
        return false;
    }

    public static boolean ifHelp(String input) {
        if (input != null && input.equals("help")) {
            return true;
        }
        return false;
    }

    public static boolean ifTutorial(String input) {
        if (input != null && (input.equals("TTT tutorial") || input.equals("hangman tutorial"))) {
            return true;
        }
        return false;
    }

    public static boolean ifShowGuide(String input) {
        if (input != null && input.equals("guide")) {
            return true;
        }
        return false;
    }

    public static boolean ifShowStats(String input) {
        if (input != null && input.equals("stats")) {
            return true;
        }
        return false;
    }

    /**
     * Reads input from user specifiying what game they wish to play.
     * Calls internal function to start the indicated game, if valid.
     * rn it returns nothing but maybe it can return a string of the game name ?
     * whatever makes it flow easier
     */
    public static void readGame(String input) throws InvalidGameException {
        if (!input.equals("TTT") && !input.equals("hangman") && !ifHelp(input) &&
            !ifQuit(input) && !ifTestQuit(input) && !ifTutorial(input)) {
            throw new InvalidGameException();
        }
    }

    /**
     * Reads input from user specifiying what box they wish to mark in Tic Tac Toe
     * Calls internal function to perform the indicated move, if valid
     * rn it returns nothing but maybe it can return the int repping the box num ?
     * whatever makes it flow easier
     */
    public static void readTTMove(String input) throws InvalidTTMoveException {
        if (input == null) {
            return;
        }

        int markBox;
        try {
            markBox = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidTTMoveException();
        }

        if (markBox < 1 || markBox > 9) {
            // call function to Ui to say "invalid move"
            throw new InvalidTTMoveException();
        }
    }

    /**
     * Parses the input string to determine the type of guess.
     *
     * @param input the input string to parse
     * @return an integer representing the type of guess:
     *           1 if the input string has a length of 1
     *           2 if the input string has a length greater than 1
     *           0 if the input string is null
     */
    //@@author nigelheng
    public static int parseGuess(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        int guessType;
        if (input.length() == 1) {
            guessType = 1;
        } else {
            guessType = 2;
        }
        return guessType;
    }

    /**
     * Checks if the input string contains only English alphabets.
     *
     * @param input the input string to check
     * @return true if the input string contains only English alphabets,
     *         false otherwise
     */
    public static boolean containsEnglishAlphabetsOnly(String input) {
        Pattern pattern = Pattern.compile("[^a-zA-Z]");
        return !pattern.matcher(input).find();
    }

    public static boolean repeatGuess(ArrayList<String> allGuessedLetters, String input) {
        return allGuessedLetters.contains(input);
    }

    /**
     * Checks if there are any remaining blanks (underscores) in the current guess.
     *
     * @param currentGuess the current guess string
     * @return true if there are no remaining blanks (underscores) in the current guess,
     *         false otherwise
     */
    //@@author nigelheng
    public static boolean checkRemainingBlanks(String currentGuess) {
        return !currentGuess.contains("_");
    }

    public static boolean validHMCategory(String category) {
        String [] cats = {"animals", "countries", "sports", "fruits"};
        return Arrays.stream(cats).anyMatch(category::equals);
    }

    /**
     */
    public static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            System.out.println("Error reading user input.");
        }
        return null;
    }
}

