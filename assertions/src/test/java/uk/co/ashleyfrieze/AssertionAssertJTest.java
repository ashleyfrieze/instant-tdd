package uk.co.ashleyfrieze;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

/**
 * Assertion examples using assertJ
 */
public class AssertionAssertJTest {
    @Test
    public void tryAssertTrue() {
        Rectangle rectangle = new Rectangle(10,10);

        assertThat(rectangle.isSquare()).isTrue();
    }


    @Test
    public void tryAssertFalse() {
        Rectangle rectangle = new Rectangle(1,10);

        assertThat(rectangle.isSquare()).isFalse();
    }

    @Test
    public void tryAssertTrue2() {
        Rectangle rectangle = new Rectangle(10,10);

        assertThat(rectangle.isSquare())
                .describedAs("Rectangle with same width and height should be square")
                .isTrue();
    }

    @Test
    public void tryAssertNull() {
        Object value = null;

        assertThat(value).isNull();
    }

    @Test
    public void tryAssertNotNull() {
        Object value = new Rectangle(1,1);

        assertThat(value).isNotNull();
    }

    @Test
    public void tryAssertEquals() {
        assertThat(new Rectangle(2, 8).getArea()).isEqualTo(16);
    }

    @Test
    public void tryAssertEqualsWithStrings() {
        assertThat("Hello\nWORLD\nnow").isEqualTo("Hello\nworld\nnow");
    }

    @Test
    public void tryAssertNotEquals() {
        assertThat(new Rectangle(2, 8).getArea()).isNotEqualTo(99999);
    }

    @Test
    public void tryAssertEqualsWithDouble() {
        double aspectRatio = new Rectangle(1, 3).getAspectRatio();

        assertThat(aspectRatio).isCloseTo(0.33333333333333, offset(0.001));
    }

    @Test
    public void tryAssertEqualsWithObject() {
        assertThat(new Rectangle(1,1)).isEqualTo(new Rectangle(1,1));
    }

    @Test
    public void tryAssertSame() {
        Rectangle example1 = new Rectangle(4,5);
        Rectangle example1SecondReference = example1;

        assertThat(example1).isSameAs(example1SecondReference);

        Rectangle duplicateOfExample1 = new Rectangle(4, 5);

        assertThat(example1).isNotSameAs(duplicateOfExample1);
        assertThat(example1).isEqualTo(duplicateOfExample1);
    }

    @Test
    public void tryAssertArray() {
        Rectangle rectangle = new Rectangle(5, 6);

        assertThat(rectangle.getSides()).containsExactly(5, 6);
    }

    @Test
    public void tryAssertList() {
        Rectangle rectangle = new Rectangle(7, 8);

        assertThat(rectangle.getSidesList()).containsExactly(7, 8);
    }
}
