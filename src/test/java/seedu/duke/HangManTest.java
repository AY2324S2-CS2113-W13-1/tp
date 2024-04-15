package seedu.duke;


import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class HangManTest {

    @Test
    public void dummyTest(){
        assertTrue(true);
    }

    @Test
    public void testAddLetter() {
        String userInput = "a";
        int guessType = Parser.parseGuess(userInput);
        assertEquals(1,guessType);
    }

    @Test
    public void testAddWord() {
        String userInput = "word";
        int guessType = Parser.parseGuess(userInput);
        assertEquals(2,guessType);
    }

    @Test
    public void testNullInput() {
        String userInput = "";
        int guessType = Parser.parseGuess(userInput);
        assertEquals(0,guessType);
    }


}
