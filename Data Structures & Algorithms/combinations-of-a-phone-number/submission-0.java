class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6',
            "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        
        List<String> ans = new ArrayList<>();
        if (digits.equals("")){
            return ans;
        }
        StringBuilder sb = new StringBuilder();
        dfs(ans,sb, digits, map, 0);
        return ans;
    }
    public void dfs(List<String> ans, StringBuilder sb, String digits, Map<Character, String> map,int index){
        if (index == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String letters = map.get(digits.charAt(index));
        for(char c  : letters.toCharArray()){
            sb.append(c);
            dfs(ans, sb, digits, map, index + 1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
