// 5. Longest Palindromic Substring (MEDIUM)

// Given a string s, return the longest palindromic substring in s.

public class LongestPalindromicSubstring {
    
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome
            int len1 = expandAroundCenter(s, i, i);
            // Even length palindrome
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;  // calculate new start
                end = i + len / 2;          // calculate new end
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() &&
               s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length of palindrome
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // "bab" or "aba"
        System.out.println(longestPalindrome("cbbd"));  // "bb"
    }
}

/*⏱️ Time & Space Complexity

Time Complexity: O(n^2)
Expanding around center for each character

Space Complexity: O(1)
Only variables, no extra data structures

🎯 How to Explain in Interview

“I iterate through each character, treating it as the center of a possible palindrome.
I expand left and right as long as characters match.
I check both odd and even length palindromes.
This approach is simple, efficient, and uses constant space.” */