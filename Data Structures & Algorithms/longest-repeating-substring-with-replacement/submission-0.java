class Solution {
    public int characterReplacement(String s, int k) {
        int maxlength = 0;
        
        Set<Character> set = new HashSet<>();

        

        for (char c : s.toCharArray()){
            set.add(c);
        }

        for (char c : set){
            int count = 0;
            int left = 0;
            int right = 0;
            while (right < s.length()){
                if (s.charAt(right) == c){
                    count++;
                }

                if ((right - left + 1 ) - count > k){
                    if (s.charAt(left) == c){
                        count--;
                       
                    }
                     left++;
                }
                maxlength = Math.max(maxlength, right-left+1);
                right++;
            }
        }

    

       
        return maxlength;
    }
}
