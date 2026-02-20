/*Spirally traversing a matrix
You are given a rectangular matrix mat[][] of size n x m, and your task is to return an array while traversing the matrix in spiral form.
Input: mat[][] = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
Explanation: 
*/

class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        // code here
         ArrayList<Integer> result = new ArrayList<>();

        if (mat == null || mat.length == 0) {
            return result;
        }

        int top = 0;                // Top boundary
        int bottom = mat.length - 1; // Bottom boundary
        int left = 0;              // Left boundary
        int right = mat[0].length - 1; // Right boundary

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top boundary
            for (int i = left; i <= right; i++) {
                result.add(mat[top][i]);
            }
            top++; // Move top boundary downward

            // Traverse from top to bottom along the right boundary
            for (int i = top; i <= bottom; i++) {
                result.add(mat[i][right]);
            }
            right--; // Move right boundary to the left

            if (top <= bottom) {
                // Traverse from right to left along the bottom boundary
                for (int i = right; i >= left; i--) {
                    result.add(mat[bottom][i]);
                }
                bottom--; // Move bottom boundary upward
            }

            if (left <= right) {
                // Traverse from bottom to top along the left boundary
                for (int i = bottom; i >= top; i--) {
                    result.add(mat[i][left]);
                }
                left++; // Move left boundary to the right
            }
        }

        return result;
    
    }
}
