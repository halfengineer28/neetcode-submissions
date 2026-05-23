class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int [][] dp = new int [n][m];
        for (int [] d : dp){
            Arrays.fill(d, -1);
        }
        return dfs(n-1, m-1, s, t, dp);

        
    }
    public int dfs(int i , int j, String s, String t, int [][] dp){
        if (j < 0 ){
            return 1;
        }
        if (i < 0){
            return 0;
        }
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        int left = 0;
        int right = 0;
        if (s.charAt(i) == t.charAt(j)){
             left = dfs(i-1, j-1, s, t, dp) + dfs(i-1, j, s, t, dp);
        }else{
             right = dfs(i-1, j, s, t, dp);
        }

        return dp[i][j] = left + right;

    }
}
