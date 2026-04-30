class Solution {
    public int longestConsecutive(int[] nums) {
        int maxlength = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);

        }

        for (int num : set){
            
            if(!set.contains(num-1)){
                int length = 0;
                
                while (set.contains(num + length)){
                    length++;
                    
                }
                maxlength = Math.max(maxlength, length);

            }
        }

        return maxlength;
        
    }
}
