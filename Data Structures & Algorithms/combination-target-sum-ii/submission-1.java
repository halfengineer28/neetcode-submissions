class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, candidates, 0, target, res, ans);
        return ans;
        
    }
    public void dfs(int i,int [] candidates, int sum, int target, List<Integer> res, List<List<Integer>> ans){
        if (sum == target){
            ans.add(new ArrayList<>(res));
            return;
        }

        if (sum > target || i == candidates.length){
            return;
        }

        res.add(candidates[i]);
        dfs(i + 1, candidates, sum + candidates[i], target, res, ans);
        res.remove(res.size()-1);

        while(i + 1 < candidates.length && candidates[i] == candidates[i+1]){
            i++;
        }
        dfs(i + 1, candidates, sum, target, res, ans);
    }
}
