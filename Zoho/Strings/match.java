/* Wildcard Pattern Matching

Given two strings pat and txt which may be of different sizes, You have to return true if the wildcard pattern i.e. pat, matches with txt else return false.

The wildcard pattern pat can include the characters '?' and '*'.

'?' – matches any single character.
'*' – matches any sequence of characters (including the empty sequence).
Note: The matching should cover the entire txt (not partial txt).*/

class Solution {
    public boolean match(String pat, String txt) {

        int m = pat.length();
        int n = txt.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty pattern matches empty text
        dp[0][0] = true;

        // Pattern like *, **, *** can match empty text
        for (int i = 1; i <= m; i++) {
            if (pat.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                char p = pat.charAt(i - 1);
                char t = txt.charAt(j - 1);

                if (p == t || p == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (p == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }
}

/*Time Complexity: O(m × n)
Space Complexity: O(m × n)
(where m = pat.length, n = txt.length)

I use dynamic programming where dp[i][j] represents whether the first i characters of the pattern match the first j characters of the text.
I handle ? as a single-character match and * as either empty or multiple-character match.*/