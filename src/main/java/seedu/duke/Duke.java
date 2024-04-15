package seedu.duke;


import seedu.duke.exceptions.InvalidGameException;
import seedu.duke.exceptions.InvalidTTMoveException;
import seedu.duke.ui.Render;
import seedu.duke.ui.TimerTutorial;
import seedu.duke.ui.Ui;


import java.util.ArrayList;


public class Duke {
    private static final Render render = new Render();
    private static final TimerTutorial tutorial = new TimerTutorial();
    private static final Ui ui = new Ui(render, tutorial);
    private static ArrayList<Game> games = new ArrayList<>();
    private static int gameCounter = 0;
    private static int numberOfGamesWon;
    private static int numberOfGamesLost;
    private static int numberOfGamesQuit;
    private static int numberOfGamesDraw;

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        ui.greetUser();

        boolean inGame = false;
        String input = Parser.readLine().trim();
        assert input != null;

        while (true) {
            if (Parser.ifQuit(input)) {
                ui.quitUser();
                break;
            } else if (Parser.ifTestQuit(input)) {
                ui.println("runtestbat success!");
                break;
            } else if (Parser.ifShowStats(input)) {
                numberOfGamesWon = 0;
                numberOfGamesLost = 0;
                numberOfGamesQuit = 0;
                numberOfGamesDraw = 0;
                for (Game item: games) {
                    if (item.gameOutcome == 3) {
                        numberOfGamesQuit++;
                    } else if (item.gameOutcome == 1) {
                        numberOfGamesWon ++;
                    } else if (item.gameOutcome == 0) {
                        numberOfGamesLost ++;
                    }  else if (item.gameOutcome == 2) {
                        numberOfGamesDraw++;
                    }
                }
                System.out.println("Total games played: " + (gameCounter));
                System.out.println("Your victories thus far, player: " + numberOfGamesWon);
                System.out.println("Your Defeats, player: " + numberOfGamesLost);
                System.out.println("Your Draws, player: " + numberOfGamesDraw);
                System.out.println("Number of times you fled: " + numberOfGamesQuit);
                input = Parser.readLine().trim();
                continue;
            }


            if (!inGame) {
                try {
                    Parser.readGame(input);
                    inGame = true;
                    if (input.equals("TTT")) {
                        try {
                            games.add(new TicTacToe(input));
                            switch (games.get(gameCounter).runGame()) {
                            case 0:
                                //Game lost
                                break;
                            case 1:
                                //Game won
                                games.get(gameCounter).gameWon();
                                break;
                            case 2:
                                //Game tied
                                games.get(gameCounter).gameDraw();
                                break;
                            case 3:
                                //Game quit
                                games.get(gameCounter).gameQuit();
                                break;
                            default:
                                break;
                            }
                            gameCounter ++;
                            ui.println("Now what would you like to do?");
                            inGame = false;
                        } catch (InvalidTTMoveException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (input.equals("hangman")) {
                        System.out.println("What category would you like to choose? These are the options:");
                        System.out.println("animals, countries, fruits & sports");

                        String category = Parser.readLine().trim();

                        if (!Parser.validHMCategory(category)) {
                            while (!Parser.validHMCategory(category)) {
                                if (Parser.ifQuit(category)) {
                                    inGame = false;
                                    ui.println(Ui.LINE);
                                    ui.println("Exiting hangman. Play again soon!");
                                    ui.println("Now what would you like to do?");
                                    break;
                                }
                                ui.println("That's not a category :O.");
                                ui.println("Please try again");
                                category = Parser.readLine().trim();
                            }
                        } else {
                            games.add(new HangMan(category));
                            switch (games.get(gameCounter).runGame()) {
                            case 0:
                                //Game lost
                                break;
                            case 1:
                                //Game won
                                games.get(gameCounter).gameWon();
                                break;
                            case 3:
                                //Game quit
                                games.get(gameCounter).gameQuit();
                                break;
                            default:
                                break;
                            }
                            gameCounter++;
                            ui.println("Now what would you like to do?");
                            inGame = false;
                        }
                    } else if (Parser.ifHelp(input)) {
                        ui.printHelp();
                        inGame = false;
                    } else if (Parser.ifTutorial(input)) {
                        if (input.equals("TTT tutorial")) {
                            ui.printTTTTutorial();
                        } else {
                            ui.printHangmanTutorial();
                        }
                        inGame = false;
                    } else if (tutorial.isTutorialRunning()) {
                        ui.println("A tutorial is already running.");
                    }
                } catch (InvalidGameException | NullPointerException e) {
                    ui.println("Invalid Game. Type \'help\' for list of available commands.");
                } catch (InvalidTTMoveException e) {
                    throw new RuntimeException(e);
                }
            }
            input = Parser.readLine().trim();
        }
    }
}
