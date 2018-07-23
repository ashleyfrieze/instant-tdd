package uk.co.ashleyfrieze;

import org.junit.Test;

import java.io.IOException;

public class AssertExceptionsTest {
    @Test(expected = IOException.class)
    public void willThrowThrows() throws Exception {
        willThrow();
    }


    private static void willThrow() throws IOException {
        throw new IOException("Bang");
    }
}
