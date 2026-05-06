class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        int i = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (dfs(board, word, r, c, n, m, vis, i)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(
        char[][] board, String word, int r, int c, int n, int m, int[][] vis, int i) {
        if (i == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= n || c >= m || board[r][c] != word.charAt(i) || vis[r][c] == 1) {
            return false;
        }

        vis[r][c] = 1;
        boolean res = dfs(board, word, r + 1, c, n, m, vis, i + 1) || 
                        dfs(board, word, r - 1, c, n,m, vis, i + 1) || 
                        dfs(board, word, r, c + 1, n,m, vis, i + 1) || 
                        dfs(board, word, r, c - 1, n, m, vis, i + 1);
        vis[r][c] = 0;

        return res;
    }
}
