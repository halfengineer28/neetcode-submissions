class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char [] s1char = s1.toCharArray();
        Arrays.sort(s1char);
        String s1new = new String(s1char);
        int left = 0;
        int right = s1.length();

        while(right <= s2.length()){
            String sub = s2.substring(left, right);
            char [] subchar = sub.toCharArray();
            Arrays.sort(subchar);
            String ans = new String(subchar);
            if (ans.equals(s1new)){
                return true;
            }
            left++;
            right++;
            

        }
        return false;
        
    }
}
