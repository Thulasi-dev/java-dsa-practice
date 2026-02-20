// 424. Longest Repeating Character Replacement

/*You are given a string s and an integer k. You can choose any character of the string and change
 it to any other uppercase English character. You can perform this operation at most k times. 
 Return the length of the longest substring containing the same letter you can get after performing the above operations.*/

// The best optimal solution uses Sliding Window + Frequency Count.

public class CharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'A';
            freq[index]++;
            
            // track the most frequent character in current window
            maxFreq = Math.max(maxFreq, freq[index]);


            /*“The while loop runs whenever the current window needs more than k character replacements,
             so we move the left pointer to reduce the window size until it becomes valid again.” */
            // window size - maxFreq = characters to replace
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));   // 4
        System.out.println(characterReplacement("AABABBA", 1)); // 4
    }
}


/*Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.

🪟 Sliding Window Explanation

    1. Use two pointers: left, right
    2. Maintain:
          freq[26] → frequency of characters
          maxFreq → highest frequency in the current window
    3. Expand right
    4. If window becomes invalid → shrink from left
    5. Track maximum window length

⏱️ Time & Space Complexity
Time Complexity: O(n)
Each character processed once

Space Complexity: O(1)
Fixed size array of 26 characters

🎯 How to Explain to the Interviewer (Perfect Answer)

“I use a sliding window with a frequency array.
For every window, I track the most frequent character.
The number of replacements needed is window size minus max frequency.
If it exceeds k, I shrink the window.
This ensures O(n) time complexity and constant space.”

🚨 Important Interview Notes

We do not decrease maxFreq when shrinking window
✔ still works because window size adjusts correctly

This optimization avoids recalculating max frequency every time */