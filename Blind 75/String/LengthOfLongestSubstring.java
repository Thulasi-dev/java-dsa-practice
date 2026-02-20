// Given a string s, find the length of the longest substring without duplicate characters.

// The best optimal approach is the Sliding Window + HashSet / HashMap technique.

import java.util.HashSet;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // If duplicate found, remove from left until unique
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3
    }
}

/* How It Works (Simple Explanation)

Use two pointers (left and right) to maintain a window
Use a HashSet to track characters inside the window
Expand right pointer:
    If character is not present, add it
    If duplicate appears, move left pointer and remove characters until duplicate is gone
Update maximum length after every valid window

 Notes:
I use a sliding window technique with two pointers and a HashSet.
The right pointer expands the window, and if a duplicate character is found,
I shrink the window from the left until all characters are unique again.
This ensures each character is processed at most twice, resulting in O(n) time complexity */
