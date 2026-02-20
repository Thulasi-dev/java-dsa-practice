// 79. Word Search

/*Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are 
horizontally or vertically neighboring. The same letter cell may not be used more than once.

Input: board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, word = "ABCCED"
Output: true

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false


🔍 Key Idea (Interview Explanation)

	We try to match the word character by character
	From each cell, we explore 4 directions:
		up, down, left, right
	Use DFS + Backtracking
	Mark a cell as visited temporarily so it’s not reused
	Restore the cell after the DFS call (backtracking)

✅ Approach (Step-by-step)

	Loop through every cell in the board
	If the first character matches, start DFS
	In DFS:
		If all characters are matched → return true
		If out of bounds or mismatch → return false
		Mark cell as visited
		Explore 4 directions
		Unmark cell (backtrack)
		
Complexity (Must Say in Interview)

Time Complexity:
O(m × n × 4^L)
where L = length of word

Space Complexity:
O(L) (recursion stack)

🧠 One-line Interview Explanation

“I use DFS with backtracking, exploring 4 directions from each cell and marking visited cells temporarily to avoid reuse.”
*/

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, int index) {

        // All characters matched
        if (index == word.length()) {
            return true;
        }

        // Boundary & mismatch checks
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore all 4 directions
        boolean found = dfs(board, word, i + 1, j, index + 1)
                     || dfs(board, word, i - 1, j, index + 1)
                     || dfs(board, word, i, j + 1, index + 1)
                     || dfs(board, word, i, j - 1, index + 1);

        // Backtrack (restore)
        board[i][j] = temp;

        return found;
    }
}
