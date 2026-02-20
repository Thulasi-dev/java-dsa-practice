// Decode ways
/*You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:

"1" -> 'A'

"2" -> 'B'

...

"25" -> 'Y'

"26" -> 'Z'

However, while decoding the message, you realize that there are many different ways
you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").

For example, "11106" can be decoded into:

"AAJF" with the grouping (1, 1, 10, 6)
"KJF" with the grouping (11, 10, 6)
The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
Note: there may be strings that are impossible to decode.

Given a string s containing only digits, return the number of ways to decode it. 
If the entire string cannot be decoded in any valid way, return 0.

The test cases are generated so that the answer fits in a 32-bit integer.*/

public int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.charAt(0) == '0')
        return 0;

    int prev2 = 1; // dp[i-2]
    int prev1 = 1; // dp[i-1]

    for (int i = 1; i < s.length(); i++) {
        int curr = 0;

        // Single digit decoding
        if (s.charAt(i) != '0') {
            curr += prev1;
        }

        // Two digit decoding
        int twoDigit = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
        if (twoDigit >= 10 && twoDigit <= 26) {
            curr += prev2;
        }

        prev2 = prev1;
        prev1 = curr;
    }

    return prev1;
}


// Time Complexity: O(n)
// Space Complexity: O(1)

/* Input: s = "12"
Output: 2
Explanation:
"12" could be decoded as "AB" (1 2) or "L" (12).*/