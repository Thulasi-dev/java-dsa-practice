// Given an array of strings arr[]. Return the longest common prefix among each and every strings present in the array. 
// If there's no prefix common in all the strings, return "".

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] arr) {
        if (arr == null || arr.length == 0) {
            return ""; // No strings in the array
        }

        // Start with the first string as the prefix
        String prefix = arr[0];

        // Compare the prefix with each string in the array
        for (int i = 1; i < arr.length; i++) {
            while (arr[i].indexOf(prefix) != 0) {
                // Reduce the prefix by removing the last character
                prefix = prefix.substring(0, prefix.length() - 1);

                // If the prefix becomes empty, return ""
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] arr1 = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(arr1)); // Output: "fl"

        String[] arr2 = {"dog", "racecar", "car"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(arr2)); // Output: ""

        String[] arr3 = {"interview", "internet", "internal", "interval"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(arr3)); // Output: "inte"
    }
}
