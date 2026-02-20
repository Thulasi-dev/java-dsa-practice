/*Reverse Digits of A Number

Problem Statement: Given an integer N return the reverse of the given number.

Note: If a number has trailing zeros, then its reverse will not include them.
 For e.g , reverse of 10400 will be 401 instead of 00401.*/

 import.java.util.*;
public class Solution {
    // Function to reverse digits of a number
    public int reverseNumber(int n) {
        // Variable to store reversed number
        int revNum = 0;

        // Loop until all digits are processed
        while (n > 0) {
            // Get the last digit
            int lastDigit = n % 10;

            // Append it to the reversed number
            revNum = revNum * 10 + lastDigit;

            // Remove the last digit from n
            n = n / 10;
        }

        // Return the reversed number
        return revNum;
    }
}

// Driver code
class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int num = 12345;
        System.out.println(obj.reverseNumber(num));  // Output: 54321
    }
}

// Time Complexity: O(log₁₀N)
// Space Complexity: O(1)
