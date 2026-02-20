// 242. Valid Anagram (EASY)

// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car"));         // false
    }
}

/*🧠 Why This Works

Anagrams have same characters with same frequencies
Increase count for s
Decrease count for t
At the end, all counts must be 0

⏱️ Time & Space Complexity

Time Complexity: O(n)
Space Complexity: O(1) (fixed array of size 26)

🎯 How to Explain to the Interviewer

“I compare the frequency of characters in both strings using a fixed-size array.
For every character in s, I increment the count, and for t, I decrement it.
If both strings are anagrams, all frequencies will be zero at the end.” */