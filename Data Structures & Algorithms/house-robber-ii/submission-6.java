class Solution {
    public int rob(int[] nums) {
       if (nums.length == 1){
        return nums[0];
       }
        int [] rob1 = Arrays.copyOfRange(nums, 0, nums.length-1);
        int [] rob2 = Arrays.copyOfRange(nums, 1, nums.length);
      
      
        int max1 = dfs(rob1);
        int max2 = dfs(rob2);
        return Math.max(max1,max2);
       
        
    }
    public int dfs(int [] nums){
        int [] dp = new int [nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++){
            int take = nums[i];
            if (i > 1){
                take += dp[i-2];
            }
            int nottake = 0 + dp[i-1];
            dp[i] = Math.max(take, nottake);
        }
        return dp[nums.length-1];
      
    }
}

