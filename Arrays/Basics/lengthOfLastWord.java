// Length Of Last Word

/*You are given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

Note: A substring is a contiguous non-empty sequence of characters within a string.

Input: s = "Hello World"
Output: 5

Time: O(n)
Space: O(1)
*/

class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int length = 0;

        // skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // count last word characters
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
