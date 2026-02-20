/* Min Add to Make Parentheses Valid

You are given a string s consisting only of the characters '(' and ')'. Your task is to determine the minimum number of parentheses (either '(' or ')') that must be inserted at any positions to make the string s a valid parentheses string.

A parentheses string is considered valid if:

Every opening parenthesis '(' has a corresponding closing parenthesis ')'.
Every closing parenthesis ')' has a corresponding opening parenthesis '('.
Parentheses are properly nested.
Input: s = "(()("
Output: 2
Input: s = ")))"
Output: 3

Time: O(n)
Space: O(1) */

public int minAddToMakeValid(String s) {
    int open = 0;        // unmatched '('
    int insertions = 0; // required insertions

    for (char ch : s.toCharArray()) {
        if (ch == '(') {
            open++;
        } else { // ')'
            if (open > 0) {
                open--;
            } else {
                // need to insert '('
                insertions++;
            }
        }
    }

    // remaining '(' need ')'
    insertions += open;

    return insertions;
}
