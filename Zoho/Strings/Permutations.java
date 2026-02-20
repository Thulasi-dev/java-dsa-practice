// Company Tags
// Zoho    Accolite    Amazon    Microsoft    OYO Rooms    Samsung    Snapdeal    Citrix    Walmart    MAQ Software    Cisco

// Permutations of a String
// Given a string s. The task is to return a vector of string of all unique permutations of the given string,
// s that may contain duplicates in lexicographically sorted order.

import java.util.*;

public class Permutations {
    public List<String> findPermutation(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // Sort to handle duplicates and generate lexicographical order
        boolean[] used = new boolean[chars.length];
        StringBuilder currentPermutation = new StringBuilder();

        backtrack(chars, used, currentPermutation, result);
        return result;
    }

    private void backtrack(char[] chars, boolean[] used, StringBuilder currentPermutation, List<String> result) {
        // Base case: if the current permutation is complete
        if (currentPermutation.length() == chars.length) {
            result.add(currentPermutation.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // Skip used characters
            if (used[i]) continue;

            // Skip duplicates: ensure that for a duplicate character, we only use the first unused occurrence
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            // Include the character in the current permutation
            currentPermutation.append(chars[i]);
            used[i] = true;

            // Recurse for the next character
            backtrack(chars, used, currentPermutation, result);

            // Backtrack: remove the last character and mark it as unused
            currentPermutation.deleteCharAt(currentPermutation.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        String s = "aabc";

        List<String> result = permutations.findPermutation(s);
        System.out.println("All unique permutations:");
        for (String perm : result) {
            System.out.println(perm);
        }
    }
}

// Input: "ABC"
// Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
// Explanation: Given string ABC has permutations in 6 forms as "ABC", "ACB", "BAC", "BCA", "CAB" and "CBA".
