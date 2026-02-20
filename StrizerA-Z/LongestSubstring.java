// Longest Substring with At least K Repeating Characters

// Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character
// in this substring is greater than or equal to k. If no such substring exists, return 0.

class LongestSubstring {
    public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }

    private int helper(String s, int start, int end, int k) {

        // If the substring length is smaller than k, it's impossible
        if (end - start < k) {
            return 0;
        }

        // Frequency array for lowercase letters
        int[] freq = new int[26];

        // Count character frequencies in the current range
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Check for any character with frequency < k
        for (int i = start; i < end; i++) {
            if (freq[s.charAt(i) - 'a'] < k) {

                int j = i + 1;
                // Skip all invalid characters
                while (j < end && freq[s.charAt(j) - 'a'] < k) {
                    j++;
                }

                // Divide into two parts and take max
                return Math.max(
                        helper(s, start, i, k),
                        helper(s, j, end, k)
                );
            }
        }

        // If all characters appear at least k times
        return end - start;
    }
}

// Input: s = "aaabb", k = 3
// Output: 3
// Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.

// Input: s = "ababbc", k = 2
// Output: 5
// Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

  
