// 49. Group Anagrams (MEDIUM)

// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            int[] freq = new int[26];

            // count characters
            for (int i = 0; i < s.length(); i++) {
                // ASCII values for a-z = 97-122
                freq[s.charAt(i) - 'a']++;
            }

            // build key from frequency array
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                key.append('#');
                key.append(freq[i]);
            }

            String k = key.toString();

            // group strings
            if (!map.containsKey(k)) {
                map.put(k, new ArrayList<>());
            }
            map.get(k).add(s);
        }

        return new ArrayList<>(map.values());
    }
}

/* Input: strs = ["eat","tea","tan","ate","nat","bat"]

   Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

⏱️ Time & Space Complexity

Time Complexity: O(n * k)
n = number of strings
k = max length of a string

Space Complexity: O(n * k)

🎯 How to Explain This in Interview (Say This)

“I use a HashMap where the key represents the frequency of characters in a string.
Anagrams have the same frequency, so they generate the same key and get grouped together.
This avoids sorting and works efficiently.”*/