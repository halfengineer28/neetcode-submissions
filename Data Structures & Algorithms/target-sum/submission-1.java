class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       
        int total = Arrays.stream(nums).sum();
        int [][] dp = new int [nums.length][2 * total + 1];
        for (int [] d : dp){
            Arrays.fill(d, -1);
        }
        return dfs(0, nums, target, 0, dp, total);

        
    }
    public int dfs(int index, int [] nums, int target, int sum, int [][] dp, int total){
        if (index == nums.length){
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }
       if ( dp[index][sum+total] != -1){
        return dp[index][sum+total];
       }
        int plus = dfs(index+1, nums, target, sum+nums[index], dp, total);
        int minus = dfs(index+1, nums, target, sum-nums[index], dp, total);
        dp[index][sum+total] = plus + minus;
        return dp[index][sum+total];
    }
}
