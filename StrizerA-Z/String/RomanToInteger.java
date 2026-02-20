// Given a string in Roman number format (s), your task is to convert it to an integer. Various symbols and their values are given below.
// Note: I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000

// Company Tags        Zoho        Amazon    Microsoft        Facebook        Twitter        Uber

import java.util.HashMap;

public class RomanToInteger {
    public static int romanToInt(String s) {
        // Define a map to store Roman numeral values
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int previousValue = 0;

        // Iterate through the string in reverse order
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = romanMap.get(currentChar);

            // If the current value is less than the previous value, subtract it
            if (currentValue < previousValue) {
                result -= currentValue;
            } else {
                // Otherwise, add it
                result += currentValue;
            }

            // Update the previous value for the next iteration
            previousValue = currentValue;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test the function with some examples
        String roman = "MCMXCIV";
        int integer = romanToInt(roman);
        System.out.println("The integer value of " + roman + " is: " + integer);
    }
}
