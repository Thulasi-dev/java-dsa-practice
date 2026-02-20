/*Check if frequencies can be equal

Given a string s consisting only lowercase alphabetic characters, check whether it is possible to 
remove at most one character such that the  frequency of each distinct character in the string becomes same.
Return true if it is possible; otherwise, return false.

Input: s = "xyyz"
Output: true 
Explanation: Removing one 'y' will make frequency of each distinct character to be 1.

Time Complexity: O(n)
Space Complexity: O(1) (fixed array of size 26)*/

class Solution {
    public boolean sameFreq(String s) {

        int[] freq = new int[26];

        // Step 1: Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int minFreq = Integer.MAX_VALUE;
        int maxFreq = 0;

        // Step 2: Find min and max frequency
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                if (freq[i] < minFreq) {
                    minFreq = freq[i];
                }
                if (freq[i] > maxFreq) {
                    maxFreq = freq[i];
                }
            }
        }

        int minCount = 0;
        int maxCount = 0;
        int totalChars = 0;

        // Step 3: Count how many chars have min & max frequency
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                totalChars++;
                if (freq[i] == minFreq) {
                    minCount++;
                }
                if (freq[i] == maxFreq) {
                    maxCount++;
                }
            }
        }

        // Case 1: All frequencies same
        if (minFreq == maxFreq) {
            return true;
        }

        // Case 2: One character appears once
        if (minFreq == 1 && minCount == 1) {
            return true;
        }

        // Case 3: One character has frequency exactly 1 more
        if (maxFreq == minFreq + 1 && maxCount == 1) {
            return true;
        }

        return false;
    }
}
