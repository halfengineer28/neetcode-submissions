class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] vis = new int [n][m];
        int maxarea = 0;


        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 1){
                    
                    int area = dfs(grid, vis, i, j);
                    maxarea = Math.max(maxarea, area);
                    
                }

            }
        }
        return maxarea;
        
    }
    public int  dfs(int [][] grid, int [][] vis, int i, int j){
        int n = grid.length;
        int m = grid[0].length;
        vis[i][j] = 1;
        int area = 1;

        int [] row = new int []{-1, 0, 1, 0};
        int [] col = new int [] {0, 1, 0, -1};

        for (int k = 0; k < 4; k++){
            int r = i + row[k];
            int c = j + col[k];
            if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1 && vis[r][c] != 1){
                area += dfs(grid, vis, r, c);
            }
        }
        return area;

    }
}
