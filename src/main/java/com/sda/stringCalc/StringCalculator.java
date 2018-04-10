package com.sda.stringCalc;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    public int calculate(String text) {
        text = StringUtils.deleteWhitespace(text);
        if (StringUtils.isBlank(text)) {
            return 0;
        }
        String[] names = text.split(",");
        int sum = 0;
        for (int i = 0; i < names.length; i++) {
            sum += Integer.valueOf(names[i]);
        }
        return sum;
    }
}
