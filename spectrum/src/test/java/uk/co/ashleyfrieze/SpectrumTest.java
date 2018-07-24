package uk.co.ashleyfrieze;

import com.greghaskins.spectrum.Spectrum;
import org.junit.runner.RunWith;

import java.util.function.Supplier;

import static com.greghaskins.spectrum.dsl.specification.Specification.describe;
import static com.greghaskins.spectrum.dsl.specification.Specification.it;
import static com.greghaskins.spectrum.dsl.specification.Specification.let;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

@RunWith(Spectrum.class)
public class SpectrumTest {{
    describe("Rectangles, eh!", () -> {
        describe("A square", () -> {
            Supplier<Rectangle> theSquare = let(() -> new Rectangle(5, 5));
            it("is square", () -> {
                assertThat(theSquare.get().isSquare()).isTrue();
            });
            it("has aspect ratio of 1", () -> {
                assertThat(theSquare.get().getAspectRatio()).isCloseTo(1.0, offset(0.01));
            });
            it("has same sides", () -> {
                assertThat(theSquare.get().getSides()).containsExactly(5, 5);
            });
        });

        describe("A rectangle", () -> {
            it("is not square", () -> {
                assertThat(new Rectangle(10, 2).isSquare()).isFalse();
            });
        });
    });
}}
