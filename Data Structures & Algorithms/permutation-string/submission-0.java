class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int left = 0;
        int right = s1.length()-1;
        char [] str = s1.toCharArray();
        Arrays.sort(str);
        String have = new String(str);

        while (right < s2.length()){
            String need = s2.substring(left, right+1);
            char [] sorted = need.toCharArray();
            Arrays.sort(sorted);
            String exists = new String(sorted);
            if (have.equals(exists)){
                return true;
            }else{
                left++;
                right++;
            }


        }

       
       return false; 
    }
}
