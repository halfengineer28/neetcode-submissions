class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()){
            return"";
        }
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> countS = new HashMap<>();
        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0)+ 1);
        }
        int [] res = {-1, -1};
        int have = 0;
        int need = countT.size();
        int resLen = Integer.MAX_VALUE;
        int l = 0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            countS.put(c, countS.getOrDefault(c, 0)+ 1);

            if(countT.containsKey(c) && countS.get(c).equals(countT.get(c))){
                have++;
            }
            while(have == need){
                if((i - l + 1) < resLen){
                    resLen = i- l + 1;
                    res[0] = l;
                    res[1] = i;
                }

                char leftChar = s.charAt(l);
                countS.put(leftChar, countS.getOrDefault(leftChar, 0) - 1 );
                if(countT.containsKey(leftChar) && countS.get(leftChar) < countT.get(leftChar)){
                    have--;
                }
                l++;
            }
            
            
        }
        
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]+1);
        
        
        
    }
}
