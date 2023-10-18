package Java_Labs.Lab3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringTransformTest {
    private StringTransform StringText;

    @Before
    public void setUp() {
        StringText = new StringTransform();
    }
    @Test
    public void testTransformWithValidInput() throws Exception {
        StringBuffer input = new StringBuffer("hello, world");
        StringText.transform(input);
        assertEquals("ello, orld", input.toString());
    }

    @Test
    public void testTransformIgnoresRepeated() throws Exception {
        StringBuffer input = new StringBuffer("Coconut, cucumber");
        StringText.transform(input);
        assertEquals("oonut, uumber", input.toString());
    }

    @Test
    public void testTransformWithEmptyInput() {
        StringBuffer input = new StringBuffer("");
        try {
            StringText.transform(input);
            fail("Exception should have been thrown");
        } catch (Exception e) {
            assertEquals("String might not be null or empty", e.getMessage());
        }
    }

    @Test
    public void testTransformWithNullInput() {
        StringBuffer input = null;
        try {
            StringText.transform(input);
            fail("Exception should have been thrown");
        } catch (Exception e) {
            assertEquals("String might not be null or empty", e.getMessage());
        }
    }
}