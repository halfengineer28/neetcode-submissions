class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean [][] pacific = new boolean[n][m];
        boolean [][] atlantic = new boolean[n][m];


        for (int i = 0; i < m; i++){
            dfs(heights, 0, i, pacific);
            dfs(heights, n-1, i, atlantic);
        }

        for (int i = 0; i < n; i++){
            dfs(heights,  i, 0, pacific);
            dfs(heights,  i, m-1, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i ++){
            for (int j = 0; j < m; j++)
            if (pacific[i][j] && atlantic[i][j]){
                ans.add(Arrays.asList(i, j));
            }
        }
        return ans;



        
    }
    public void dfs(int [][] heights, int i, int j, boolean [][] vis){
        int n = heights.length;
        int m = heights[0].length;

        vis[i][j] = true;

        int [] rows = new int [] {-1, 0, 1, 0};
        int [] cols = new int [] {0, 1, 0, -1};

        for (int k = 0; k < 4; k++){

            int nrow = i + rows[k];
            int ncol = j + cols[k];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol]  && heights[nrow][ncol] >= heights[i][j]){
                dfs(heights, nrow, ncol, vis);
            }


        }

    }
}
