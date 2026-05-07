class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean [][] vis = new boolean [n][m];

        for (int i = 0; i < n; i++){
            if (board[i][0] == 'O'){
                dfs(board,i,  0,  vis);
            }
            if (board[i][m-1] == 'O'){
                dfs(board, i, m-1,  vis);
            }
            

        }
        
        for (int j = 0; j < m; j++){
            if(board[0][j] == 'O'){
                dfs(board, 0, j, vis);
            }
            if (board[n-1][j] == 'O'){
                dfs(board, n-1, j, vis);
            }
            

        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!vis[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';

                }

            }
        }
    }
    public void dfs(char [][] heights, int i, int j, boolean [][] vis){
        int n = heights.length;
        int m = heights[0].length;
        vis[i][j] = true;

        int [] rows = new int [] {-1, 0, 1, 0};
        int [] cols = new int [] {0, 1, 0, -1};

        for (int k = 0; k < 4; k++){
            int nrow = i + rows[k];
            int ncol = j + cols[k];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && heights[nrow][ncol] == 'O' ){
                dfs(heights, nrow, ncol, vis);
            }
        }
    }
}
