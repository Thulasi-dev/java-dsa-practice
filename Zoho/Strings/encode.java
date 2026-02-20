/*Run Length Encoding
Given a string s, Your task is to complete the function encode that returns the run length encoded string for the given string.
eg if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6″.
You are required to complete the function encode that takes only one argument the string which is to be encoded and returns the encoded string.
Input:
s = aaaabbbccc
Output: a4b3c3

s = abbbcdddd
Output: a1b3c1d4

Approach (Simple Loop)

Start from index 0
Count how many times current character repeats consecutively
Append character and count
Move to the next new character*/

class Solution {
    public String encode(String s) {

        StringBuilder result = new StringBuilder();

        int count = 1;

        for (int i = 1; i <= s.length(); i++) {

            // If next char is same, increase count
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            }
            // Else, append current char and its count
            else {
                result.append(s.charAt(i - 1));
                result.append(count);
                count = 1; // reset for next character
            }
        }

        return result.toString();
    }
}

/*Time Complexity: O(n)
Space Complexity: O(n) (output string)*/