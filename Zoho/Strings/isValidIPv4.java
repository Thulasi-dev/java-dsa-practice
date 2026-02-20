/*Validate an IP Address

You are given a string s in the form of an IPv4 Address. Your task is to validate an IPv4 Address, if it is valid return true otherwise return false.

Approach (interview-friendly)

1. Split the string by .
2. If parts count ≠ 4 → return false
3. For each part:
	Check empty string
	Check leading zero
	Check only digits
	Convert to number
	Check range (0–255)
4. If all pass → return true */

class Solution {
    public boolean isValidIPv4(String s) {

        // Step 1: Split by dot
        String[] parts = s.split("\\.");

        // Step 2: Must contain exactly 4 parts
        if (parts.length != 4) {
            return false;
        }

        // Step 3: Validate each part
        for (String part : parts) {

            // Empty part check
            if (part.length() == 0) {
                return false;
            }

            // Leading zero check
            if (part.length() > 1 && part.charAt(0) == '0') {
                return false;
            }

            // Digit-only check
            for (int i = 0; i < part.length(); i++) {
                if (!Character.isDigit(part.charAt(i))) {
                    return false;
                }
            }

            // Convert to number
            int num = Integer.parseInt(part);

            // Range check
            if (num < 0 || num > 255) {
                return false;
            }
        }

        return true;
    }
}

/* Valid 
"172.16.254.1"
"0.0.0.0"
"255.255.255.255"
 */


/*How to explain this in an interview (short & clear)

“I split the string using dots and check if there are exactly four parts.
For each part, I ensure it is non-empty, contains only digits, has no leading zeros, and its integer value lies between 0 and 255.
If all parts satisfy these conditions, the IPv4 address is valid.”

The time complexity is O(n) because we scan the string once.
The space complexity is O(1) since IPv4 has a fixed number of parts.*/