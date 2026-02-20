/*Integer to Words

Write a function to convert a given number n into words.

The idea is to break down the number into International Number System, i.e., smaller groups of three digits (hundreds, tens, and ones), and convert each group into words.
Company Tags
Zoho	Amazon	Microsoft	Oracle

*/

class NumberToWords {

    private static final String[] ones = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] thousands = {
        "", "Thousand", "Million", "Billion"
    };

    public static String numberToWords(int n) {
        if (n == 0) return "Zero";

        int index = 0;
        String result = "";

        while (n > 0) {
            if (n % 1000 != 0) {
                result = convertThreeDigits(n % 1000) + thousands[index] + " " + result;
            }
            n /= 1000;
            index++;
        }
        return result.trim();
    }

    private static String convertThreeDigits(int num) {
        String res = "";

        if (num >= 100) {
            res += ones[num / 100] + " Hundred ";
            num %= 100;
        }

        if (num >= 20) {
            res += tens[num / 10] + " ";
            num %= 10;
        }

        if (num > 0) {
            res += ones[num] + " ";
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(1234567));
        System.out.println(numberToWords(508));
        System.out.println(numberToWords(100001));
    }
}

/*Time Complexity: O(log n)
Space Complexity: O(1)*/