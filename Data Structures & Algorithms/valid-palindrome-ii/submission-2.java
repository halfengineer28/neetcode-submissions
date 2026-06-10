class Solution {
    public boolean validPalindrome(String s) {
        return palindrome(s, 0, s.length() - 1, 0);
    }
    public boolean palindrome(String s, int start, int end, int count) {
        while (start <= end) {
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                count++;
                if (count > 1) {
                    return false;
                }
                return palindrome(s, start + 1, end, count) || palindrome(s, start, end - 1, count);
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}