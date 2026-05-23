class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int longestPath = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int longest = dfs(matrix, dp, i, j, n, m);
                longestPath = Math.max(longestPath, longest);
            }
        }
        return longestPath;
    }
    public int dfs(int[][] matrix, int[][] dp, int i, int j, int n, int m) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int max = 0;

        int[] row = new int[] {-1, 0, 1, 0};
        int[] col = new int[] {0, 1, 0, -1};

        for (int k = 0; k < 4; k++){
            int nrow = i + row[k];
            int ncol = j + col[k];
            if (nrow  >= 0 && nrow < n && ncol >= 0 && ncol < m && matrix[i][j] < matrix[nrow][ncol]){
                int longest  = dfs(matrix, dp, nrow, ncol, n, m);
                max = Math.max(max, longest);
            }
        }
        dp[i][j] = max + 1;
        return dp[i][j];
    }
}
