package com.sda.stringCalc;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class StringCalculator {

    public int calculate(String text) {
        String textWithoutWhiteSpaces = StringUtils.deleteWhitespace(text);
        String[] elements = StringUtils.split(textWithoutWhiteSpaces, ",");
        elements = elements == null ? new String[0] : elements;
        return Arrays.stream(elements)
                .mapToInt(e -> Integer.valueOf(e))
                .sum();
    }
}
