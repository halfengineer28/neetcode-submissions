class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> one = new HashMap<>();
        HashMap<Character, Integer> two = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            one.put(s.charAt(i), one.getOrDefault(s.charAt(i), 0)+1);
            two.put(t.charAt(i), two.getOrDefault(t.charAt(i), 0)+ 1);
        }

        return one.equals(two);
    }
}
