// 76. Minimum Window Substring (HARD)

/*Given two strings s and t of lengths m and n respectively, return the minimum window substring
of s such that every character in t (including duplicates) is included in the window. If there is
no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.*/

// The best optimal solution uses Sliding Window + Frequency Count.

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] freq = new int[128]; // ASCII
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0, right = 0;
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char rChar = s.charAt(right);

            if (freq[rChar] > 0) {
                required--;
            }
            freq[rChar]--;
            right++;

            // When all characters matched
            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char lChar = s.charAt(left);
                freq[lChar]++;
                if (freq[lChar] > 0) {
                    required++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // "BANC"
        System.out.println(minWindow("a", "a"));               // "a"
        System.out.println(minWindow("a", "aa"));              // ""
    }
}


/* 
⏱️ Time & Space Complexity
Time Complexity: O(m + n)
    Each character in s processed at most twice

Space Complexity: O(1)
    Fixed-size array (ASCII characters)

Core Idea (Must Know)

Use two pointers to form a sliding window
Maintain frequency of characters from t
Expand window until all characters of t are covered
Shrink window to find minimum length 

How to Explain to the Interviewer (Perfect Answer)

“I use a sliding window with a frequency array to track required characters.
I expand the window until all characters of t are matched,
then shrink the window to find the minimum length.
This ensures linear time complexity.”
*/