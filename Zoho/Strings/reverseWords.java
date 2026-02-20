/* Reverse each word in a given string

You are given a string s. You need to reverse each word in it where the words are separated by spaces and return the modified string.

Note: The string may contain leading or trailing spaces, or multiple spaces between two words. The returned string should only have a single space separating the words, and no extra spaces should be included.

Approach (Step-by-Step)

1. Use two pointers (i and j) to extract words manually (avoid inbuilt split if required)
2. Skip leading spaces
3. For each word:
	Reverse the characters
	Append to result
	Add single space between words
4. Trim trailing space at the end*/

class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < n) {

            // Skip spaces
            while (i < n && s.charAt(i) == ' ') i++;

            if (i >= n) break;

            // Find end of the word
            int j = i;
            while (j < n && s.charAt(j) != ' ') j++;

            // Reverse the word manually
            for (int k = j - 1; k >= i; k--) {
                result.append(s.charAt(k));
            }

            // Add a space after the word
            result.append(' ');

            i = j;
        }

        // Remove trailing space if any
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }
}

/*Time Complexity: O(n) → traverse each character once
Auxiliary Space: O(1) (only variables + output counted separately)

I traverse the string manually, skip extra spaces, reverse each word individually, and append it to a result with a single space.
Finally, I remove any trailing space. This ensures O(n) time and constant extra space.*/