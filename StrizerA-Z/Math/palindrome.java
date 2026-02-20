/*Check if a number is Palindrome or Not

Problem Statement: Given an integer N, return true if it is a palindrome else return false.

A palindrome is a number that reads the same backward as forward. For example, 
121, 1331, and 4554 are palindromes because they remain the same when their digits are reversed.*/

class Solution {
    // Function to check if a given integer is a palindrome
    public boolean palindrome(int n) {
        int revNum = 0; // Initialize a variable to store the reverse of the number
        int dup = n; // Create a duplicate variable to store the original number

        // Iterate through each digit of the number until it becomes 0
        while (n > 0) {
            int ld = n % 10; // Extract the last digit of the number
            revNum = (revNum * 10) + ld; // Build the reverse number by appending the last digit
            n = n / 10; 
            // Remove the last digit from the original number
        }

        // Check if the original number is equal to its reverse
        return dup == revNum; // Return true if they are equal, otherwise false
    }
}

public class Main {
    public static void main(String[] args) {
        int number = 4554; // Example number
        Solution obj = new Solution();
        if (obj.palindrome(number)) { // Check if the number is a palindrome
            System.out.println(number + " is a palindrome.");
        } else {
            System.out.println(number + " is not a palindrome.");
        }
    }
}

// Time Complexity: O(log₁₀N+1)
// Space Complexity: O(1)

