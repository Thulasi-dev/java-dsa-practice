// 1975. Maximum Matrix Sum (MEDIUM)

/* You are given an n x n integer matrix. You can do the following operation any number of times:

Choose any two adjacent elements of matrix and multiply each of them by -1.
Two elements are considered adjacent if and only if they share a border.

Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above. 

Input: matrix = [[1,-1],[-1,1]]
Output: 4
Explanation: We can follow the following steps to reach sum equals 4:
- Multiply the 2 elements in the first row by -1.
- Multiply the 2 elements in the first column by -1.


Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
Output: 16
Explanation: We can follow the following step to reach sum equals 16:
- Multiply the 2 last elements in the second row by -1.

Simple Logic (Think Like a Human)
What is our goal?

👉 Make the sum of all numbers as large as possible

🔄 What does the operation really do?

One operation flips two adjacent numbers

So:

	Two negatives → become positive

	Two positives → become negative

	One positive + one negative → signs swap

👉 Important observation:

The count of negative numbers can change,
but whether that count is odd or even never changes.

✅ Step-by-Step Friendly Logic
🔹 Step 1: Ignore signs temporarily

		Convert every number to its absolute value

		Add all of them

		This gives the maximum possible sum if everything were positive

🔹 Step 2: Count negative numbers

		Count how many elements were negative originally

		Also remember the smallest absolute value

🔹 Step 3: Decide the final answer
Case 1️: Negative count is even

		All negatives can be paired and flipped

		So everything can become positive

✅ Final answer = sum of absolute values

Case 2️: Negative count is odd

		One number must stay negative

		To lose minimum sum, choose the smallest number

	So:

		Make the smallest absolute value negative

		Subtract 2 × smallestValue from total
		
Plain English Summary (Perfect for Interview)

“I add all absolute values to get the maximum sum.
If the number of negative elements is even, I can make all values positive.
If it’s odd, one element must remain negative, so I keep the smallest one negative to minimize loss".

Complexity

Time: O(n²)
Space: O(1)


*/

public class MaximumMatrixSum {
    public static long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        int negativeCount = 0;
        int minAbs = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];

                if (val < 0) negativeCount++;

                int absVal = Math.abs(val);
                sum += absVal;

                minAbs = Math.min(minAbs, absVal);
            }
        }

        // If odd number of negatives, one value must stay negative
        if (negativeCount % 2 == 1) {
            sum -= 2L * minAbs;
        }

        return sum;
    }
}


