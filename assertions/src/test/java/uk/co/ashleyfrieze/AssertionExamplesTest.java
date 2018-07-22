package uk.co.ashleyfrieze;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AssertionExamplesTest {
    @Test
    public void tryAssertTrue() {
        boolean value = true;
        assertTrue("Output should be true in this situation", value);
    }

    @Test
    public void tryAssertFalse() {
        boolean value = false;
        assertFalse("Output should be false in this situation", value);
    }

    @Test
    public void tryAssertNull() {
        Object value = "";
        assertNotNull(value);
    }

    @Test
    public void tryAssertEquals() {
        double someValue = 12.0;
        assertEquals(12.0, someValue, 0.001f);
    }

    @Test
    public void tryAssertNotEquals() {
        double someValue = 12.0;
        assertNotEquals(13, someValue, 0.001f);
    }

    @Test
    public void tryAssertFail() {
        Assert.fail("This is going to fail now");
    }

    @Test
    public void tryExpected() {
        // when this assertion fails, you get helpful output
        // for having defined the expected and actual in the right order
        assertEquals("Hello\nworld", "Hello\nWORLD!");
    }

    @Test
    public void tryAssertSame() {
        String message = "Hi";
        String otherMessage = message;

        assertSame(message, otherMessage);
        assertEquals(message, otherMessage);

        StringBuilder builder = new StringBuilder();
        builder.append("H");
        builder.append("i");

        assertNotSame(message, builder.toString());
        assertEquals(message, builder.toString());
    }
}
