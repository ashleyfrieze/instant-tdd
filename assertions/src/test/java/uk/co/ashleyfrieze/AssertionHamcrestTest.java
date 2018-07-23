package uk.co.ashleyfrieze;

import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Refactored to use assertThat and Hamcrest - most of which is automatically included by JUnit
 * in "hamcrest-core" though "hamcrest-all" has been added to the project to support comparison of doubles.
 */
public class AssertionHamcrestTest {
    @Test
    public void tryAssertTrue() {
        Rectangle rectangle = new Rectangle(10,10);

        assertThat(rectangle.isSquare(), is(true));
    }

    @Test
    public void tryAssertFalse() {
        Rectangle rectangle = new Rectangle(1,10);

        assertThat(rectangle.isSquare(), is(false));
    }

    @Test
    public void tryAssertTrue2() {
        Rectangle rectangle = new Rectangle(10,10);

        assertThat("Rectangle with same width and height should be square",
                rectangle.isSquare(),
                is(true));
    }

    @Test
    public void tryAssertNull() {
        Object value = null;

        assertThat(value, nullValue());
    }

    @Test
    public void tryAssertNotNull() {
        Object value = new Rectangle(1,1);

        assertThat(value, is(not(nullValue())));
    }

    @Test
    public void tryAssertEquals() {
        assertThat(new Rectangle(2, 8).getArea(), is(16));
        assertThat(new Rectangle(2, 8).getArea(), equalTo(16));
        assertThat(new Rectangle(2, 8).getArea(), is(equalTo(16)));
    }

    @Test
    public void tryAssertEqualsWithStrings() {
        assertThat("Hello\nWORLD\nnow", is("Hello\nworld\nnow"));
    }

    @Test
    public void tryAssertNotEquals() {
        assertThat(new Rectangle(2, 8).getArea(), not(99999));
    }

    @Test
    public void tryAssertEqualsWithDouble() {
        double aspectRatio = new Rectangle(1, 3).getAspectRatio();

        assertThat(aspectRatio, closeTo(0.33333333333333, 0.01));
    }

    @Test
    public void tryAssertEqualsWithObject() {
        assertThat(new Rectangle(1,1), is(new Rectangle(1,1)));
    }

    @Test
    public void tryAssertSame() {
        Rectangle example1 = new Rectangle(4,5);
        Rectangle example1SecondReference = example1;

        assertThat(example1, sameInstance(example1SecondReference));

        Rectangle duplicateOfExample1 = new Rectangle(4, 5);

        assertThat(example1, not(sameInstance(duplicateOfExample1)));
        assertThat(example1, equalTo(duplicateOfExample1));
    }

    @Test
    public void tryAssertArray() {
        Rectangle rectangle = new Rectangle(5, 6);

        // assertThat(rectangle.getSides(), arrayContaining(5, 6));
        // !!! - there's no easy way to do this
        // external matcher library - or convert the int[] to Integer[]
    }

    @Test
    public void tryAssertList() {
        Rectangle rectangle = new Rectangle(7, 8);

        assertThat(rectangle.getSidesList(), contains(7, 8));
    }
}
