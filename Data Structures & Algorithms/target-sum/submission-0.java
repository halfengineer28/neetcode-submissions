class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> dp = new HashMap<>();
        return dfs(0, nums, target, 0, dp);

        
    }
    public int dfs(int index, int [] nums, int target, int sum, HashMap<String, Integer> dp){
        if (index == nums.length){
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }
        String key = index + "_" + sum;
        if (dp.containsKey(key)){
            return dp.get(key);
        }
        int plus = dfs(index+1, nums, target, sum+nums[index], dp);
        int minus = dfs(index+1, nums, target, sum-nums[index], dp);
        dp.put(key, plus + minus);
        return plus + minus;
    }
}
