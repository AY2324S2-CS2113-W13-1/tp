package seedu.duke.ui;

import java.util.Timer;
import java.util.TimerTask;

/**
 * The TimerTutorial class retrieves tutorial frames from Render and displays each frame every 4 seconds.
 */
public class TimerTutorial {
    private boolean tutorialRunning = false; // Flag to track if tutorial is running

    /**
     * Checks if a tutorial is currently running.
     *
     * @return true if a tutorial is running, false otherwise.
     */
    public boolean isTutorialRunning() {
        return tutorialRunning;
    }

    /**
     * Displays the TTT tutorial. It retrieves tutorial frames from the Render class
     * and displays each frame every 4 seconds until the tutorial is complete after 7 frames.
     */
    public void displayTTTTutorial() {
        tutorialRunning = true;
        String[] tttFrames = Render.getTTTFrames();
        int tttInterval = 4000; // 4 seconds interval
        scheduleTutorialFrames(tttFrames, tttInterval);
    }

    /**
     * Displays the Hangman tutorial. It retrieves tutorial frames from the Render class
     * and displays each frame every 4 seconds until the tutorial is complete after 9 frames.
     */
    public void displayHangmanTutorial() {
        tutorialRunning = true;
        String[] hangmanFrames = Render.getHangmanFrames();
        int hangmanInterval = 4000; // 4 seconds interval
        scheduleTutorialFrames(hangmanFrames, hangmanInterval);
    }


    /**
     * Displays tutorial frames at specified intervals using a timer. Inputs will not be read till
     * all frames are displayed.
     *
     * @param frames   The frames of the tutorial.
     * @param interval The interval (in milliseconds) between displaying each frame.
     */
    private void scheduleTutorialFrames(String[] frames, int interval) {
        Timer timer = new Timer();
        int[] index = {0}; // Array to store the current frame index
        TimerTask task = createTimerTask(timer, frames, index);
        timer.scheduleAtFixedRate(task, 0, interval); // Schedule the task to run at fixed intervals
    }

    /**
     * Creates a TimerTask that handles the display of tutorial frames and checks for quit conditions.
     *
     * @param timer  The timer object to schedule the task.
     * @param frames The frames of the tutorial to display.
     * @param index  The current frame index in the String[].
     * @return A new TimerTask for handling frame display.
     */
    private TimerTask createTimerTask(Timer timer, String[] frames, int[] index) {
        return new TimerTask() {
            @Override
            public void run() {
                handleFrameDisplay(timer, frames, index);
            }
        };
    }

    /**
     * Handles the display of a single frame or stops the tutorial if quit or
     * if all frames have been displayed.
     *
     * @param timer  The timer to potentially cancel.
     * @param frames The frames of the tutorial.
     * @param index  The current index of the frame being displayed.
     */
    private void handleFrameDisplay(Timer timer, String[] frames, int[] index) {
        if (Ui.stopTutorial) { // Check if quit command
            stopTutorial(timer);
        } else if (index[0] < frames.length) {
            System.out.println(frames[index[0]]); // Print the current frame
            index[0]++;
        } else {
            stopTutorial(timer); //after all frames are used.
        }
    }

    /**
     * Stops the tutorial and cancels the timer.
     *
     * @param timer The timer to cancel.
     */
    private void stopTutorial(Timer timer) {
        tutorialRunning = false;
        timer.cancel();
    }
}
