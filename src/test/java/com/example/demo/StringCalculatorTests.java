package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StringCalculatorTests {

    @Autowired
    private StringCalculatorImpl stringCalculator;

    @Test
    void testCalculateFromString() {
        assertEquals(12 + 34 + 56 + 67, stringCalculator.calculateFromString("12,34.56;67+"));
        assertEquals(12 - 34 - 56 - 67, stringCalculator.calculateFromString("12,34.56;67-"));
        assertEquals(12 * 34 * 56 * 67, stringCalculator.calculateFromString("12,34.56;67*"));
        assertEquals(12.0 / 34 / 56 / 67, stringCalculator.calculateFromString("12,34.56;67/"));
        assertEquals(12 + 34 + 56 + 67, stringCalculator.calculateFromString("12,34.56;67"));
        assertEquals(1.0 * 2 * 3 * 4, stringCalculator.calculateFromString("1,2;3.4*"));
        assertEquals(100.0 / 50 / 25 / 5, stringCalculator.calculateFromString("100 50 25 5/"));
        assertEquals(3 + 5 + 2 + 5 + 1, stringCalculator.calculateFromString("3.5;2.5,1+"));
        assertEquals(100, stringCalculator.calculateFromString("100"));
    }
}
