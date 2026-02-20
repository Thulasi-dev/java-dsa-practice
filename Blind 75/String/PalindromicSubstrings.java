// 647. Palindromic Substrings (MEDIUM)

/*Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.*/

public class PalindromicSubstrings {
    
    public static int countSubstrings(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Count odd length palindromes
            count += expandAroundCenter(s, i, i);
            // Count even length palindromes
            count += expandAroundCenter(s, i, i + 1);
        }
        
        return count;
    }
    
    private static int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;    // found a palindrome
            left--;
            right++;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));    // 3: "a","b","c"
        System.out.println(countSubstrings("aaa"));    // 6: "a","a","a","aa","aa","aaa"
    }
}


/* Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:
Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

⏱️ Time & Space Complexity

Time Complexity: O(n^2)
Expand around center for each character

Space Complexity: O(1)
Only variables, no extra data structures

🎯 How to Explain in Interview

“For each character, I expand around it to find all palindromes.
I check both odd and even length centers.
Every time I find matching characters, I increment the count.
This ensures all palindromic substrings are counted in O(n²) time.”*/