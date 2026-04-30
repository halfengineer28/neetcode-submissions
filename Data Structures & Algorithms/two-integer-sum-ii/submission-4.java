class Solution {
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start < end){
            int ans = nums[start] + nums[end];
            if (ans == target){
                return new int [] {start + 1, end + 1};
            } else if (ans < target) {
                start++;
            }else{
                end--;
            }

        }
        return new int[] {-1, -1};
        
    }
}
