package uk.co.ashleyfrieze;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockitoExamplesTest {
    @Mock
    private SomeInterface someInterface;

    @Captor
    private ArgumentCaptor<List<String>> listCaptor;

    @Test
    public void thenReturnAnyIntExample() {
        when(someInterface.getMatchingSize(anyInt(), anyInt()))
                .thenReturn(1);

        for(int i=0; i<5; i++) {
            System.out.println(someInterface.getMatchingSize(1,2));
        }
    }

    @Test
    public void thenReturnExamples() {
        when(someInterface.getMatchingSize(9, 9))
                .thenReturn(1)
                .thenReturn(2)
                .thenReturn(3);

        for(int i=0; i<5; i++) {
            System.out.println(someInterface.getMatchingSize(9,9));
        }
    }

    @Test
    public void verifyExample() {
        //// when we run code that uses the mock
        someInterface.getMatchingSize(1, 2);
        ////

        // then the mock has received the right call
        verify(someInterface).getMatchingSize(1, 2);
    }

    @Test
    public void verifyMultipleExample() {
        //// when we run code that uses the mock
        someInterface.getMatchingSize(1, 2);
        someInterface.getMatchingSize(1, 2);
        ////

        // then the mock has received two calls
        verify(someInterface, times(2)).getMatchingSize(1, 2);
    }

    @Test
    public void verifyConcurrent() {
        //// when we run code that uses the mock
        // a concurrent caller
        new Thread(() -> {
            for(int i=0; i<20; i++) {
                someInterface.getMatchingSize(1, 2);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) { }
            }
        }).start();
        ////

        // then the mock will have received the calls
        verify(someInterface, timeout(2000).atLeast(10))
                .getMatchingSize(1, 2);
    }

    @Test
    public void verifyArgument() {
        //// when we run code that uses the mock
        someInterface.receiveList(asList("A","B","C"));
        ////

        // then the mock was called with a list with
        // three items in it
        verify(someInterface).receiveList(listCaptor.capture());

        assertEquals(3, listCaptor.getValue().size());
    }

    @Test
    public void verifyArgumentWithoutCaptors() {
        //// when we run code that uses the mock
        someInterface.receiveList(asList("A","B","C"));
        ////

        // then the mock was called with a list with
        // three items in it
        verify(someInterface).receiveList(argThat(list -> list.size() == 3));
    }

    @Test(expected=IOException.class)
    public void willThrow() throws Exception {
        when(someInterface.isFileValid("myfile")).thenThrow(new IOException("Boom"));

        //// when we run code that uses the mock
        someInterface.isFileValid("myfile");
    }

    @Test
    public void thenAnswer() {
        when(someInterface.getMatchingSize(anyInt(), anyInt())).thenAnswer(new Answer<Integer>() {

            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                return (int)invocation.getArguments()[0] + (int)invocation.getArguments()[1];
            }
        });

        // assert the mock... in real life
        // we would assert the outcome code using the mock
        assertEquals(4, someInterface.getMatchingSize(1, 3));
    }

    @Test
    public void spying() {
        Set<Integer> set = spy(new LinkedHashSet<>());

        calculatePrimes(set, 100);

        assertTrue(set.contains(31));

        verify(set).add(31);
    }

    private static void calculatePrimes(Set<Integer> primes, int max) {
        for(int i=2; i<=max; i++) {
            if (!divisibleByAny(i, primes)) {
                primes.add(i);
            }
        }
    }

    private static boolean divisibleByAny(int newNumber, Set<Integer> primes) {
        for(Integer prime:primes) {
            if (newNumber % prime == 0) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void bddMockito() throws Exception {
        // given a mock set up to validate my file
        given(someInterface.isFileValid("myFile"))
                .willReturn(true);

        // when we validate my file
        boolean isValid = someInterface.isFileValid("myFile");

        // then the answer is "VALID"
        assertTrue(isValid);
    }

    @Test(expected = RuntimeException.class)
    public void whenWhenIsNotEnough() {
        Set<Integer> set = spy(new HashSet<>());

        doThrow(new RuntimeException("boom"))
                .when(set)
                .add(31);

        System.out.println(set.contains(31));

        set.add(31);
    }

    @Test
    public void mockPredicate() {
        Predicate<Integer> predicate = i -> i == 12;

        assertTrue(predicate.test(12));
    }

}















