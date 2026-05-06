class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, n, nums, ans, res);
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
        while (i + 1 < n && nums[i] == nums[i+1] ){
            i++;
        }
        dfs(i+1, n, nums, ans, sub);

    }
}
