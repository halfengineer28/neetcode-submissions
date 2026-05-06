class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(ans, 0, 0, n, sb);
        return ans;
        
    }
    public void dfs(List<String> ans, int open , int close, int n, StringBuilder sb){
        if (open == n && close == n){
            ans.add(sb.toString());
            return;
        }

        if (open < n){
            dfs(ans, open+1, close, n, sb.append("("));
            sb.deleteCharAt(sb.length()-1);
        }

        if (close < open){
            dfs(ans, open, close+1, n, sb.append(")"));
            sb.deleteCharAt(sb.length()-1);
        }
      
    }
}
