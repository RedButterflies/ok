package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StringCalculatorImpl implements StringCalculator {
    @Override

    public double calculateFromString(String input) {
        String separators = "[,;. ]";
        char[] operators = {'+', '-', '*', '/'};
        char operator = ' ';

        if (input.length() > 0) {
            char lastChar = input.charAt(input.length() - 1);
            for (char op : operators) {
                if (lastChar == op) {
                    operator = lastChar;
                    input = input.substring(0, input.length() - 1);
                    break;
                }
            }
        }

        String[] numberStrings = input.split(separators);
        List<Double> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            if (!numberString.isEmpty()) {
                numbers.add(Double.parseDouble(numberString));
            }
        }

        double result = 0.0;
        switch (operator) {
            case '-':
                if (!numbers.isEmpty()) {
                    result = numbers.get(0);
                    for (int i = 1; i < numbers.size(); i++) {
                        result -= numbers.get(i);
                    }
                }
                break;
            case '*':
                result = 1.0;
                for (double number : numbers) {
                    result *= number;
                }
                break;
            case '/':
                if (!numbers.isEmpty()) {
                    result = numbers.get(0);
                    for (int i = 1; i < numbers.size(); i++) {
                        if (numbers.get(i) == 0.0) {
                            throw new ArithmeticException("Division by zero is not allowed.");
                        }
                        result /= numbers.get(i);
                    }
                }
                break;
            default:
                for (double number : numbers) {
                    result += number;
                }
                break;
        }
        return result;
    }
}
