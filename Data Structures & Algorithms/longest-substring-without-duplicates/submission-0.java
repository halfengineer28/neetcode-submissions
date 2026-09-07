class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlength = 0;

        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()){

            while (left < s.length() && set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }


            set.add(s.charAt(right));
            maxlength = Math.max(maxlength,(right - left + 1));
            right++;

        }
        return maxlength;

    }
}
