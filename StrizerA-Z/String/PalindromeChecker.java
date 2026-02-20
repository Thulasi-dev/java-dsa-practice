// You are given a string s. Your task is to determine if the string is a palindrome. A string is considered a palindrome if it reads the same forwards and backwards.
// Company Tags         Paytm  Zoho  Morgan Stanley  Amazon  D-E-Shaw  FactSet  Cisco  Facebook

import java.util.Scanner;

public class PalindromeChecker {
    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method to check palindrome ignoring case and non-alphanumeric characters
    public static boolean isPalindromeIgnoreCase(String s) {
        StringBuilder cleaned = new StringBuilder();
        
        // Convert to lowercase and remove non-alphanumeric characters
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        
        return isPalindrome(cleaned.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        if (isPalindrome(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }
        
        // Checking by ignoring case and special characters
        if (isPalindromeIgnoreCase(input)) {
            System.out.println("Ignoring case and spaces, the string is a palindrome.");
        } else {
            System.out.println("Ignoring case and spaces, the string is NOT a palindrome.");
        }

        scanner.close();
    }
}
