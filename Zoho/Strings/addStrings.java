/*Sum of two large numbers
Given two strings denoting non-negative numbers s1 and s2. Calculate the sum of s1 and s2.
Input: s1 = "25", s2 = "23"
Output: "48"
Explanation: The sum of 25 and 23 is 48.*/

class Solution {
    public String addStrings(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();

        // Maximum possible length is max(n1, n2) + 1
        char[] result = new char[Math.max(n1, n2) + 1];

        int i = n1 - 1;
        int j = n2 - 1;
        int k = result.length - 1;
        int carry = 0;

        // Add digits from right to left
        while (i >= 0 || j >= 0) {

            int d1 = (i >= 0) ? s1.charAt(i) - '0' : 0;
            int d2 = (j >= 0) ? s2.charAt(j) - '0' : 0;

            int sum = d1 + d2 + carry;

            result[k] = (char) ((sum % 10) + '0');
            carry = sum / 10;

            i--;
            j--;
            k--;
        }

        // If carry exists
        if (carry == 1) {
            result[k] = '1';
            return new String(result);
        }

        // Otherwise skip leading empty index
        return new String(result, 1, result.length - 1);
    }
}

/*Time: O(max(n, m))
Space: O(max(n, m))*/