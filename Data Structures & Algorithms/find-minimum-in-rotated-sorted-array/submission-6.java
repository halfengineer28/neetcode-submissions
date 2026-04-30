class Solution {
    public int findMin(int[] nums) {
        int ans = nums[0];
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            if (nums[start] < nums[end]){
                ans = Math.min(ans, nums[start]);
                break;
            }
            int mid = start + (end - start)/2;
            ans = Math.min(ans, nums[mid]);
            if (nums[start] <= nums[mid]){
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }
        return ans;
        
    }
}
