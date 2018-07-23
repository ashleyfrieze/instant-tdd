package uk.co.ashleyfrieze;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class AssertExceptionsRuleTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void willThrowError() throws Exception {
        expectedException.expect(IOException.class);
        expectedException.expectMessage("ang");

        willThrow();
    }

    private static void willThrow() throws IOException {
        throw new IOException("Bang");
    }
}
