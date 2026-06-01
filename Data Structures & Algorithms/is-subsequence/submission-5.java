class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0){
            return true;
        }
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;

        while(right < t.length() && left < s.length()){
            if (s.charAt(left) == t.charAt(right)){
                sb.append(s.charAt(left));
                left++;
            }
            right++;
        } 
        String res = sb.toString();
        return res.equals(s);       
    }
}