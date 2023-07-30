package com.tv.rectangle;

import com.tv.rectangle.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTest {

    @Test
    public void areaShouldBe_16_WithSide_4() {
        Square square = new Square(4);
        int actual = square.area();
        Assertions.assertEquals(16, actual);

    }

    @Test
    public void areaShouldBe_25_WithSide_5() {
        Square square = new Square(5);
        int actual = square.area();
        Assertions.assertEquals(25, actual);

    }

    @Test
    public void perimeterShouldBe_8_WhenSide_2() {
        Square square = new Square(2);
        int actual = square.perimeter();
        Assertions.assertEquals(8, actual);
    }
}
