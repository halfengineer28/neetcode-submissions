class Solution {
    public int lengthOfLongestSubstring(String s) {
      int l = 0;
      int r = 0;
     
      int maxlength = 0;
      HashSet<Character> set = new HashSet<>();

      while (r < s.length()){
        if (!set.contains(s.charAt(r))){
            set.add(s.charAt(r));
            maxlength = Math.max(maxlength, (r - l +1));
            r++;
        }else{
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
        }
    
      }
    return maxlength;
    }
}
