// 73. Set Matrix Zeroes

/* Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]


✅ Optimal Approach (In-place, O(1) extra space)

Idea:
Use the first row and first column as markers instead of using extra arrays.

🔹 Steps (Interview-friendly logic)

	Check if first row has any 0 → store in row0
	Check if first column has any 0 → store in col0
	Traverse the matrix (excluding first row & column)
		If matrix[i][j] == 0
			mark row → matrix[i][0] = 0
			mark column → matrix[0][j] = 0

	Traverse again (excluding first row & column)
		If matrix[i][0] == 0 OR matrix[0][j] == 0
			→ set matrix[i][j] = 0
	If row0 == true → make first row zero
	If col0 == true → make first column zero
	
Complexity (Must Say in Interview)

Time Complexity: O(m × n)
Space Complexity: O(1) (in-place)

🧠 One-line Explanation for Interview

“I use the first row and first column as markers to track zero rows and columns, avoiding extra space.”

*/

public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean row0 = false;
        boolean col0 = false;

        // Check first row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                row0 = true;
                break;
            }
        }

        // Check first column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
                break;
            }
        }

        // Mark rows and columns
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set zeroes based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero first row
        if (row0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Zero first column
        if (col0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
