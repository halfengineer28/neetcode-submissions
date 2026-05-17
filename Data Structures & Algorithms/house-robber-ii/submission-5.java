class Solution {
    public int rob(int[] nums) {
       if (nums.length == 1){
        return nums[0];
       }
        int [] rob1 = Arrays.copyOfRange(nums, 0, nums.length-1);
        int [] rob2 = Arrays.copyOfRange(nums, 1, nums.length);
        int [] dp1 = new int[rob1.length];
        Arrays.fill(dp1, -1);
        int max1 = dfs(rob1, rob1.length-1, dp1);
        int [] dp2 = new int[rob2.length];
        Arrays.fill(dp2, -1);
        int max2 = dfs(rob2, rob2.length-1, dp2);
        return Math.max(max1,max2);
       
        
    }
    public int dfs(int [] nums, int index, int [] dp){
        if (index == 0){
            return nums[0];
        }

        if (index < 0){
            return 0;
        }
        if (dp[index] != -1){
            return dp[index];
        }

        int take = nums[index] + dfs(nums, index-2, dp);
        int nottake = 0 + dfs(nums, index-1,dp);
        
        return dp[index] = Math.max(take, nottake);
    }
}

