public class StringRotation {
    public static boolean isRotation(String s1, String s2) {
        // Check length first
        if (s1.length() != s2.length()) return false;

        // Concatenate s1 with itself
        String temp = s1 + s1;

        // Check if s2 is a substring
        return temp.contains(s2);
    }

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "CDAB";
        System.out.println(isRotation(s1, s2)); // Output: true

        String s3 = "ACBD";
        System.out.println(isRotation(s1, s3)); // Output: false
    }
}

// Time Complexity: O(n) — substring check
// Space Complexity: O(n) — for concatenated string