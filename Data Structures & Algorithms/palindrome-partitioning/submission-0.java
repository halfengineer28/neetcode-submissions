class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> res = new ArrayList<>();
        dfs(ans, s, res, 0);
        return ans;
    }
    public void dfs(List<List<String>> ans, String s, List<String> res, int i){
        if (i >= s.length()){
            ans.add(new ArrayList<>(res));
            return;

        }

        for (int j = i; j < s.length(); j++){
            if (isPalin(s, i, j)){
                res.add(s.substring(i, j+1));
                dfs(ans,s, res, j + 1);
                res.remove(res.size()-1);

            }

        }
    }
    public boolean isPalin(String s, int i, int j){
        while(i <= j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
