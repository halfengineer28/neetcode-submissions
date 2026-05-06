class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(0, n, nums, target, res, 0, ans);
        return ans;
        
    }
    public void dfs(int i, int n, int [] nums, int target, List<Integer> res, int sum, List<List<Integer>> ans ){

        if (sum == target){
            ans.add(new ArrayList<>(res));
            return;
        }
        if (sum > target || i >= n){
            return;
        }

    
        res.add(nums[i]);
        dfs(i, n, nums, target, res, sum + nums[i], ans);
        res.remove(res.size()-1);
        dfs(i+1, n, nums, target, res, sum, ans);

    }
}
