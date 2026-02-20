// Company Tags
// Flipkart        Directi        Adobe          Google         Nagarro        Media.net

import java.util.Arrays;

public class AnagramCheck {

    public static boolean isAnagram(String str1, String str2) {
        // Step 1: Check length
        if(str1.length() != str2.length()) {
            return false;
        }

        int[] count = new int[26]; // assuming lowercase letters only

        // Step 2: Count frequency of each char in str1
        for(int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'a']++;
        }

        // Step 3: Subtract frequency using str2
        for(int i = 0; i < str2.length(); i++) {
            count[str2.charAt(i) - 'a']--;
        }

        // Step 4: Check if all counts are 0
        for(int i = 0; i < 26; i++) {
            if(count[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        if(isAnagram(s1, s2)) {
            System.out.println(s1 + " and " + s2 + " are anagrams");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams");
        }
    }
}
