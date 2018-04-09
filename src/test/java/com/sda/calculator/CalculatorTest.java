package com.sda.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void init() {
        this.calculator = new Calculator();
    }
    @Test
    public void testAdd() {
        //when
        int sum = calculator.sum(5, 9);
        //then
        Assert.assertEquals("result is not 8",14, sum);
    }
    @Test
    public void testSubtract() {
        //when
        int subtract = calculator.subtract(9, 5);
        //then
        Assert.assertEquals(subtract, 4);
    }
    @Test
    public void testMultiply() {
        //when
        int multiply = calculator.multiply(3, 4);
        //then
        Assert.assertEquals(multiply, 12);
    }
    @Test
    public void testDivide() {
        //then
        Assert.assertEquals(calculator.divide(10,5), 2);
    }
}
