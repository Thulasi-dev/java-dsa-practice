class IsPalindrome {
    public boolean isPalindrome(int x) {

        // Negative numbers cannot be palindrome
        if (x < 0) {
            return false;
        }

        int original = x;
        int reversed = 0;

        while (x > 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x = x / 10;
        }

        return original == reversed;
    }
}

/*I reverse the integer using modulo and division, then compare it with the original number.

⏱️ Time & Space Complexity 

Time: O(n) → number of digits
Space: O(1) → no extra space*/
