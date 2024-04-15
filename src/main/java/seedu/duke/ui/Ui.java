package seedu.duke.ui;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
import java.io.File;
import java.util.logging.ConsoleHandler;
import seedu.duke.Parser;

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
        setupLogging();
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
     * Sets up logging to file and console. Configures levels and formats for logging output.
     */
    private static void setupLogging() {
        try {
            createLogFileIfNotExists();
            configureFileLogging();
            configureConsoleLogging();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error occurred during logging setup.", e);
        }
    }

    /**
     * Ensures that the log file and its parent directories exist. Creates one if it doesn't exist.
     */
    private static void createLogFileIfNotExists() throws IOException {
        File logFile = new File(FILE_PATH);
        if (!logFile.getParentFile().exists()) {
            logFile.getParentFile().mkdirs();
        }
    }

    /**
     * Configures logger to write to UiLog.log file.
     */
    private static void configureFileLogging() throws IOException {
        FileHandler fileHandler = new FileHandler(FILE_PATH, false);
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);
        logger.setLevel(Level.ALL); // Log all levels of messages
    }

    /**
     * Configures console logging to only log WARNING and above.
     */
    private static void configureConsoleLogging() {
        Logger rootLogger = Logger.getLogger("");
        ConsoleHandler consoleHandler = findConsoleHandler(rootLogger);
        if (consoleHandler != null) {
            consoleHandler.setLevel(Level.WARNING); // Only log WARNING and above to console
        }
    }


    /**
     * Finds and returns the ConsoleHandler from the root logger.
     *
     * @param rootLogger The root logger from which to find the ConsoleHandler.
     * @return the ConsoleHandler if found, otherwise null.
     */
    private static ConsoleHandler findConsoleHandler(Logger rootLogger) {
        for (java.util.logging.Handler handler : rootLogger.getHandlers()) {
            if (handler instanceof ConsoleHandler) {
                return (ConsoleHandler) handler;
            }
        }
        return null;
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

    /**
     * Initiates and displays the TTT tutorial.
     * Delegates the tutorial display to a specific tutorial handler.
     */
    public void printTTTTutorial() {
        handleTutorial(tutorial::displayTTTTutorial, "TTT Tutorial");
    }

    /**
     * Initiates and displays the Hangman tutorial.
     * Delegates the tutorial display to a specific tutorial handler.
     */
    public void printHangmanTutorial() {
        handleTutorial(tutorial::displayHangmanTutorial, "Hangman Tutorial");
    }

    /**
     * Handles the common logic for displaying tutorials. Every User Input other than quit is ignored.
     *
     * @param displayMethod The method reference to display the specific tutorial.
     * @param tutorialName The name of the tutorial to be displayed, either TTT or Hangman
     */
    private void handleTutorial(Runnable displayMethod, String tutorialName) {
        startTutorial(displayMethod, tutorialName);
        handleInputsDuringTutorial(tutorialName);
    }

    /**
     * Starts the tutorial and logs the start.
     *
     * @param displayMethod The tutorial display method to run.
     * @param tutorialName The name of the tutorial being started.
     */
    private void startTutorial(Runnable displayMethod, String tutorialName) {
        stopTutorial = false;
        displayMethod.run();
        logger.info("Started " + tutorialName + ".");
    }

    /**
     * Processes user inputs during the tutorial using a tutorialRunning flag from TimerTutorial
     *
     * @param tutorialName The name of the tutorial.
     */
    private void handleInputsDuringTutorial(String tutorialName) {
        Scanner in = new Scanner(System.in);

        while (tutorial.isTutorialRunning()) {
            if (in.hasNextLine()) {
                String input = in.nextLine().trim();
                quitOrIgnoreInput(input, tutorialName);
            }
        }
        logger.info("Ended " + tutorialName + ".");
    }

    /**
     * Ignores every input except quit, which quits tutorial mode.
     *
     * @param input The user's input.
     * @param tutorialName The name of the tutorial.
     */
    private void quitOrIgnoreInput(String input, String tutorialName) {
        if (Parser.ifQuit(input)) {
            stopTutorial = true;
            println(tutorialName + " exited! Returning back to the Main Menu in 4 seconds...\n" + Ui.LINE);
        } else {
            println("Tutorial Pilot: Hey! I'm still teaching a tutorial here!");
            logger.info("Ignored input during " + tutorialName + ": " + input);
        }
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
