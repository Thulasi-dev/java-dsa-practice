public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        // Convert the string to lowercase and remove non-alphanumeric characters
        StringBuilder filteredString = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filteredString.append(Character.toLowerCase(c));
            }
        }

        // Check if the filtered string is a palindrome
        int left = 0, right = filteredString.length() - 1;
        while (left < right) {
            if (filteredString.charAt(left) != filteredString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        // Example input
        String s = "A man, a plan, a canal: Panama";

        // Check if it's a palindrome
        boolean result = isPalindrome(s);
        System.out.println("Is the string a palindrome? " + result);
    }
}
