package seedu.duke;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
import java.io.File;
import java.util.logging.ConsoleHandler;

/**
 * The Ui class handles user interface interactions.
 */
public class Ui {

    public static final String LINE = "_________________________________________________________________";
    public static boolean stopTutorial = false;
    private static final Logger logger = Logger.getLogger(Ui.class.getName());
    private static final String FILE_PATH = "./text-ui-test/UiLog.log";
    private final Render render;
    private final TimerTutorial tutorial;


    static {
        try {
            // Ensure directory exists
            File logFile = new File(FILE_PATH);
            if (!logFile.getParentFile().exists()) {
                logFile.getParentFile().mkdirs();  // Create the directory structure needed
            }

            // Configure the logger with handler and formatter
            FileHandler fileHandler = new FileHandler(FILE_PATH, false); // Overwrite the existing file
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL); // Log all level

            // Remove default console handler and set up custom console handler
            Logger rootLogger = Logger.getLogger("");
            ConsoleHandler consoleHandler = null;
            for (java.util.logging.Handler handler : rootLogger.getHandlers()) {
                if (handler instanceof ConsoleHandler) {
                    consoleHandler = (ConsoleHandler) handler;
                    break;
                }
            }

            if (consoleHandler != null) {
                consoleHandler.setLevel(Level.WARNING); // Only log WARNING and above to the console
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error occur in FileHandler.", e);
        }
    }


    /**
     * Constructs Ui object with the specified Render object.
     *
     * @param render The Render object used to render UI elements.
     */
    public Ui(Render render, TimerTutorial tutorial) {
        this.render = render;
        this.tutorial = tutorial;
    }

    /**
     * Displays the initial greeting message to the user.
     * This method should be called when the application starts.
     */
    public void greetUser() {
        render.displayGameMenu();
        logger.info("Displayed game menu to user.");

    }

    /**
     * Displays a random farewell message to the user when quitting the application.
     * This method should be called when the user decides to quit the application.
     */
    public void quitUser() {
        render.displayFarewellMessage();
        logger.info("Displayed farewell message to user.");

    }

    /**
     * Displays the help message to guide the user on how to use the application.
     * This method should be called when the user requests help.
     */
    public void printHelp() {
        render.displayHelpMessage();
        logger.info("Displayed help message.");

    }

    public void printTTTTutorial() {
        handleTutorial(tutorial::displayTTTTutorial, "TTT Tutorial");
    }

    public void printHangmanTutorial() {
        handleTutorial(tutorial::displayHangmanTutorial, "Hangman Tutorial");
    }

    /**
     * Handles the common logic for displaying tutorials.
     *
     * @param displayMethod The method reference to display the specific tutorial.
     * @param tutorialName The name of the tutorial for logging purposes.
     */
    private void handleTutorial(Runnable displayMethod, String tutorialName) {
        Scanner in = new Scanner(System.in);
        stopTutorial = false;
        displayMethod.run();
        logger.info("Started " + tutorialName + ".");

        while (tutorial.isTutorialRunning()) {
            if (in.hasNextLine()) {
                String input = in.nextLine().trim();

                if (Parser.ifQuit(input)) {
                    stopTutorial = true;
                    println(tutorialName + " exited! Returning back to the Main Menu...\n" + Ui.LINE);
                    break;
                } else {
                    println("Tutorial Pilot: Hey! I'm still teaching a tutorial here!");
                    logger.info("Ignored input during " + tutorialName + ": " + input);
                }
            }
        }
        logger.info("Ended " + tutorialName + ".");
    }
    /**
     * Prints the specified string to the console, followed by a newline.
     *
     * @param s The string to be printed.
     */
    public void println(String s) {
        System.out.println(s);
        logger.fine("Printed to console: " + s);
    }
}
