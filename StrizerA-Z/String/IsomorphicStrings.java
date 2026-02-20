/*Isomorphic String

 Given two strings s and t, determine if they are isomorphic. Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
Input: s = "egg", t = "add"
Output: true
Explanation: e → a, g → d
Input: s = "foo", t = "bar"
Output: false
Explanation: f → b, o → a, but second o cannot map to r
*/

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Check mapping from s -> t
            if (mapST.containsKey(c1)) {
                if (mapST.get(c1) != c2) return false;
            } else {
                mapST.put(c1, c2);
            }

            // Check mapping from t -> s
            if (mapTS.containsKey(c2)) {
                if (mapTS.get(c2) != c1) return false;
            } else {
                mapTS.put(c2, c1);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "egg", t1 = "add";
        System.out.println(isIsomorphic(s1, t1)); // true

        String s2 = "foo", t2 = "bar";
        System.out.println(isIsomorphic(s2, t2)); // false
    }
}

// Time Complexity: O(n) — traverse strings once
// Space Complexity: O(n) — for two hash maps
