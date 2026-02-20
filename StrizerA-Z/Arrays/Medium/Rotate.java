// 48. Rotate Image

/*You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Sol:-

🧠 Key Idea (Must Remember)

To rotate a matrix 90° clockwise in-place, do:

✅ Step 1: Transpose the matrix
		   Convert rows → columns

✅ Step 2: Reverse each row
		   Mirror horizontally

This achieves a 90° clockwise rotation

Input:
1 2 3
4 5 6
7 8 9

Step 1: Transpose
1 4 7
2 5 8
3 6 9

Step 2: Reverse each row
7 4 1
8 5 2
9 6 3

Complexity

Time: O(n²)
Space: O(1) (in-place)

Interview Explanation (One-Liner)

“I rotated the matrix in-place by first transposing it and then reversing each row, 
which results in a 90-degree clockwise rotation.”

*/

class Rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
