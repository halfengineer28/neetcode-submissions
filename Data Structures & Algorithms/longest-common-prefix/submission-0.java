class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        String minLen  = "";

        for (int i = 0; i < strs.length; i++){
            if (min > strs[i].length()){
                min = strs[i].length();
                minLen = strs[i];
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < minLen.length(); i++){
            char c = minLen.charAt(i);
            for (String s : strs){
                if (s.charAt(i) != c){
                    return ans.toString();
                }
            }
            ans.append(c);
        }
        return ans.toString();
    }
}