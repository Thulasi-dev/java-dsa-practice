// 128. Valid Palindrome (EASY)

/*A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 and removing all non-alphanumeric characters, it reads the same forward and backward. 
 Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise. */

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

    ---------------------------------------------------------------------------
    
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != 
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    -------------------------------------------------
    public boolean isPalindrome(String s) {
        s=s.toLowerCase().replaceAll("[^a-z0-9]","");
        int left=0, right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car"));                     // false
    }
}


/*⏱️ Time & Space Complexity

Time Complexity: O(n)
Space Complexity: O(1)

🎯 How to Explain to the Interviewer (Perfect Answer)

“I use two pointers from both ends of the string.
I skip non-alphanumeric characters and compare characters in lowercase.
If any mismatch occurs, I return false.
This approach runs in linear time and constant space.” */