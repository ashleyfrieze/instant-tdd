package uk.co.ashleyfrieze;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class AssertExceptionsAssertJTest {
    @Test
    public void willThrowThrows() {
        assertThatThrownBy(() -> willThrow())
                .isInstanceOf(IOException.class)
                .hasMessage("Bang");

        // do more stuff
    }


    private static void willThrow() throws IOException {
        throw new IOException("Bang");
    }
}
