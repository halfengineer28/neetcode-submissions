class Solution {
    public int lengthOfLastWord(String s) {

        int length = s.length();
       
        String str = s.trim();
        int i = str.length()-1;
        if (str.length() == 1){
            return 1;
        }

        while (str.charAt(i) != ' '){
            i--;
        }
      
        return str.length()-1-i;
    }
}