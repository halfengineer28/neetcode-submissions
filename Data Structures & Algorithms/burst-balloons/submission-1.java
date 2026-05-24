class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int [] copy = new int [n+2];
        copy[0] = 1;
        copy[n+1] = 1;

        for (int i = 0; i < n; i++){
            copy[i+1] = nums[i];
        }

        int [][] dp = new int [n+2][n+2];

        for (int [] d : dp){
            Arrays.fill(d, -1);
        }
        return dfs(copy, 1, copy.length-2, dp);
        
        
        
    }
    public int dfs(int [] nums, int l, int r, int [][] dp){
        if (l > r){
            return 0;
        }
        if (dp[l][r] != -1){
            return dp[l][r];
        }
        dp[l][r] = 0;
        for (int i = l; i <= r; i++){
            int coins = nums[l-1] * nums[i] * nums[r+1];
            coins += dfs(nums, l, i-1, dp) + dfs(nums,i+1 , r, dp);
            dp[l][r] = Math.max(dp[l][r], coins);
        }
        return dp[l][r];
    }
}
