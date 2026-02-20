/* Word Break

You are given a string s and a list dictionary[] of words. Your task is to determine whether the string s can be formed by concatenating one or more words from the dictionary[].

Note: From dictionary[], any word can be taken any number of times and in any order.

Input: s = "ilike", dictionary[] = ["i", "like", "gfg"]
Output: true

Complexity

Time: O(n² * m)
(n = length of string, m = dictionary size)
Space: O(n) */

public boolean wordBreak(String s, String[] dictionary) {
    int n = s.length();
    
    // dp[i] = true if s[0..i-1] can be segmented
    boolean[] dp = new boolean[n + 1];
    dp[0] = true; // empty string

    for (int i = 1; i <= n; i++) {
        for (int j = 0; j < i; j++) {
            if (dp[j] && contains(dictionary, s.substring(j, i))) {
                dp[i] = true;
                break;
            }
        }
    }

    return dp[n];
}

// helper method to check dictionary
private boolean contains(String[] dictionary, String word) {
    for (String d : dictionary) {
        if (d.equals(word)) {
            return true;
        }
    }
    return false;
}
