package seedu.duke;

import seedu.duke.exceptions.InvalidTTMoveException;
import seedu.duke.ui.Ui;

import java.util.Scanner;

import java.util.Random;

import static seedu.duke.Parser.readTTMove;

//@@author nicknamenic
public class TicTacToe extends Game {
    protected static String[] board = new String[9];

    public TicTacToe(String line) {
        super(line);
    }

    //@@author nicknamenic
    /**
     * Prints the current board state.
     */
    private static void printBoard() {
        ui.println("  " + board[0] + " | " + board[1] + " | " + board[2] + "  ");
        ui.println("-------------");
        ui.println("  " + board[3] + " | " + board[4] + " | " + board[5] + "  ");
        ui.println("-------------");
        ui.println("  " + board[6] + " | " + board[7] + " | " + board[8] + "  ");
    }

    //@@author nicknamenic
    /**
     * Checks a line for the computer, and if a win is in sight for the computer,
     * outputs the box that will secure it.
     *
     * @param line The line to be evaluated.
     * @param firstBox The index of the first box in the line.
     * @param secondBox The index of the second box in the line.
     * @param thirdBox The index of the third box in the line.
     * @return The index of the box for the computer to win,
     *         null if no winning combination for the computer is seen.
     */
    private static Integer lineCheckComputer(String line,
                                            int firstBox,
                                            int secondBox,
                                            int thirdBox) {
        switch (line) {
        case "OO ":
            return thirdBox;
        case "O O":
            return secondBox;
        case " OO":
            return firstBox;
        default:
            return null;
        }
    }

    //@@author nicknamenic
    /**
     * Checks a line for the computer, and if a win is in sight for the player,
     * outputs the box that prevents the win.
     *
     * @param line The line to be evaluated.
     * @param firstBox The index of the first box in the line.
     * @param secondBox The index of the second box in the line.
     * @param thirdBox The index of the third box in the line.
     * @return The index of the box for the computer to block the win,
     *         null if no winning combination for the player is seen.
     */
    private static Integer lineCheckPlayer(String line,
                                         int firstBox,
                                         int secondBox,
                                         int thirdBox) {
        switch (line) {
        case "XX ":
            return thirdBox;
        case "X X":
            return secondBox;
        case " XX":
            return firstBox;
        default:
            return null;
        }
    }

