// Count Odd Numbers in an Interval Range

// Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).

class CountOdds {
    public int countOdds(int low, int high) {
        int count = (high - low) / 2;

        if (low % 2 == 1 || high % 2 == 1) {
            count++;
        }

        return count;
    }
}

// Input: low = 3, high = 7
// Output: 3
// Explanation: The odd numbers between 3 and 7 are [3,5,7].
