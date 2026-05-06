class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        boolean [] bool = new boolean [n];
        dfs(ans, nums, res, bool);
        return ans;
        
    }
    public void dfs(List<List<Integer>> ans, int [] nums, List<Integer>res, boolean [] bool){
        if(res.size() == nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if (bool[i] == true){
                continue;
            }
            bool[i] = true;
            res.add(nums[i]);
            dfs(ans, nums, res, bool);
            res.remove(res.size() -1);
            bool[i] = false;
        }

    
    }
}
