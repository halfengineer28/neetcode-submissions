class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        // fill with '.' full board;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board, 0, ans);
        return ans;
    }
    public void backtrack(char[][] board, int r, List<List<String>> ans) {
        // reaching at the last point and adding ArrayList  to List<List<T>>
        if (r == board.length) {
            List<String> res = new ArrayList<>();
            for (char[] row : board) {
                res.add(new String(row));
            }
            ans.add(res);
            return;
        }
        // if safe put the queen and backtrack once backtrack completed put '.'

        for (int c = 0; c < board.length; c++) {
            if (isSafe(board, r, c)) {
                board[r][c] = 'Q';
                backtrack(board, r + 1, ans);
                board[r][c] = '.';
            }
        }
    }
    public boolean isSafe(char[][] board, int r, int c) {
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'Q') {
                return false;
            }
        }
        int row = r - 1;
        int col = c - 1;

        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

         row = r - 1;
         col = c + 1;
        while (row >= 0 && col < board.length) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col++;
        }
        return true;
    }
}
