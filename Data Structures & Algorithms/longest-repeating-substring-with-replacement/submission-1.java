class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;

        for (char c : s.toCharArray()){
            set.add(c);
        }

        for (char ch : set){
            int l = 0;
            int r = 0;
            int cnt = 0;

            while (r < s.length()){
                if (s.charAt(r) == ch){
                    cnt++;
                   

                }

                while((r-l + 1) - cnt > k){
                    if (s.charAt(l) == ch){
                        cnt--;
                    }
                    l++;
                }
                maxLength = Math.max(maxLength, (r-l + 1));
                r++;
            }
        }
        return maxLength;
        
    }
}
