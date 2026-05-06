class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        dfs(0, n, nums, ans, sub);
        return ans;
        
    }
    public void dfs(int i, int n, int [] nums, List<List<Integer>> ans, List<Integer> sub){
        if (i >= n){
            ans.add(new ArrayList<>(sub));
            return;
        }

        sub.add(nums[i]);
        dfs(i + 1, n, nums, ans, sub);
        sub.remove(sub.size()-1);
        dfs(i+1, n, nums, ans, sub);

    }
}
