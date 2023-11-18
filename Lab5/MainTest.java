package Java_Labs.Lab5;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * JUnit test class for the Main class and its associated methods.
 */

public class MainTest {

    /**
     * Test the constructor of the Word class.
     */

    @Test
    public void testWordConstructor() {
        Word word = new Word("Hello");
        assertEquals(5, word.getLetters().size());
        assertEquals("Hello", word.toString());
    }

    /**
     * Test the constructor of the Sentence class.
     */

    @Test
    public void testSentenceConstructor() {
        Sentence sentence = new Sentence("Hello world!");
        assertEquals(2, sentence.getElements().size());
        assertEquals("Hello world!", sentence.toString());
    }

     /**
     * Test the constructor of the Text class.
     */

    @Test
    public void testTextConstructor() {
        Text text = new Text("This is a test. Another test.");
        assertEquals(2, text.getSentences().size());
        assertEquals("This is a test", text.getSentences().get(0).toString());
        assertEquals("Another test.", text.getSentences().get(1).toString());
    }

    /**
     * Test the transform method for a Word object.
     */

    @Test
    public void testTransform() {
        Word word = new Word("banana");
        Main.transform(word);
        assertEquals(5, word.getLetters().size());
        assertEquals("anana", word.toString());
    }

    /**
     * Test the transform method for a Word object with case-insensitive comparison.
     */

    @Test
    public void testTransformCaseInsensitive() {
        Word word = new Word("BoOk");
        Main.transform(word);
        assertEquals(3, word.getLetters().size());
        assertEquals("oOk", word.toString());
    }

    /**
     * Test the transform method for a Word object with mixed case.
     */

    @Test
    public void testTransformMixedCase() {
        Word word = new Word("AbCD");
        Main.transform(word);
        assertEquals(3, word.getLetters().size());
        assertEquals("bCD", word.toString());
    }

    /**
     * Test the transform method for an empty Word object.
     */

    @Test
    public void testTransformEmptyWord() {
        Word word = new Word("");
        Main.transform(word);
        assertEquals(0, word.getLetters().size());
        assertEquals("", word.toString());
    }

    /**
     * Test the transform method for a Text object.
     */

    @Test
    public void testTransformText() {
        Text text = new Text("This is a simple test. Another example.");
        Main.transform(text);
        assertEquals(2, text.getSentences().size());
        assertEquals("his s  imple es", text.getSentences().get(0).toString());
        assertEquals("nother xampl.", text.getSentences().get(1).toString());
    }
}

