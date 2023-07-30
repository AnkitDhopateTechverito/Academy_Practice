package com.tv.rectangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RectangleTest {
    @Test
    public void areaShouldBe_6_whereLength_2_AndBreadth_3() {
        Rectangle rectangle = new Rectangle(2, 3);
        int actual = rectangle.area();
        Assertions.assertEquals(6, actual);
    }

    @Test
    public void areaShouldBe_8_whereLength_2_AndBreadth_4() {
        //arrange
        Rectangle rectangle = new Rectangle(2, 4);
        //act
        int actual = rectangle.area();
        //assert
        Assertions.assertEquals(8, actual);
    }

    @Test
    public void areaShouldBe_20_whereLength_5_AndBreadth_4() {
        Rectangle rectangle = new Rectangle(5, 4);
        int actual = rectangle.area();
        Assertions.assertEquals(20, actual);
    }

    @Test
    public void perimeterShouldBe_14_WhereLength_3_And_Breadth_4() {
        Rectangle rectangle = new Rectangle(3, 4);
        int actual = rectangle.perimeter();
        Assertions.assertEquals(14, actual);
    }

    @Test
    public void perimeterShouldBe_24_WhereLength_8_And_Breadth_4() {
        Rectangle rectangle = new Rectangle(8, 4);
        int actual = rectangle.perimeter();
        Assertions.assertEquals(24, actual);
    }

    @Test
    public void shouldRenderRectangle() {
        RectangleStub rectangle = new RectangleStub(25, 5);
        rectangle.render();
        Assertions.assertTrue(rectangle.isInvoked());
    }

    @Test
    public void shouldNotRenderRectangleWhenRenderMethodIsNotInvoked() {
        RectangleStub rectangle = new RectangleStub(2, 3);
        Assertions.assertFalse(rectangle.isInvoked());
    }

    @Test
    public void shouldRenderRectangleWhoesAreaIsMoreThan_100_() {
        RectangleStub rectangle_with_area_6 = new RectangleStub(2, 3);
        RectangleStub rectangle_with_area_100 = new RectangleStub(25, 5);

        rectangle_with_area_6.render();
        rectangle_with_area_100.render();

        Assertions.assertFalse(rectangle_with_area_6.isInvoked());
        Assertions.assertTrue(rectangle_with_area_100.isInvoked());
    }

    @Test
    public void shouldRenderRectangleWhoesAreaIsMoreThan_100_test_2() {
        RectangleStub rectangle_with_area_6 = new RectangleStub(2, 3);
        RectangleStub rectangle_with_area_15 = new RectangleStub(5, 3);

        rectangle_with_area_6.render();
        rectangle_with_area_15.render();

        Assertions.assertFalse(rectangle_with_area_6.isInvoked());
        Assertions.assertFalse(rectangle_with_area_15.isInvoked());
    }

    class RectangleStub extends Rectangle{

        private final int length;
        private final int breadth;
        private boolean invoked;

        public RectangleStub(int length, int breadth) {
            super(length, breadth);
            this.length = length;
            this.breadth = breadth;
        }

        public void render(){
            if(isAreaGreaterThan100())  this.invoked = true;
        }

        public int area() {
            return length * breadth;
        }

        public int perimeter() {
            return 2 * (length + breadth);
        }

        public boolean isInvoked(){
            return invoked;
        }

        private boolean isAreaGreaterThan100() {
            if(this.area()>100) return true;
            return false;
        }
    }
}
