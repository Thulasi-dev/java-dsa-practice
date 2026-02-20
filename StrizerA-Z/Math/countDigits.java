/*Count digits in a number

Problem Statement: Given an integer N, return the number of digits in N. 
Example 1:
Input:N = 12345
Output:5
Explanation:  The number 12345 has 5 digits.
                        
Example 2:
Input:N = 7789              
Output: 4
Explanation: The number 7789 has 4 digits.

Brute Force Approach*/

import java.util.Scanner;

public class Main {
    // Function to count the number of digits in an integer 'n'.
    public static int countDigits(int n) {
        // Initialize a counter variable 'cnt' to store the count of digits.
        int cnt = 0;
        // While loop iterates until 'n' becomes 0 (no more digits left).
        while (n > 0) {
            // Increment the counter for each digit encountered.
            cnt = cnt + 1;
            // Divide 'n' by 10 to remove the last digit.
            n = n / 10;
        }
        // Return the count of digits.
        return cnt;
    }

    public static void main(String[] args) {
        int N = 329823;
        System.out.println("N: " + N);
        int digits = countDigits(N);
        System.out.println("Number of Digits in N: " + digits);
    }
}

// Time Complexity: O(log10N + 1)
// Space Complexity : O(1)                              

//Optimal Approach
import java.util.*;

public class Main {
    // Calculate the count of digits in 'n'
    // using logarithmic operation log10(n) + 1.
    static int countDigits(int n) {
        // Initialize a variable 'cnt' to
        // store the count of digits.
        int cnt = (int) (Math.log10(n) + 1);

        // The expression (int)(Math.log10(n) + 1)
        // calculates the number of digits in 'n'
        // and casts it to an integer.

        // Adding 1 to the result accounts
        // for the case when 'n' is a power of 10,
        // ensuring that the count is correct.

        // Finally, the result is cast
        // to an integer to ensure it is rounded
        // down to the nearest whole number.

        // Return the count of digits in 'n'.
        return cnt;
    }

    public static void main(String[] args) {
        int N = 329823;
        System.out.println("N: " + N);
        int digits = countDigits(N);
        System.out.println("Number of Digits in N: " + digits);
    }
}

// Time: O(1)
// Space: O(1)                                

