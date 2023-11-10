package Java_Labs.Lab5;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testWordConstructor() {
        Word word = new Word("Hello");
        assertEquals(5, word.getLetters().size());
        assertEquals("Hello", word.toString());
    }

    @Test
    public void testSentenceConstructor() {
        Sentence sentence = new Sentence("Hello world!");
        assertEquals(2, sentence.getElements().size());
        assertEquals("Hello world!", sentence.toString());
    }

    @Test
    public void testTextConstructor() {
        Text text = new Text("This is a test. Another test.");
        assertEquals(2, text.getSentences().size());
        assertEquals("This is a test", text.getSentences().get(0).toString());
        assertEquals("Another test.", text.getSentences().get(1).toString());
    }

    @Test
    public void testTransform() {
        Word word = new Word("banana");
        Main.transform(word);
        assertEquals(5, word.getLetters().size());
        assertEquals("anana", word.toString());
    }

    @Test
    public void testTransformCaseInsensitive() {
        Word word = new Word("BoOk");
        Main.transform(word);
        assertEquals(3, word.getLetters().size());
        assertEquals("oOk", word.toString());
    }

    @Test
    public void testTransformMixedCase() {
        Word word = new Word("AbCD");
        Main.transform(word);
        assertEquals(3, word.getLetters().size());
        assertEquals("bCD", word.toString());
    }

    @Test
    public void testTransformEmptyWord() {
        Word word = new Word("");
        Main.transform(word);
        assertEquals(0, word.getLetters().size());
        assertEquals("", word.toString());
    }

//    @Test
//    public void testTransformSentence() {
//        Sentence sentence = new Sentence("Hello World!");
//        Main.transform(sentence);
//        assertEquals(3, sentence.getElements().size());
//        assertEquals("Helo Wold!", sentence.toString());
//    }

    @Test
    public void testTransformText() {
        Text text = new Text("This is a simple test. Another example.");
        Main.transform(text);
        assertEquals(2, text.getSentences().size());
        assertEquals("his s  imple es", text.getSentences().get(0).toString());
        assertEquals("nother xampl.", text.getSentences().get(1).toString());
    }
}

