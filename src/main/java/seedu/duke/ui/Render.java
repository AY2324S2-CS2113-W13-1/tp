package seedu.duke.ui;
import java.util.Random;

/**
 * The Render Class contains all ASCII art, messages, and tutorial frames to be executed in Ui Class.
 */
public class Render {

    /**
     * Array of sentences to be chosen at random for quitUser().
     */
    public static String[] BYE_SENTENCES = {
        "AeroCade dismissed. Fly with honor and return victorious.",
        "Departure clearance granted. Execute your aero-maneuvers with expertise.",
        "Aero-Launch sequence initiated. Depart with purpose.",
        "Permission to depart granted. Execute your flight plan with discipline."
    };

    /**
     * ASCII Aerocade logo to be displayed at the start.
     */
    public static String logo = "\n\n\n" + Ui.LINE + "\n" +
            "               _______  _______  ______    _______              \n" +
            "              |   _   ||       ||    _ |  |       |             \n" +
            "  __|____|__  |  |_|  ||    ___||   | ||  |   _   |             \n" +
            "    |  X |    |       ||   |___ |   |_||_ |  | |  |             \n" +
            "  __|____|__  |       ||    ___||    __  ||  |_|  |             \n" +
            "   O|  X |O   |   _   ||   |___ |   |  | ||       |             \n" +
            "              |__| |__||_______||___|  |_||_______|             \n" +
            "               _______  _______  ______   _______               \n" +
            "              |       ||   _   ||      | |       |              \n" +
            "              |       ||  |_|  ||  _    ||    ___|              \n" +
            "              |       ||       || | |   ||   |___     |  @      \n" +
            "              |      _||       || |_|   ||    ___|    | /|\\    \n" +
            "              |     |_ |   _   ||       ||   |___     |  |      \n" +
            "              |_______||__| |__||______| |_______|    | / \\  \n\n" ;

    /**
     * ASCII boeing art to be displayed at the start and at the end of program
     */
    public static String boeing =
            "                                |                              \n" +
            "                              .-'-.                            \n" +
            "                             ' ___ '                           \n" +
            "                   ---------'  .-.  '---------                 \n" +
            "   _________________________'  '-'  '_________________________ \n" +
            "    ''''''-|---|--/    \\==][^',_m_,'^][==/    \\--|---|-''''''\n" +
            "                  \\    /  ||/   H   \\||  \\    /             \n" +
            "                   '--'   OO   O|O   OO   '--' \n              \n";

    /**
     * ASCII menu selection art to be displayed at the start
     */
    private final String menu =
            "\n              [      Welcome to the AeroCade      ]\n" + Ui.LINE + "\n" +
            "              [          Choose your game:        ]                \n" +
            "                                |                                  \n" +
            "        X  |  -  |  -           |          _______                 \n" +
            "       ____|_____|____          |          |     |                 \n" +
            "           |     |              |          |     @                 \n" +
            "        -  |  O  |  X           |          |    /|\\               \n" +
            "       ____|_____|____          |          |     |                 \n" +
            "           |     |              |          |    / \\               \n" +
            "        -  |  O  |  -           |        ==============            \n" +
            "________________________________|________________________________  \n" +
            "         TIC-TAC-TOE            |           HANGMAN                \n" +
            "          Type 'TTT'            |        Type 'hangman'            \n" +
            "\n\nType 'help' for a list of available commands!                  \n";


    /**
     * Prints the given string to the console.
     *
     * @param s The string to be printed.
     */
    public void println(String s) {
        System.out.println(s);
    }

    /**
     * Greets the user by displaying the AeroCade logo, boeing, and game menu.
     */
    public void displayGameMenu() {
        println(logo + boeing + Ui.LINE + menu + Ui.LINE);
    }

    /**
     * Displays a random farewell message from an array to the user.
     */
    public void displayFarewellMessage() {
        int randomIndex = new Random().nextInt(BYE_SENTENCES.length);
        println(Ui.LINE + "\n\n" + boeing + BYE_SENTENCES[randomIndex] + "\n");
    }

    /**
     * Prints a help message listing the available commands.
     */
    public void displayHelpMessage() {
        println(Ui.LINE + "\nHere are the list of commands:\n" + Ui.LINE +
                "\n[Gameplay:]" +
                "\ntype 'TTT tutorial' for a Tic-tac-toe example gameplay\n" +
                "'TTT' - Starts Tic-tac-toe Game\n" +
                "type 'hangman tutorial' for a Hangman example gameplay\n" +
                "'hangman' - Starts Hangman Game\n" +
                "[Miscellaneous:]\n" +
                "'stats' to see games won\n"  +
                "'quit' to exit the program\n"+ Ui.LINE);
    }

