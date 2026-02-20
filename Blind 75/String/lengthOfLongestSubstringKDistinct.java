/* Longest Substring with At Most K Distinct Characters

You are given a string 'str' and an integer ‘K’. Your task is to find the length of the largest substring with at most ‘K’ distinct characters.

What Does the Problem Mean?

“Longest substring with at most K distinct characters”

Break it:

Substring → continuous part of string
Distinct characters → unique letters
At most K → ≤ K (can be less, but not more)

Input:
s = "aaabbcc"
k = 2
Longest valid substring = "aaabb"
Length = 5

So output = 5

s = "abaccc"
k = 2
output = 4 [accc]

Very Important Understanding

We are NOT counting total characters.

We are checking:

👉 In the current window, how many different letters exist?

If more than k → shrink
If ≤ k → update max*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // If more than k distinct characters, shrink window
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}