/* You are given a square matrix of size n x n. Your task is to find the transpose of the given matrix.
The transpose of a matrix is obtained by converting all the rows to columns and all the columns to rows. */

class Transpose{
  public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
    int n = mat.length; // since it's a square matrix
    
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    
    // Create the structure for result matrix
    for (int i = 0; i < n; i++) {
        result.add(new ArrayList<>());
    }
    
    // Fill the transpose
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            result.get(j).add(mat[i][j]); 
            // row becomes column, column becomes row
        }
    }
    
    return result;
  }
}

/* Input: mat[][] = [[1, 1, 1, 1],
                [2, 2, 2, 2],
                [3, 3, 3, 3],
                [4, 4, 4, 4]]
Output: [[1, 2, 3, 4],
       [1, 2, 3, 4],
       [1, 2, 3, 4],
       [1, 2, 3, 4]]
Explanation: Converting rows into columns and columns into rows.*/
