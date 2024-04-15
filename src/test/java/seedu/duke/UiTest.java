package seedu.duke;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import seedu.duke.ui.Render;
import seedu.duke.ui.TimerTutorial;
import seedu.duke.ui.Ui;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the functionality of the Ui component, ensuring it correctly handles output and user interactions
 * during tutorials and standard operations.
 */
public class UiTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /**
     * Redirects the standard System.out to capture output for verification.
     */
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Restores the standard System.out output stream after each test.
     */
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    /**
     * Tests that the Tic-tac-toe tutorial prints correctly and ignores user input.
     */
    @Test
    public void printTTTTutorial_displaysTutorialAndIgnoresInput() {
        Ui ui = new Ui(new Render(), new TimerTutorial());

        System.setIn(new java.io.ByteArrayInputStream("random input\n".getBytes()));
        ui.printTTTTutorial();

        // Check if the correct output was printed
        assertTrue(outContent.toString().contains("Tutorial Pilot: Hey! I'm still teaching a tutorial here!"));
    }

    /**
     * Tests that the Hangman tutorial prints correctly and ignores user input.
     */
    @Test
    public void printHangmanTutorial_displaysTutorialAndIgnoresInput() {
        Ui ui = new Ui(new Render(), new TimerTutorial());

        System.setIn(new java.io.ByteArrayInputStream("random input\n".getBytes()));
        ui.printHangmanTutorial();

        // Check if the correct output was printed
        assertTrue(outContent.toString().contains("Tutorial Pilot: Hey! I'm still teaching a tutorial here!"));
    }

    /**
     * Tests that the exit message is correctly printed when the "quit" command is input during the Hangman tutorial.
     */
    @Test
    public void printsExitMessageForHangmanTutorial() {
        testTutorialExitMessage("quit\n", "Hangman Tutorial exited! Returning back to the Main " +
                "Menu in 4 seconds...\n", true);
    }

    /**
     * Tests that the exit message is correctly printed when the "quit" command is input during the TTT tutorial.
     */
    @Test
    public void printsExitMessageForTTTTutorial() {
        testTutorialExitMessage("quit\n", "TTT Tutorial exited! Returning back to the Main" +
                " Menu in 4 seconds...\n", false);
    }

    /**
     * Helper method to test the exit message for tutorials.
     * @param input The input to simulate user interaction.
     * @param expectedOutput The expected output string to verify.
     * @param isHangman Flag to determine if Hangman or TTT tutorial should be tested.
     */
    private void testTutorialExitMessage(String input, String expectedOutput, boolean isHangman) {
        Ui ui = new Ui(new Render(), new TimerTutorial());
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        if (isHangman) {
            ui.printHangmanTutorial();
        } else {
            ui.printTTTTutorial();
        }

        assertTrue(outContent.toString().contains(expectedOutput));
    }


    /**
     * Tests that the println method correctly prints a given message.
     */
    @Test
    public void println_printsCorrectMessage() {
        Ui ui = new Ui(null, null); // Constructor won't be used to invoke println
        ui.println("Hello world!");
        assertTrue(outContent.toString().contains("Hello world!"));
    }

    /**
     * Tests that the greetUser method displays the application logo.
     */
    @Test
    public void greetUser_displaysLogo() {
        Ui ui = new Ui(new Render(), new TimerTutorial());
        ui.greetUser();
        assertTrue(outContent.toString().contains(Render.logo));
    }

    /**
     * Tests that the printHelp method displays the help information correctly.
     */
    @Test
    public void printHelp_displaysLine() {
        Ui ui = new Ui(new Render(), new TimerTutorial());
        ui.printHelp();
        assertTrue(outContent.toString().contains(Ui.LINE));
    }

    /**
     * Tests that the quitUser method correctly displays the quit message.
     */
    @Test
    public void quitUser_displaysBoeing() {
        Ui ui = new Ui(new Render(), new TimerTutorial());
        ui.quitUser();
        assertTrue(outContent.toString().contains(Render.boeing));
    }
}

