class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int [] dp = new int [n];
        Arrays.fill(dp, -1);
        return dfs(nums,n-1, dp);
        
    }
    public int dfs(int [] nums, int index, int [] dp){
        if(index == 0){
            return nums[0];
        }

        if (index < 0){
            return 0;
        }
        if (dp[index] != -1){
            return dp[index];
        }

        int pick = nums[index] + dfs(nums, index-2, dp);
        int notpick = 0 + dfs(nums, index-1, dp);
        return dp[index] = Math.max(pick, notpick);
    }
}