    /**
     * Retrieves an array of 7 TTT Tutorial frames, each frame to be called in TimerTutorial every 4 seconds.
     *
     * @return An array of strings detailing each frame of the TTT tutorial.
     */
    public static String[] getTTTFrames() {
        return new String[] { Ui.LINE +
                "\n[Tutorial Mode is playing, do not input any commands!]\n" +
                "Tutorial Pilot: Good day! this is Tutorial Pilot and I will demonstrate\n" +
                "                a stellar gameplay of TTT for you!\n\n" +
                "    |   |    \n" +
                "-------------\n" +
                "    |   |    \n" +
                "-------------\n" +
                "    |   |    \n\n" +
                "Tutorial Pilot: This is a TTT board which I'll be placing an 'X' depending on\n" +
                "                the number I put, here is the numbered layout!\n" + Ui.LINE,

            "  1 | 2 | 3  \n" +
                        "-------------\n" +
                        "  4 | 5 | 6  \n" +
                        "-------------\n" +
                        "  7 | 8 | 9  \n\n" +
                        "Tutorial Pilot: I shall put '5'. I must get a row, column or diagonal of 'X' to win!\n" +
                        Ui.LINE,

            "    |   |    \n" +
                        "-------------\n" +
                        "    | X |    \n" +
                        "-------------\n" +
                        "    |   |    \n\n" +
                        "Tutorial Pilot: I wonder how my opponent will respond...\n" + Ui.LINE,

            "    |   |    \n" +
                        "-------------\n" +
                        "    | X | O  \n" +
                        "-------------\n" +
                        "    |   |    \n\n" +
                        "Tutorial Pilot: Goodness gracious! I'll perform a flank by putting '9'!\n" + Ui.LINE,

            "    |   |    \n" +
                        "-------------\n" +
                        "    | X | O  \n" +
                        "-------------\n" +
                        "    |   | X  \n\n" +
                        "Tutorial Pilot: Surely my opponent will get stumped!\n" + Ui.LINE,

            "    |   |    \n" +
                        "-------------\n" +
                        "  O | X | O  \n" +
                        "-------------\n" +
                        "    |   | X  \n\n" +
                        "Tutorial Pilot: The opponent made a mistake! Now is my chance to put '1'!\n" + Ui.LINE,

            "  X |   |    \n" +
                        "-------------\n" +
                        "  O | X | O  \n" +
                        "-------------\n" +
                        "    |   | X  \n\n" +
                        "Tutorial Pilot: I won! Hope this tutorial gameplay was helpful.\n" +
                        "                Tutorial Pilot, signing off~\n" +
                        "[Tutorial Mode over, resuming commands in 4 seconds!]\n" + Ui.LINE
        };
    }

    /**
     * Retrieves an array of 9 Hangman Tutorial frames, each frame to be called in TimerTutorial every 4 seconds.
     *
     * @return An array of strings detailing each frame of the Hangman tutorial.
     */
    public static String[] getHangmanFrames() {
        return new String[] { Ui.LINE +
                "\n[Tutorial Mode is playing, do not input any commands!]\n" +
                "Tutorial Pilot: Good day! this is Tutorial Pilot and I will demonstrate\n" +
                "                a stellar gameplay of Hangman for you!\n\n" +
                "_______        \n" +
                "|     |        \n" +
                "|              \n" +
                "|              \n" +
                "|              \n" +
                "|              \n" +
                "============== \n" +
                "_ _ _ _ _      \n\n" +
                "Tutorial Pilot: This is the start of the game, for this tutorial, I'll need to\n" +
                "                guess a 5-letter word before the 'hangman' is drawn out, which\n" +
                "                means I can only make 5 wrong guesses! Let's try the letter 'a'\n" + Ui.LINE,

            "_______        \n" +
                        "|     |        \n" +
                        "|     @        \n" +
                        "|              \n" +
                        "|              \n" +
                        "|              \n" +
                        "============== \n" +
                        "_ _ _ _ _      \n\n" +
                        "Tutorial Pilot: Oh no! There is no 'a' in this word, looks like I'll try another vowel 'o'\n"
                        + Ui.LINE,

            "_______        \n" +
                        "|     |        \n" +
                        "|     @        \n" +
                        "|     |        \n" +
                        "|     |        \n" +
                        "|              \n" +
                        "============== \n" +
                        "_ _ _ _ _      \n\n" +
                        "Tutorial Pilot: I'm in trouble! How about 'e'?\n" + Ui.LINE,

            "_______        \n" +
                        "|     |        \n" +
                        "|     @        \n" +
                        "|    /|        \n" +
                        "|     |        \n" +
                        "|              \n" +
                        "============== \n" +
                        "_ _ _ _ _      \n\n" +
                        "Tutorial Pilot: Goodness gracious, maybe 'i'?\n" + Ui.LINE,

            "_______        \n" +
                        "|     |        \n" +
                        "|     @        \n" +
                        "|    /|\\      \n" +
                        "|     |        \n" +
                        "|              \n" +
                        "============== \n" +
                        "_ _ _ _ _      \n\n" +
                        "Tutorial Pilot: I have two tries left! This word is strange, I might have to change\n" +
                        "                my strategy here, I'll try 'y'!\n" + Ui.LINE,

            "_______        \n" +
                        "|     |        \n" +
                        "|     @        \n" +
                        "|    /|\\      \n" +
                        "|     |        \n" +
                        "|              \n" +
                        "============== \n" +
                        "_ _ y _ _      \n\n" +
                        "Tutorial Pilot: Yes! I might win here, I'm going with 'h' now!\n" + Ui.LINE,

            "_______        \n" +
                        "|     |        \n" +
                        "|     @        \n" +
                        "|    /|\\      \n" +
                        "|     |        \n" +
                        "|              \n" +
                        "============== \n" +
                        "_ _ y _ h      \n\n" +
                        "Tutorial Pilot: Awesome, I'll try my luck with the whole word 'psych'!\n" + Ui.LINE,

            "_______        \n" +
                        "|     |        \n" +
                        "|     @        \n" +
                        "|    /|\\      \n" +
                        "|     |        \n" +
                        "|    /         \n" +
                        "============== \n" +
                        "_ _ y _ h      \n\n" +
                        "Tutorial Pilot: NOOO, I have only 1 try left, I'm going with 'glyph' now\n" + Ui.LINE,

            "g l y p h      \n\n" +
                        "Tutorial Pilot: Whew that was a close one! Hope this tutorial gameplay was helpful.\n" +
                        "                Tutorial Pilot, signing off~\n" +
                        "[Tutorial Mode over, resuming commands in 4 seconds!]\n" + Ui.LINE
        };
    }
}
