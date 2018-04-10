package com.sda.stirngCalc;

import com.sda.stringCalc.StringCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
    private StringCalculator calculator;
    @Before
    public void init() {
        this.calculator = new StringCalculator();
    }

    @Test
    public void testSingleNumber() {
        //given
        String text = "5";
        //when
        int result = calculator.calculate(text);
        //then
        Assert.assertEquals(result, 5);
    }

    @Test
    public void testMultipleNumbersWithWhiteSpaces() {
        //given
        String text = "1,2 ,3 ,4    , 5";
        //when
        int result = calculator.calculate(text);
        //then
        Assert.assertEquals(result, 15);
    }

    @Test
    public void testMultipleNumbers() {
        //given
        String text = "2,3,4,5,6,7,8";
        //when
        int result = calculator.calculate(text);
        //then
        Assert.assertEquals(result, 35);
    }

    @Test
    public void testCalculate() {
        //given
        String text = "2,3";
        //then
        Assert.assertEquals(calculator.calculate("3,4"), 7);
        Assert.assertEquals(calculator.calculate(text), 5);
        Assert.assertEquals(calculator.calculate("3,8"), 11);
    }

    @Test
    public void testCalculationForNull() {
        //given
        String text = null;
        //when
        int result = calculator.calculate(text);
        //then
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testCalculationForBlank() {
        //given
        String text = "";
        //when
        int result = calculator.calculate(text);
        //then
        Assert.assertEquals(result, 0);
    }
}