    //@@author nicknamenic
    /**
     * Checks the board for the winner.
     *
     * @param turnCount The number of turns taken thus far.
     * @return X if the player won, O if the computer won,
     *         draw if the board is full and no one won and
     *         unending if the board is not full and no one has won.
     */
    private static String checkWinner(int turnCount) {
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
            case 0:
                line = board[0] + board[1] + board[2];
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                break;
            default:
                //this never happens
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }
        if (turnCount == 9) {
            return "draw";
        }
        return "unending";
    }

    //@@author nicknamenic
    /**
     * Computes the best move for the computer based on the current board state.
     *
     * @param board The current state of the board.
     * @param turnCount The number of turns taken thus far.
     * @return The index of the box for the computer to either win or block the player's win.
     */
    private static int computerBestMove(String[] board, int turnCount) {
        Random rand = new Random();
        Integer result;
        if (turnCount == 1 && board[4].equals(" ")) {
            return 4;
        }
        if (turnCount == 1 && board[4].equals("X")) {
            return 0;
        }
        for (int a = 0; a < 16; a++) {
            String line;
            switch (a) {
            case 0:
                line = board[0] + board[1] + board[2];
                result = lineCheckComputer(line, 0, 1, 2);
                if (result != null) {
                    return result;
                }
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                result = lineCheckComputer(line, 3, 4, 5);
                if (result != null) {
                    return result;
                }
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                result = lineCheckComputer(line, 6, 7, 8);
                if (result != null) {
                    return result;
                }
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                result = lineCheckComputer(line, 0, 3, 6);
                if (result != null) {
                    return result;
                }
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                result = lineCheckComputer(line, 1, 4, 7);
                if (result != null) {
                    return result;
                }
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                result = lineCheckComputer(line, 2, 5, 8);
                if (result != null) {
                    return result;
                }
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                result = lineCheckComputer(line, 0, 4, 8);
                if (result != null) {
                    return result;
                }
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                result = lineCheckComputer(line, 2, 4, 6);
                if (result != null) {
                    return result;
                }
                break;
            case 8:
                line = board[0] + board[1] + board[2];
                result = lineCheckPlayer(line, 0, 1, 2);
                if (result != null) {
                    return result;
                }
                break;
            case 9:
                line = board[3] + board[4] + board[5];
                result = lineCheckPlayer(line, 3, 4, 5);
                if (result != null) {
                    return result;
                }
                break;
            case 10:
                line = board[6] + board[7] + board[8];
                result = lineCheckPlayer(line, 6, 7, 8);
                if (result != null) {
                    return result;
                }
                break;
            case 11:
                line = board[0] + board[3] + board[6];
                result = lineCheckPlayer(line, 0, 3, 6);
                if (result != null) {
                    return result;
                }
                break;
            case 12:
                line = board[1] + board[4] + board[7];
                result = lineCheckPlayer(line, 1, 4, 7);
                if (result != null) {
                    return result;
                }
                break;
            case 13:
                line = board[2] + board[5] + board[8];
                result = lineCheckPlayer(line, 2, 5, 8);
                if (result != null) {
                    return result;
                }
                break;
            case 14:
                line = board[0] + board[4] + board[8];
                result = lineCheckPlayer(line, 0, 4, 8);
                if (result != null) {
                    return result;
                }
                break;
            case 15:
                line = board[2] + board[4] + board[6];
                result = lineCheckPlayer(line, 2, 4, 6);
                if (result != null) {
                    return result;
                }
                break;
            default:
                //this never happens
            }
        }
        int computerPlacement;

        computerPlacement = rand.nextInt(9);
        while (board[computerPlacement].equals("X") ||
                board[computerPlacement].equals("O")) {
            computerPlacement = rand.nextInt(9);
        }
        return computerPlacement;
    }

    //@@author nicknamenic
    /**
     * Facilitates the TTT game.
     *
     * @param in The scanner object.
     * @param rand The random object.
     * @param line The line input from the player.
     * @param strength The strength of the computer chosen by the player.
     * @param turnCount The number of turns taken thus far.
     * @return The number of turns taken thus far.
     * @throws InvalidTTMoveException If the input is not between 1-9, the error message is outputted.
     */
    private static int gameLogic(Scanner in, Random rand, String line, String strength, int turnCount)
            throws InvalidTTMoveException {

        readTTMove(line);
        int computerPlacement;
        while ((board[Integer.parseInt(line) - 1].equals("X")) ||
                (board[Integer.parseInt(line) - 1].equals("O"))) {
            ui.println("Hilarious. Try selecting a tile that is not already occupied, fledgling.");
            line = in.nextLine().trim();
            if (Parser.ifQuit(line)) {
                return -1;
            }
            readTTMove(line);
        }
        board[Integer.parseInt(line) - 1] = "X";
        turnCount++;
        if (turnCount == 9) {
            return turnCount;
        }
        if (strength.equals("easy")) {
            computerPlacement = rand.nextInt(9);
            while (board[computerPlacement].equals("X") ||
                    board[computerPlacement].equals("O")) {
                computerPlacement = rand.nextInt(9);
            }
        } else {
            computerPlacement = computerBestMove(board, turnCount);
        }
        board[computerPlacement] = "O";
        turnCount++;
        return turnCount;
    }

    //@@author nicknamenic
    /**
     * Runs the TTT game and outputs the winner. 0 for lost, 1 for win, 2 for draw and 3 for quit.
     *
     * @return an integer returned by 'checkWinner' method that denotes the game outcome.
     */
    @Override
    public int runGame() {
        for (int i = 0; i < 9; i++) {
            board[i] = " ";
        }

        Random rand = new Random();
        int turnCount = 0;
        Scanner in = new Scanner(System.in);
        String line;
        String strength;

        ui.println("Choose: 'easy', our first champion, is a benchmark \n" +
                "for all challengers to test their mettle against, \n" +
                "or 'hard', our second champion, is an Elder of the clouds. \n" +
                "Which opponent do you desire, challenger?");

        strength = in.nextLine().trim().toLowerCase();
        while (!strength.equals("easy") &&
                !strength.equals("hard") &&
                !strength.equals("quit")) {
            if (Parser.ifShowGuide(strength)) {
                howToPlay();
            } else {
                ui.println("Is it so hard to follow simple instructions, \n" +
                        "fledgling? Choose: champion 'easy', or elder 'hard'. \n" +
                        "Do not make me ask again.");
            }
            strength = in.nextLine().trim().toLowerCase();
        }

        while (checkWinner(turnCount).equals("unending")) {
            if (Parser.ifQuit(strength)) {
                break;
            }
            printBoard();
            ui.println(Ui.LINE);
            ui.println("Make your move, challenger.");
            line = in.nextLine().trim();
            assert line != null;

            if (Parser.ifQuit(line)) {
                break;
            }

            if (Parser.ifShowGuide(line)) {
                howToPlay();
                continue; // keeps TTT from hanging
            }

            try {
                turnCount = gameLogic(in, rand, line, strength, turnCount);
                if (turnCount == 9 || turnCount == -1) {
                    break;
                }

            } catch (InvalidTTMoveException e) {
                if (Parser.ifQuit(line)) {
                    break;
                }
                ui.println("Your move is invalid, invalid. \n" +
                        "Enter only 1-9, and do not make me ask again. \n" +
                        "Type 'guide' for tutorial guide");
            }
        }
        return(printWinner(checkWinner(turnCount)));
    }

    //@@author nicknamenic
    /**
     * Prints the winner of the game. 0 for lost, 1 for win, 2 for draw and 3 for quit.
     *
     * @param whoWon The string of who won the game.
     *
     * @return an integer that denotes the game outcome.
     */
    private static int printWinner(String whoWon) {
        switch (whoWon) {
        case "X":
            printBoard();
            ui.println(Ui.LINE);
            ui.println("You have claimed victory over the skies. Godspeed, champion.");
            ui.println(Ui.LINE);
            return 1;
            //break;
        case "O":
            printBoard();
            ui.println(Ui.LINE);
            ui.println("Your defeat has brought shame to the skies. Try again, if you dare.");
            ui.println(Ui.LINE);
            return 0;
            //break;
        case "draw":
            printBoard();
            ui.println(Ui.LINE);
            ui.println("It seems you have met your match. Try again, and this time, do try to win.");
            ui.println(Ui.LINE);
            return 2;
            //break;
        default:
            ui.println(Ui.LINE);
            ui.println("Cowards belong on the ground.");
            ui.println(Ui.LINE);
            return 3;
            //break;
        }
    }

    //@@author nicknamenic
    /**
     * Prints the game guide when 'guide' is inputted
     */
    @Override
    public void howToPlay() {
        super.howToPlay();
        ui.println(Ui.LINE);
        ui.println("\t- The ancient game of Tic-Tac-Toe, as foretold by our forefathers, is a trial\n " +
                "by single combat.");
        ui.println("\t- A grid, numbering three across and three lengthwise. Each space represents a\n " +
                "spot you can occupy.");
        ui.println("\t- You and your opponent will take turns making your moves. " +
                "The first to complete a line, either horizontally, diagonally or vertically, will emerge the\n " +
                "victorious, and give rightful justification to their place in the skies.");
        ui.println(Ui.LINE);
        ui.println("Commands for the game:");
        ui.println("\t- To mark a box, simply key in the box's number.");
        ui.println("\t- The grid is marked from left to right, top to bottom, from 1 to 9.");
        ui.println(Ui.LINE);
    }
}
