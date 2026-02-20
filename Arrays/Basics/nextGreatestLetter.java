/* 744. Find Smallest Letter Greater Than Target

You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.

Example 1:
Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.

Key Idea (One Line)

Because the array is sorted, use binary search to find the first character strictly greater than target.
If none exists, wrap around and return the first character.

Complexity

Time: O(log n)
Space: O(1) */

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        char result = letters[0]; // default wrap-around

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] > target) {
                result = letters[mid];
                high = mid - 1;   // try to find smaller valid char
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}

