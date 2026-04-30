class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer , Integer> mpp = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i<n; i++){
           if(mpp.containsKey(nums[i])){
            return true;
           }

           mpp.put(nums[i], 1);
        }
        return false;
 
    }
}
